package com.fresonlabs.aventura.domain.command;

import com.fresonlabs.aventura.domain.game.GameService;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class Command {

  GameService gameService;

  Command(GameService gameService) {
    this.gameService = gameService;
  }

  protected String getUid() {
    return SecurityContextHolder.getContext().getAuthentication().getName();
  }
}
