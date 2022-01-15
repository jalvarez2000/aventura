package com.fresonlabs.aventura.game.gamelocation;

import lombok.Data;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Data
@Entity(name="locations")
public class GameLocationModel {
    @Id
    String id;

    String description;
    String name;
}
