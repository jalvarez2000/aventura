package com.fresonlabs.aventura.domain.game;

import java.util.Optional;

import com.fresonlabs.aventura.domain.player.PlayerService;
import org.springframework.stereotype.Component;

@Component
public class GameService {

  private final GameRepository gameRepository;

  private final PlayerService playerService;

  GameService(GameRepository gameRepository, PlayerService playerService) {
    this.gameRepository = gameRepository;
    this.playerService = playerService;
  }

  public Optional<GameModel> getGame(String gameId) {
    return this.gameRepository.findById(gameId);
  }
}
