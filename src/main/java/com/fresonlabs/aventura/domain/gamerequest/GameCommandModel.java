package com.fresonlabs.aventura.domain.gamerequest;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class GameCommandModel {
    String verb;
    String noun;
}
