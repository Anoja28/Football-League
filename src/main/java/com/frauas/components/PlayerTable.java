package com.frauas.components;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.frauas.BaseController;
import com.frauas.models.Player;
import com.frauas.pages.PlayerEntryPage;

import javafx.beans.NamedArg;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayerTable extends VBox {
    private List<Player> players;

    public PlayerTable(@NamedArg("players") List<Player> players) {
        this.players = players;
        initialize();
    }

    public void initialize() {
        List<String> tableHeaderCells = Arrays.asList("First Name", "Last Name", "Team", "Number", "Position", "Age",
                "Nationality");
        HBox tableHeader = new HBox();
        tableHeader.setStyle("-fx-background-color: rgb(239, 239, 239)");
        for (String tableHeaderName : tableHeaderCells) {
            tableHeader.getChildren().add(new Label(tableHeaderName));
        }

        for (Node cell : tableHeader.getChildren()) {
            if (cell instanceof Label) {
                ((Label) cell).setPrefHeight(30);
                ((Label) cell).setPrefWidth(150);
                ((Label) cell).setCursor(Cursor.HAND);
                ((Label) cell).setAlignment(Pos.CENTER);

                cell.setOnMouseClicked(action -> {
                    getChildren().clear();

                    switch (((Label) cell).getText()) {
                        case "First Name":
                            players.sort(Comparator.comparing(Player::getFirstName));
                            break;

                        case "Last Name":
                            players.sort(Comparator.comparing(Player::getLastName));
                            break;

                        case "Team":
                            players.sort(Comparator.comparing(Player::getTeam));
                            break;

                        case "Number":
                            players.sort(Comparator.comparing(Player::getNumber));
                            break;

                        case "Position":
                            players.sort(Comparator.comparing(Player::getPosition));
                            break;

                        case "Age":
                            players.sort(Comparator.comparing(Player::getAge));
                            break;

                        case "Nationality":
                            players.sort(Comparator.comparing(Player::getAge));
                            break;

                        default:
                            break;
                    }

                    initialize();
                });
            }
        }

        getChildren().add(tableHeader);

        for (Player player : players) {
            HBox row = new HBox();
            row.getStyleClass().add("table-row");

            row.getChildren().add(new Label(player.firstName));
            row.getChildren().add(new Label(player.lastName));
            row.getChildren().add(new Label(player.team.name()));
            row.getChildren().add(new Label(Integer.toString(player.number)));
            row.getChildren().add(new Label(player.position.name()));
            row.getChildren().add(new Label(Integer.toString(player.getAge())));
            row.getChildren().add(new Label(player.nationality));

            for (Node cell : row.getChildren()) {
                if (cell instanceof Label) {
                    ((Label) cell).setPrefHeight(30);
                    ((Label) cell).setPrefWidth(150);
                    ((Label) cell).setAlignment(Pos.CENTER);
                }
            }

            row.setOnMouseClicked(action -> {
                BaseController.navigateTo(new PlayerEntryPage(player));
            });
            getChildren().add(row);
        }
    }
}
