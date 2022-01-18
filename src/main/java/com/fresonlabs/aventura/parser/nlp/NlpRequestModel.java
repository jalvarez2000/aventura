package com.fresonlabs.aventura.parser.nlp;

import lombok.Data;

@Data
public class NlpRequestModel {
    String gameId;
    String playerId;
    String inputText;
}


