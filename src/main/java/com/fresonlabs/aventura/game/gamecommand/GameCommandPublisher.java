package com.fresonlabs.aventura.game.gamecommand;

import com.fresonlabs.aventura.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class GameCommandPublisher {
    private AmqpTemplate template;
    private final RabbitMQConfig config;

    GameCommandPublisher(RabbitMQConfig config, AmqpTemplate template) {
        this.config = config;
        this.template = template;
    }

    public void send(GameCommandModel gameCommand) {
        template.convertAndSend(config.getExchange(), config.getRoutingKey(), gameCommand);
    }


}
