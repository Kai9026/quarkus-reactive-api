package com.github.kai9026.api.controller;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.mutiny.Multi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.kai9026.api.model.Player;
import com.github.kai9026.api.model.enumeration.PositionEnum;
import com.github.kai9026.api.service.PlayerService;


@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class PlayerControllerTest {

    @InjectMock
    private PlayerService playerService;

    private Multi<Player> players;

    @BeforeEach
    public void setUp() {
        this.players = Multi.createFrom().iterable(createPlayersMockList());
    }

	@Test
    public void testPlayersEndpoint() {
        when(playerService.getPlayers()).thenReturn(players);

        given()
          .when().get("/players")
          .then()
             .statusCode(200)
             .body("size()", is(4));
    }

    private List<Player> createPlayersMockList() {
		return new ArrayList<>(Arrays.asList(
            new Player(1, "N1", "A1", 1, PositionEnum.GOALKEEPER),
            new Player(1, "N2", "A2", 2, PositionEnum.DEFENDER),
            new Player(1, "N6", "A6", 6, PositionEnum.MIDFIELDER),
            new Player(1, "N10", "A10", 10, PositionEnum.FORWARD)
        ));
	}

}