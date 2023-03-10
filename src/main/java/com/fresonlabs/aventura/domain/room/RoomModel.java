package com.fresonlabs.aventura.domain.room;

import java.util.Map;

import com.google.cloud.datastore.Key;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity(name = "rooms")
public class RoomModel {

  @Id
  Key id;

  String description;

  String name;

  Map<String, String> exits;
}
