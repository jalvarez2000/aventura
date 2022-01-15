package com.fresonlabs.aventura.game.gamerule;

import com.fresonlabs.aventura.game.gamecommand.GameCommandModel;

public class GameRuleWalk extends GameRule {

    GameRuleWalk(GameCommandModel gameCommand) {
        super(gameCommand);
    }

    @Override
    public String execute() {
        return "Voy a moverme";
    }
}
