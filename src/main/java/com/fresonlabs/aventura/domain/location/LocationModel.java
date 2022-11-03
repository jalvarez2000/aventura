package com.fresonlabs.aventura.domain.location;

import com.google.cloud.datastore.Key;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity(name="locations")
public class LocationModel {
    @Id
    Key id;
    String description;
    String name;
}
