package com.fresonlabs.aventura.domain.game;

import java.util.Optional;

import com.fresonlabs.aventura.domain.player.PlayerModel;
import com.fresonlabs.aventura.domain.player.PlayerService;
import com.fresonlabs.aventura.domain.room.RoomModel;
import org.springframework.stereotype.Component;

@Component
public class GameService {

  private final GameRepository gameRepository;

  private final PlayerService playerService;

  //TODO: Provisional para ahorrar coste. Habra que cachear en el futuro.
  private final Optional<GameModel> tempGame;

  GameService(GameRepository gameRepository, PlayerService playerService) {
    this.gameRepository = gameRepository;
    this.playerService = playerService;
    this.tempGame = this.gameRepository.findById("6VgFHH0eftew5fVtqPQx");
  }

  public Optional<GameModel> getGame(String gameId) {
    return this.gameRepository.findById(gameId);
  }

  public Optional<PlayerModel> getPlayer(String gameId, String playerId) {
    return tempGame
        .map(GameModel::getPlayers)
        .stream()
        .flatMap(players -> players.stream())
        .filter(playerModel -> playerModel.getId().getName().equals(playerId))
        .findFirst();
  }

  public Optional<RoomModel> getPlayerRoom(PlayerModel player) {
    return this.tempGame
        .map(GameModel::getRooms)
        .stream()
        .flatMap(rooms -> rooms.stream())
        .filter(roomModel -> roomModel.getId().getName().equals(player.getRoomId()))
        .findFirst();
  }

}
