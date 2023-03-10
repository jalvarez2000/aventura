package com.fresonlabs.aventura.domain.player;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface PlayerRepository extends DatastoreRepository<PlayerModel, String> {

}
