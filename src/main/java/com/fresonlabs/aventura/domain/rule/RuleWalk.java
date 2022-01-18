package com.fresonlabs.aventura.domain.rule;

import com.fresonlabs.aventura.domain.GameModel;
import com.fresonlabs.aventura.domain.GameService;
import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;
import com.fresonlabs.aventura.domain.player.PlayerModel;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

public class RuleWalk extends Rule {

    RuleWalk(GameService gameService, GameRequestModel gameRequest) {
        super(gameService,gameRequest);
    }

    @Override
    public String execute() {
        Iterable<PlayerModel> players = this.gameService.getPlayers();
        GameModel game =  this.gameService.getGame(this.gameRequest.getGameId()).orElseThrow(NoSuchElementException::new);
        return "hola";


        /*final StringBuilder response = new StringBuilder("No me puedo dirigir alli.");
        if (game.isPresent()) {
            return "hola";
        }*/
    }
}
