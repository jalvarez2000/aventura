package com.fresonlabs.aventura.domain.command;

import com.fresonlabs.aventura.domain.game.GameService;
import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandGet extends Command {
    CommandGet(GameService gameService) {
        super(gameService);
    }

    @EventListener(condition = "#gameRequest.getGameCommand().getVerb().equals('coger')")
    public void handleGameRequest(GameRequestModel gameRequest) {
        log.info("Solicitud de coger pedida");
    }
}
