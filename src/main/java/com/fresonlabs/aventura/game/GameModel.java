package com.fresonlabs.aventura.game;

import com.fresonlabs.aventura.game.gamelocation.GameLocationModel;
import com.fresonlabs.aventura.game.gameplayer.GamePlayerModel;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Descendants;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity(name="games")
public class GameModel {
    @Id
    String id;

    @Descendants
    List<GameLocationModel> locations;
    @Descendants
    List<GamePlayerModel> players;

    GameModel(List<GameLocationModel> locations, List<GamePlayerModel> players) {
        this.locations = locations;
        this.players = players;
    }

    public String getId() {
        return this.id;
    }

}
