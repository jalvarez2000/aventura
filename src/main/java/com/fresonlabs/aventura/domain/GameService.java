package com.fresonlabs.aventura.domain;

import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;
import com.fresonlabs.aventura.domain.player.PlayerModel;
import com.fresonlabs.aventura.domain.player.PlayerService;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
@Entity(name="games")
public class GameService {
    private GameRepository gameRepository;
    private PlayerService playerService;

    GameService(GameRepository gameRepository, PlayerService playerService) {
        this.gameRepository = gameRepository;
        this.playerService = playerService;
        ;
    }

    public Optional<GameModel> getGame(String gameId) {
        return this.gameRepository.findById(gameId);
    }

    public Collection<GameModel> getAllGames() {
        return this.gameRepository.getAllGames();
    }

    public Iterable<PlayerModel> getPlayers() {
        Iterable<PlayerModel> players =  this.playerService.getGamePlayers("xtpxt99xivVwU434Ucwf");
        return players;
    }

    public Collection<GameModel> getGame() {
        return this.gameRepository.getGame();
    }
}
