package com.fresonlabs.aventura.game;
import org.springframework.cloud.gcp.data.datastore.core.DatastoreResultsCollection;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.stereotype.Component;

@Component
@Entity(name="games")
public class GameService {
    private GameRepository gameRepository = null;

    GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    void getAllGames() {
        DatastoreResultsCollection<GameModel> games = (DatastoreResultsCollection<GameModel>) this.gameRepository.findAll();
    }
}
