package com.fresonlabs.aventura.domain.room;

import org.springframework.stereotype.Component;

@Component
public class RoomService {

  private final RoomRepository roomRepository;

  RoomService(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  public RoomModel getNextRoom(RoomModel location, String direction) {
    return null;
  }
}
