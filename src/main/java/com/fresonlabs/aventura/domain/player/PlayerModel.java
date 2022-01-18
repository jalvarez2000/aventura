package com.fresonlabs.aventura.domain.player;

import com.fresonlabs.aventura.domain.location.LocationModel;
import com.google.cloud.datastore.Key;
import lombok.Data;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;

@Data
@Entity(name="players")
public class PlayerModel {
    @Id
    Key __key__;
    String name;
    @Reference
    LocationModel  location;
}
