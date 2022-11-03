package com.fresonlabs.aventura.domain.game;

import com.fresonlabs.aventura.domain.player.PlayerModel;
import com.fresonlabs.aventura.domain.player.PlayerService;
import com.google.cloud.datastore.Key;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.Optional;

@Component
@Entity(name="games")
public class GameService {
    private GameRepository gameRepository;
    private PlayerService playerService;

    GameService(GameRepository gameRepository, PlayerService playerService) {
        this.gameRepository = gameRepository;
        this.playerService = playerService;
    }

    public Optional<GameModel> getGame(Key gameId) {
        return this.gameRepository.findById(gameId.toString());
    }

    public Collection<GameModel> getAllGames() {
        return this.gameRepository.getAllGames();
    }

    public Iterable<PlayerModel> getPlayers(String gameId) {
        return  this.playerService.getGamePlayers(gameId);
    }

    public GameModel getGame(String gameId) {
        return this.gameRepository.getGame(gameId);
    }
}
