package com.fresonlabs.aventura.domain;

import com.fresonlabs.aventura.domain.location.LocationModel;
import com.fresonlabs.aventura.domain.player.PlayerModel;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Descendants;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity(name="games")
public class GameModel {
    @Id
    String id;

    @Descendants
    List<LocationModel> locations;
    @Descendants
    List<PlayerModel> players;

    GameModel(List<LocationModel> locations, List<PlayerModel> players) {
        this.locations = locations;
        this.players = players;
    }

    public String getId() {
        return this.id;
    }

}
