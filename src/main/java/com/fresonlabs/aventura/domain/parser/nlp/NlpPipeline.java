package com.fresonlabs.aventura.domain.parser.nlp;

import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Slf4j
@Component
public class NlpPipeline {
    private StanfordCoreNLP standfordCoreNLP;
    private Properties properties;

    private NlpPipeline() throws IOException {
        properties = new Properties();
        properties.load(IOUtils.readerFromString( "StanfordCoreNLP-spanish.properties" ) ) ;
        properties.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse");
        properties.setProperty("ner.useSUTime", "false");
        standfordCoreNLP = new StanfordCoreNLP(properties);
    }

    public List<CoreMap> annotateAndSplitSequences(Annotation document) {
        standfordCoreNLP.annotate(document);
        return document.get(CoreAnnotations.SentencesAnnotation.class);
    }

    public List<CoreLabel> splitTokens(CoreMap sentence) {
        List<CoreLabel> tokenList =new ArrayList<>();
        for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
            String word = token.get(CoreAnnotations.TextAnnotation.class);
            String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
            log.debug("word: " + word + ". Pos: " + pos + ". Ne: " + ne + ".Tag: " + token.tag());
            tokenList.add(token);
        }
        return tokenList;
    }
}

