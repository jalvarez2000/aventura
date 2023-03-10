package com.fresonlabs.aventura.domain.player;

import com.google.cloud.datastore.Key;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity(name = "players")
public class PlayerModel {

  @Id
  Key id;

  String name;

  String commandLogger;

  String roomId;
}
