package com.fresonlabs.aventura.domain.command;

import com.fresonlabs.aventura.domain.game.GameModel;
import com.fresonlabs.aventura.domain.game.GameService;
import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;
import com.fresonlabs.aventura.domain.location.LocationModel;
import com.fresonlabs.aventura.domain.player.PlayerModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class CommandWalk extends Command {

    CommandWalk(GameService gameService) {
        super(gameService);
    }

    @EventListener(condition = "#gameRequest.getGameCommand().getVerb().equals('mover')")
    public void handleGameRequest(GameRequestModel gameRequest) {
        GameModel game =  this.gameService.getGame(gameRequest.getGameId());
        Optional<PlayerModel> player = game.getPlayers().stream()
                //.filter(item -> item.getId() == gameRequest.getPlayerId())
                .findFirst();
        if (player.isPresent()) {
            //LocationModel location = player.get().getLocation();
        }
    }
}
