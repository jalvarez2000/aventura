package com.fresonlabs.aventura.parser.nlp;


import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;
import com.fresonlabs.aventura.domain.gamerequest.GameCommandModel;
import com.fresonlabs.aventura.domain.rule.Rule;
import com.fresonlabs.aventura.domain.rule.RuleFactory;
import com.fresonlabs.aventura.parser.lemma.LemmaService;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan("com.fresonlabs.aventura.parser.lemma")
@RestController
@RequestMapping(path = "/nlp")
public class NlpController {
    private NlpPipeline pipeline;
    private LemmaService lemmaService;
    private RuleFactory ruleFactory;

    NlpController(NlpPipeline pipeline, LemmaService lemmaService, RuleFactory ruleFactory) {
        this.pipeline = pipeline;
        this.lemmaService = lemmaService;
        this.ruleFactory = ruleFactory;
    }

    @GetMapping("process")
    @ResponseBody
    public NlpResponseModel process(@RequestBody NlpRequestModel nlpText) throws Exception {
        String response ="No te entiendo.";
        Annotation document = new Annotation(nlpText.getInputText());
        List<CoreMap> sequences = pipeline.annotateAndSplitSequences(document);
        for (CoreMap sequence : sequences) {
            List<CoreLabel> tokens = pipeline.splitTokens(sequence);
            GameCommandModel gameCommand = GameCommandModel.builder()
                    .noun(this.getCommandItem(tokens,"NOUN"))
                    .verb(this.getCommandItem(tokens,"VERB"))
                    .build();
            GameRequestModel gameAppRequest = GameRequestModel.builder()
                    .playerId(nlpText.getPlayerId())
                    .gameId(nlpText.gameId)
                    .gameCommand(gameCommand)
                    .build();


            if (gameCommand.getVerb().isEmpty() == false && gameCommand.getNoun().isEmpty() == false)  {
                Rule rule = this.ruleFactory.createGameRule(gameAppRequest);
                response = rule.execute();
            }
        }
        return NlpResponseModel.builder()
                .response(response)
                .build();
    }

    public String getCommandItem(List<CoreLabel> document,String type) {
        String item = "";
        for (CoreLabel coreLabel : document) {
            if (coreLabel.tag().equals(type)) {
                if (type.equals("VERB")) {
                    item = lemmaService.findRootAction(coreLabel.word());
                } else {
                    item = coreLabel.word();
                }
            }
        }
        return item;
    }
}
