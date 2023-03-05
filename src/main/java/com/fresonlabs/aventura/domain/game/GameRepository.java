package com.fresonlabs.aventura.domain.game;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface GameRepository extends DatastoreRepository<GameModel, String> {

}
