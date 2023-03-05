package com.fresonlabs.aventura.domain.game;

import java.util.List;

import com.fresonlabs.aventura.domain.player.PlayerModel;
import com.fresonlabs.aventura.domain.room.RoomModel;
import com.google.cloud.datastore.Key;
import com.google.cloud.spring.data.datastore.core.mapping.Descendants;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity(name = "games")
public class GameModel {

  @Id
  Key id;

  @Descendants
  List<RoomModel> rooms;

  @Descendants
  List<PlayerModel> players;

}
