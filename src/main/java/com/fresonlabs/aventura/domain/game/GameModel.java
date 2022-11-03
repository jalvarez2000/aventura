package com.fresonlabs.aventura.domain.game;

import com.fresonlabs.aventura.domain.location.LocationModel;
import com.fresonlabs.aventura.domain.player.PlayerModel;
import com.google.cloud.datastore.Key;
import com.google.cloud.spring.data.datastore.core.mapping.Descendants;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Entity(name="games")
public class GameModel {
    @Id
    Key id;

    @Descendants
    List<LocationModel> locations;
    @Descendants
    List<PlayerModel> players;
}
