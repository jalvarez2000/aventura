package com.fresonlabs.aventura.domain.rule;

import com.fresonlabs.aventura.domain.GameService;
import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;

public class RuleGet extends Rule {
    RuleGet(GameService gameService, GameRequestModel gameRequest) {
        super(gameService,gameRequest);
    }

    @Override
    public String execute() {
        return "Voy a coger algo";
    }
}
