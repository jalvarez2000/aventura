package com.fresonlabs.aventura.domain.parser.nlp;

import java.util.List;

import com.fresonlabs.aventura.domain.gamerequest.GameCommandModel;
import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;
import com.fresonlabs.aventura.domain.parser.lemma.LemmaService;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan("com.fresonlabs.aventura.parser.lemma")
@RestController
@RequestMapping(path = "/nlp")
public class NlpController {

  private final NlpPipeline pipeline;

  private final LemmaService lemmaService;

  private final ApplicationEventPublisher publisher;

  NlpController(NlpPipeline pipeline, LemmaService lemmaService, ApplicationEventPublisher publisher) {
    this.pipeline = pipeline;
    this.lemmaService = lemmaService;
    this.publisher = publisher;
  }

  @PostMapping("process")
  @ResponseBody
  public void process(@RequestBody NlpRequestModel nlpText) throws Exception {
    Annotation document = new Annotation(nlpText.getInputText());
    List<CoreMap> sequences = pipeline.annotateAndSplitSequences(document);
    //this.tokenValidator.verifyToken(nlpText.getPlayerId());
    for (CoreMap sequence : sequences) {
      List<CoreLabel> tokens = pipeline.splitTokens(sequence);
      GameCommandModel gameCommand = GameCommandModel.builder()
          .noun(this.getCommandItem(tokens, "NOUN"))
          .verb(this.getCommandItem(tokens, "VERB"))
          .build();

      GameRequestModel gameAppRequest = GameRequestModel.builder()
          .gameId(nlpText.gameId)
          .parsedCommand(gameCommand)
          .originalCommand(nlpText.getInputText())
          .build();

      if (!gameCommand.getVerb().isEmpty() && !gameCommand.getNoun().isEmpty()) {
        this.publisher.publishEvent(gameAppRequest);
      }
    }
  }

  public String getCommandItem(List<CoreLabel> document, String type) {
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
