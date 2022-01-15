package com.fresonlabs.aventura.game.gamerule;

import com.fresonlabs.aventura.game.gamecommand.GameCommandModel;
import org.springframework.stereotype.Component;

@Component
public class GameRuleFactory {
    public GameRule createGameRule(GameCommandModel gameCommand) {
        if (gameCommand.getVerb().equalsIgnoreCase("MOVER")) {
            return new GameRuleWalk(gameCommand);
        } else if (gameCommand.getVerb().equalsIgnoreCase("COGER")) {
            return new GameRuleGet(gameCommand);
        }
        return null;
    }
}
