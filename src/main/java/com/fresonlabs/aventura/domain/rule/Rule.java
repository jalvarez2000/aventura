package com.fresonlabs.aventura.domain.rule;

import com.fresonlabs.aventura.domain.GameService;
import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;

public abstract class Rule {
    GameService gameService;
    GameRequestModel gameRequest;

    Rule(GameService gameService, GameRequestModel gameRequest) {
        this.gameService = gameService;
        this.gameRequest = gameRequest;
    }

    public abstract String execute();
}
