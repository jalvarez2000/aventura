package com.fresonlabs.aventura.parser.lemma;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LemmaModel {
    String root;
    List<String> dictionary;
}
