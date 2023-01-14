package com.frauas.components;

import java.util.Arrays;
import java.util.List;

import com.frauas.models.Team;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LeagueTable extends VBox {
    public LeagueTable() {
        initialize();
    }

    public void initialize() {
        List<String> tableHeaderCells = Arrays.asList("TEAM", "P", "W", "D", "L", "GF", "GA", "GD", "PTS");
        HBox tableHeader = new HBox();
        tableHeader.setStyle("-fx-background-color: rgb(239, 239, 239)");
        for (String tableHeaderName : tableHeaderCells) {
            tableHeader.getChildren().add(new Label(tableHeaderName));
        }

        for (Node cell : tableHeader.getChildren()) {
            if (cell instanceof Label) {
                ((Label) cell).setPrefHeight(30);
                ((Label) cell).setPrefWidth(150);
                ((Label) cell).setAlignment(Pos.CENTER);
            }
        }

        getChildren().add(tableHeader);

        for (Team team : Team.values()) {
            HBox row = new HBox();
            row.getStyleClass().add("table-row");

            row.getChildren().add(new Label(team.name()));
            row.getChildren().add(new Label(Integer.toString(team.p)));
            row.getChildren().add(new Label(Integer.toString(team.w)));
            row.getChildren().add(new Label(Integer.toString(team.d)));
            row.getChildren().add(new Label(Integer.toString(team.l)));
            row.getChildren().add(new Label(Integer.toString(team.gf)));
            row.getChildren().add(new Label(Integer.toString(team.ga)));
            row.getChildren().add(new Label(Integer.toString(team.gd)));
            row.getChildren().add(new Label(Integer.toString(team.pts)));

            for (Node cell : row.getChildren()) {
                if (cell instanceof Label) {
                    ((Label) cell).setPrefHeight(30);
                    ((Label) cell).setPrefWidth(150);
                    ((Label) cell).setAlignment(Pos.CENTER);
                }
            }
            getChildren().add(row);
        }
    }
}
