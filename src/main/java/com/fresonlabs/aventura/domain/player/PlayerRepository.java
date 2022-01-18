package com.fresonlabs.aventura.domain.player;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.cloud.gcp.data.datastore.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
interface PlayerRepository extends DatastoreRepository<PlayerModel, String> {
    @Query("select * from players where ANCESTOR is 'xtpxt99xivVwU434Ucwt'")
    Collection<PlayerModel> getGamePlayers();
}
