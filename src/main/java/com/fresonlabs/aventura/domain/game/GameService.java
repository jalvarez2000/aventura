package com.fresonlabs.aventura.domain.game;

import java.util.Collection;
import java.util.Optional;

import com.fresonlabs.aventura.domain.player.PlayerModel;
import com.fresonlabs.aventura.domain.player.PlayerService;
import com.google.cloud.datastore.Key;
import org.springframework.stereotype.Component;

@Component
public class GameService {

  private final GameRepository gameRepository;

  private final PlayerService playerService;

  GameService(GameRepository gameRepository, PlayerService playerService) {
    this.gameRepository = gameRepository;
    this.playerService = playerService;
  }

  public Optional<GameModel> getGame(Key gameId) {
    return null;
  }

  public Collection<GameModel> getAllGames() {
    // return this.gameRepository.getAllGames();
    return null;
  }

  public Iterable<PlayerModel> getPlayers(String gameId) {
    // return this.playerService.getGamePlayers(gameId);
    return null;
  }

  public Optional<GameModel> getGame(String gameId) {
    return this.gameRepository.findById(gameId);
  }

  public Boolean hasPlayer(String gameId, String playerId) {
    // return this.gameRepository.hasPlayer(gameId, playerId) != null;
    return null;
  }
}
