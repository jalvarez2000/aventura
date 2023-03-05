package com.fresonlabs.aventura.domain.command;

import com.fresonlabs.aventura.domain.game.GameService;
import com.fresonlabs.aventura.domain.gamerequest.GameInteractionService;
import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandWalk extends Command {

  private final GameInteractionService gameInteractionService;

  CommandWalk(GameService gameService, GameInteractionService gameInteractionService) {
    super(gameService);
    this.gameInteractionService = gameInteractionService;
  }

  @EventListener(condition = "#gameRequest.getGameCommand().getVerb().equals('mover')")
  public void handleGameRequest(GameRequestModel gameRequest) {
    this.gameInteractionService.updateGameInteraction(gameRequest.getGameInteraction(), gameRequest.getGameId(), this.getUid());
  }
}
