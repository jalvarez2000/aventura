package com.fresonlabs.aventura.domain.player;

import com.fresonlabs.aventura.domain.location.LocationModel;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;

@Data
@Entity(name="players")
public class PlayerModel {
    @Id
    String id;
    String name;
    @Reference
    LocationModel  location;
}
