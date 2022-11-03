package com.fresonlabs.aventura.domain.command;

import com.fresonlabs.aventura.domain.game.GameService;

public abstract class Command {
    GameService gameService;

    Command(GameService gameService) {
        this.gameService = gameService;
    }
}
