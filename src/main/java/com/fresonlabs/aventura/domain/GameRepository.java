package com.fresonlabs.aventura.domain;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.cloud.gcp.data.datastore.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
interface GameRepository extends DatastoreRepository<GameModel, String> {
    @Query("select * from games")
    Collection<GameModel> getAllGames();

    @Query("select id,players from games where id='xtpxt99xivVwU434Ucwf'")
    Collection<GameModel> getGame();
}
