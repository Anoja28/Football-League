package com.frauas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import models.Club;
import models.Player;
import models.Position;

public class SecondaryController {

    @FXML
    VBox menuContainer;

    @FXML
    ScrollPane scrollPane;

    @FXML
    TilePane clubsDisplay;

    @FXML
    VBox tableContainer;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    public void initialize() {
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);

        clubsSection();
        tableSection();
    }

    private void clubsSection() {
        List<Club> clubs = Arrays.asList(Club.values());

        for (Club club : clubs) {
            VBox clubCard = new VBox();
            clubCard.getStyleClass().add("club-card");
            clubCard.setPrefHeight(100);
            clubCard.setPrefWidth(200);
            clubCard.setPadding(new Insets(4));
            clubCard.setAlignment(Pos.CENTER);
            Text clubText = new Text(club.name());
            clubText.setFill(Color.WHITE);
            clubCard.getChildren().add(clubText);

            clubsDisplay.getChildren().add(clubCard);
        }
    }

    private void tableSection() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Kevin", "Trap", Club.SGE, 1, Position.GOAL, 35));
        players.add(new Player("Evan", "Ndicka", Club.SGE, 2, Position.DEF, 35));
        players.add(new Player("Kristijan", "Jakić", Club.SGE, 6, Position.MID, 35));
        players.add(new Player("Randal", "Kolo Muani", Club.SGE, 9, Position.ATK, 35));
        players.add(new Player("Kevin", "Trap", Club.SGE, 1, Position.GOAL, 35));
        players.add(new Player("Evan", "Ndicka", Club.SGE, 2, Position.DEF, 35));
        players.add(new Player("Kristijan", "Jakić", Club.SGE, 6, Position.MID, 35));
        players.add(new Player("Randal", "Kolo Muani", Club.SGE, 9, Position.ATK, 35));

        List<String> tableHeaderCells = Arrays.asList("first name", "last name", "club", "number", "position", "age");
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

        tableContainer.getChildren().add(tableHeader);

        for (Player player : players) {
            HBox row = new HBox();
            row.getStyleClass().add("table-row");

            row.getChildren().add(new Label(player.firstName));
            row.getChildren().add(new Label(player.lastName));
            row.getChildren().add(new Label(player.club.name()));
            row.getChildren().add(new Label(Integer.toString(player.number)));
            row.getChildren().add(new Label(player.position.name()));
            row.getChildren().add(new Label(Integer.toString(player.age)));

            for (Node cell : row.getChildren()) {
                if (cell instanceof Label) {
                    ((Label) cell).setPrefHeight(30);
                    ((Label) cell).setPrefWidth(150);
                    ((Label) cell).setAlignment(Pos.CENTER);
                }
            }

            tableContainer.getChildren().add(row);
        }
    }

}