package com.fresonlabs.aventura.game.gamecommand;

import com.fresonlabs.aventura.game.gamerule.GameRule;
import com.fresonlabs.aventura.game.gamerule.GameRuleFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class GameCommandSubscriber {
    private GameRuleFactory gameFactory;

    GameCommandSubscriber(GameRuleFactory gameFactory) {
        this.gameFactory = gameFactory;
    }

    @RabbitListener(queues =  "${rabbitMq.queue}")
    public void receive(GameCommandModel gameCommand) {
        System.out.println(" [x] " + gameCommand.toString());
        GameRule gameRule = gameFactory.createGameRule(gameCommand);
        gameRule.execute();
    }
}
