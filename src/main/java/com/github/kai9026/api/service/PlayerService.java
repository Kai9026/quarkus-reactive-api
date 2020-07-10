package com.github.kai9026.api.service;

import com.github.kai9026.api.model.Player;

import io.smallrye.mutiny.Multi;

public interface PlayerService {
    Multi<Player> getPlayers();
}