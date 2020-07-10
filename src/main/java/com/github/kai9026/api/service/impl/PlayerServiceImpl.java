package com.github.kai9026.api.service.impl;


import javax.enterprise.context.ApplicationScoped;

import com.github.kai9026.api.model.Player;
import com.github.kai9026.api.service.PlayerService;

import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.pgclient.PgPool;

@ApplicationScoped
public class PlayerServiceImpl implements PlayerService {


    private final PgPool client;

    public PlayerServiceImpl(final PgPool client) {
        this.client = client;
    }

	@Override
	public Multi<Player> getPlayers() {
        return client.query("SELECT id, name, alias, number, position FROM player ORDER BY number ASC")
                     .execute()
                     .onItem()
                     .produceMulti(set -> Multi.createFrom().iterable(set))
                     .onItem().apply(Player::from);
	}

    
}