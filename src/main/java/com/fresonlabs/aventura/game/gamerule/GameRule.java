package com.fresonlabs.aventura.game.gamerule;

import com.fresonlabs.aventura.game.gamecommand.GameCommandModel;

public abstract class GameRule {
    GameCommandModel gameCommand;

    GameRule(GameCommandModel gameCommand) {
        this.gameCommand = gameCommand;
    }

    public abstract String execute();
}
