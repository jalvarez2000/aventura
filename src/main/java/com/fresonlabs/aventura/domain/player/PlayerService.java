package com.fresonlabs.aventura.domain.player;

import org.springframework.stereotype.Component;

@Component
public class PlayerService {
    private PlayerRepository playerRepository;

    PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Iterable<PlayerModel> getAllPlayers() {
        return this.playerRepository.findAll();
    }

    public Iterable<PlayerModel> getGamePlayers(String gameId) {
        return this.playerRepository.getGamePlayers(gameId);
    }

}
