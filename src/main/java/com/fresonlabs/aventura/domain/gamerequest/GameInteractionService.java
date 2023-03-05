package com.fresonlabs.aventura.domain.gamerequest;

import org.springframework.stereotype.Component;

@Component
public class GameInteractionService {

  private final GameInteractionRepository gameInteractionRepository;

  public GameInteractionService(GameInteractionRepository gameInteractionRepository) {
    this.gameInteractionRepository = gameInteractionRepository;
  }

  public void updateGameInteraction(GameInteractionModel gameInteraction, String gameId, String playerId) {

    this.gameInteractionRepository.updateInteraction(gameInteraction, gameId, playerId);
  }
}
