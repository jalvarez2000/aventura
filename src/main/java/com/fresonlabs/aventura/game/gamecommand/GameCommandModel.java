package com.fresonlabs.aventura.game.gamecommand;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized @Builder
@Data
public class GameCommandModel {
    String player;
    String verb;
    String noun;
}
