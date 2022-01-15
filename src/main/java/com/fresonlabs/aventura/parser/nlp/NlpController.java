package com.fresonlabs.aventura.parser.nlp;


import com.fresonlabs.aventura.game.gamecommand.GameCommandModel;
import com.fresonlabs.aventura.game.gamecommand.GameCommandPublisher;
import com.fresonlabs.aventura.game.gamerule.GameRule;
import com.fresonlabs.aventura.game.gamerule.GameRuleFactory;
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
    private GameRuleFactory gameRuleFactory;

    NlpController(NlpPipeline pipeline, LemmaService lemmaService, GameCommandPublisher publisher, GameRuleFactory gameRuleFactory) {
        this.pipeline = pipeline;
        this.lemmaService = lemmaService;
        this.gameRuleFactory = gameRuleFactory;
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
                    .player("N8REpJ21y86Kvyuel2xW")
                    .build();

            if (gameCommand.getVerb().isEmpty() == false && gameCommand.getNoun().isEmpty() == false)  {
                GameRule gameRule = this.gameRuleFactory.createGameRule(gameCommand);
                response = gameRule.execute();
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
