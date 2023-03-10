package com.fresonlabs.aventura.domain.command;

import com.fresonlabs.aventura.domain.game.GameService;
import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;
import com.fresonlabs.aventura.domain.player.PlayerModel;
import com.fresonlabs.aventura.domain.player.PlayerRepository;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class Command {

  GameService gameService;

  CommandLogger commandLogger;

  PlayerRepository playerRepository;

  Command(GameService gameService, CommandLogger commandLogger, PlayerRepository playerRepository) {
    this.gameService = gameService;
    this.commandLogger = commandLogger;
    this.playerRepository = playerRepository;
  }

  protected String getUid() {
    return SecurityContextHolder.getContext().getAuthentication().getName();
  }

  protected void log(PlayerModel player, String message) {
    this.commandLogger.log(player, message);
  }

  public abstract void execute(GameRequestModel gameRequest);
}