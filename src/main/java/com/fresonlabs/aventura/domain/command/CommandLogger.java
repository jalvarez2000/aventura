package com.fresonlabs.aventura.domain.command;

import com.fresonlabs.aventura.domain.player.PlayerModel;
import com.fresonlabs.aventura.domain.player.PlayerRepository;
import org.springframework.stereotype.Component;

@Component
public class CommandLogger {

  PlayerRepository playerRepository;

  CommandLogger(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  public void log(PlayerModel player, String message) {
    player.setCommandLogger(message);
    playerRepository.save(player);
  }
}
