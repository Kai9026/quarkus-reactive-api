package com.github.kai9026.api.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.kai9026.api.model.Player;
import com.github.kai9026.api.service.PlayerService;

import io.smallrye.mutiny.Multi;

@Path("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(final PlayerService playerService) {
        this.playerService = playerService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<Player> players() {
        return this.playerService.getPlayers();
    }
}