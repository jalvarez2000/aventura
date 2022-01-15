package com.fresonlabs.aventura.game;


import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

@Repository
interface GameRepository extends DatastoreRepository<GameModel, String> {

}
