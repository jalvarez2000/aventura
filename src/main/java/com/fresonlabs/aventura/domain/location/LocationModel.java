package com.fresonlabs.aventura.domain.location;

import com.google.cloud.datastore.Key;
import lombok.Data;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Data
@Entity(name="locations")
public class LocationModel {
    @Id
    Key __key__;
    String description;
    String name;
}
