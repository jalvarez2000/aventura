package com.fresonlabs.aventura.domain.command;

import com.fresonlabs.aventura.domain.game.GameService;
import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;
import com.fresonlabs.aventura.domain.player.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandGet extends Command {

  CommandGet(GameService gameService, CommandLogger commandLogger, PlayerRepository playerRepository) {
    super(gameService, commandLogger, playerRepository);
  }

  @Override
  @EventListener(condition = "#gameRequest.getParsedCommand().getVerb().equals('coger')")
  public void execute(GameRequestModel gameRequest) {
    log.info("Solicitud de coger pedida");
  }
}
