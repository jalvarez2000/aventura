package com.fresonlabs.aventura.domain.game;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.google.cloud.spring.data.datastore.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
interface GameRepository extends DatastoreRepository<GameModel, String> {
    @Query("SELECT * FROM GAMES")
    Collection<GameModel> getAllGames();

    @Query("SELECT * from games WHERE __key__ = KEY(games,'xtpxt99xivVwU434Ucwf')")
    GameModel getGame(String gameId);
}
