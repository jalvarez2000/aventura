package com.fresonlabs.aventura.domain.player;

import org.springframework.stereotype.Component;

@Component
public class PlayerService {

  private final PlayerRepository playerRepository;

  PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

}
