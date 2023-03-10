package com.fresonlabs.aventura.domain.command;

import java.util.Map;
import java.util.Optional;

import com.fresonlabs.aventura.domain.game.GameService;
import com.fresonlabs.aventura.domain.gamerequest.GameRequestModel;
import com.fresonlabs.aventura.domain.player.PlayerModel;
import com.fresonlabs.aventura.domain.player.PlayerRepository;
import com.fresonlabs.aventura.domain.room.RoomModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandWalk extends Command {

  CommandWalk(GameService gameService, CommandLogger commandLogger, PlayerRepository playerRepository) {
    super(gameService, commandLogger, playerRepository);
  }

  @Override
  @EventListener(condition = "#gameRequest.getParsedCommand().getVerb().equals('mover')")
  public void execute(GameRequestModel gameRequest) {
    Optional<PlayerModel> currentPlayer = this.gameService.getPlayer(gameRequest.getGameId(), this.getUid());

    currentPlayer.ifPresent(player -> {
      Optional<RoomModel> currentRoom = this.gameService.getPlayerRoom(currentPlayer.get());
      currentRoom.ifPresent(room -> {
        Map<String, String> exits = currentRoom.get().getExits();
        String direction = gameRequest.getParsedCommand().getNoun();

        if (exits.get(direction) != null) {
          player.setRoomId(exits.get(direction));
          this.log(player, "");
        } else {
          this.log(player, gameRequest.getOriginalCommand() + " > " + "No puedes ir ahi");
        }
      });
    });
  }
}
