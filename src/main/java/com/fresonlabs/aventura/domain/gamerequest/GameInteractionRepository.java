package com.fresonlabs.aventura.domain.gamerequest;

import com.fresonlabs.aventura.domain.game.GameModel;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

@Repository
interface GameInteractionRepository extends DatastoreRepository<GameModel, String> {

  // Create an update intertacion method
  default void updateInteraction(GameInteractionModel interaction, String gameId, String roomId) {
    
  }

}
