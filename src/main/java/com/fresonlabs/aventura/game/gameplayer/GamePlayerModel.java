package com.fresonlabs.aventura.game.gameplayer;

import com.fresonlabs.aventura.game.gamelocation.GameLocationModel;
import lombok.Data;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;

@Data
@Entity(name="players")
public class GamePlayerModel {
    @Id
    String id;
    String name;
    @Reference
    GameLocationModel location;
}
