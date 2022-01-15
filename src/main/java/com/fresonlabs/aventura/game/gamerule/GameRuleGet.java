package com.fresonlabs.aventura.game.gamerule;

import com.fresonlabs.aventura.game.gamecommand.GameCommandModel;

public class GameRuleGet extends  GameRule {
    GameRuleGet(GameCommandModel gameCommand) {
        super(gameCommand);
    }

    @Override
    public String execute() {
        return "Voy a coger algo";
    }
}
