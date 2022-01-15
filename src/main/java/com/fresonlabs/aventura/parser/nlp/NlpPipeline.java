package com.fresonlabs.aventura.parser.nlp;

import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
public class NlpPipeline {
    private static StanfordCoreNLP standfordCoreNLP;
    private static Properties properties;

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
            System.out.println("word: " + token.word() + "tag" + token.tag());
            tokenList.add(token);
        }
        return tokenList;
    }
}

