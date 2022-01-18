package com.fresonlabs.aventura.domain.player;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class PlayerService {
    private PlayerRepository playerRepository;

    PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Iterable<PlayerModel> getAllPlayers() {
        Iterable<PlayerModel> players = this.playerRepository.findAll();
        return players;
    }

    public Iterable<PlayerModel> getGamePlayers(String gameId) {
        Iterable<PlayerModel> players = this.playerRepository.getGamePlayers();
        return  players;
    }

}
