package com.github.kai9026.api.model;

import com.github.kai9026.api.model.enumeration.PositionEnum;

import io.vertx.mutiny.sqlclient.Row;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private Integer id;
    private String name;
    private String alias;
    private Integer number;
    private PositionEnum position;

    public static Player from(Row row) {
        return new Player(row.getInteger("id"),
                          row.getString("name"),
                          row.getString("alias"),
                          row.getInteger("number"),
                          PositionEnum.valueOf(row.getString("position")));
    }
}