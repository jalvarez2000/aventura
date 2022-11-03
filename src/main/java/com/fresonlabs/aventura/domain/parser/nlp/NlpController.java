package com.fresonlabs.aventura.domain.parser.nlp;


import com.fresonlabs.aventura.authorization.TokenValidator;
import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;
import com.fresonlabs.aventura.domain.gamerequest.GameCommandModel;
import com.fresonlabs.aventura.domain.parser.lemma.LemmaService;
import com.fresonlabs.aventura.domain.command.Command;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan("com.fresonlabs.aventura.parser.lemma")
@RestController
@RequestMapping(path = "/nlp")
public class NlpController {
    private NlpPipeline pipeline;
    private LemmaService lemmaService;
    private TokenValidator tokenValidator;

    private ApplicationEventPublisher publisher;

    NlpController(NlpPipeline pipeline, LemmaService lemmaService, ApplicationEventPublisher publisher) {
        this.pipeline = pipeline;
        this.lemmaService = lemmaService;
        this.publisher = publisher;
    }

    @GetMapping("process")
    @ResponseBody
    public NlpResponseModel process(@RequestBody NlpRequestModel nlpText) throws Exception {
        String response ="No te entiendo.";
        Annotation document = new Annotation(nlpText.getInputText());
        List<CoreMap> sequences = pipeline.annotateAndSplitSequences(document);
        //this.tokenValidator.verifyToken(nlpText.getPlayerId());
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


            if (!gameCommand.getVerb().isEmpty() && !gameCommand.getNoun().isEmpty())  {
                this.publisher.publishEvent(gameAppRequest);
                response = "OK...";
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
