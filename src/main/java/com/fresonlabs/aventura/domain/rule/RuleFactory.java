package com.fresonlabs.aventura.domain.rule;

import com.fresonlabs.aventura.domain.GameService;
import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;
import org.springframework.stereotype.Component;

@Component
public class RuleFactory {

    GameService gameService;

    RuleFactory(GameService gameService) {
        this.gameService = gameService;
    }

    public Rule createGameRule(GameRequestModel gameRequest) {
        if (gameRequest.getGameCommand().getVerb().equalsIgnoreCase("MOVER")) {
            return new RuleWalk(gameService,gameRequest);
        } else if (gameRequest.getGameCommand().getVerb().equalsIgnoreCase("COGER")) {
            return new RuleGet(gameService,gameRequest);
        }
        return null;
    }
}
