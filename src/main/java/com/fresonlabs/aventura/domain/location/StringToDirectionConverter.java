package com.fresonlabs.aventura.domain.location;


import org.springframework.core.convert.converter.Converter;

public class StringToDirectionConverter implements Converter<String, Direction> {
    public Direction convert(String source) {
        try {
            return source.isEmpty() ? null : Direction.valueOf(source.trim());
        } catch(Exception e) {
            return Direction.UNKNOWN;
        }
    }
}