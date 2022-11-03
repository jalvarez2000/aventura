package com.fresonlabs.aventura.domain.player;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.google.cloud.spring.data.datastore.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
interface PlayerRepository extends DatastoreRepository<PlayerModel, String> {
    @Query("select * from players where __key__ has ancestor key(games,'xtpxt99xivVwU434Ucwf')")
    Collection<PlayerModel> getGamePlayers(@Param("game_id")String gameId);
}
