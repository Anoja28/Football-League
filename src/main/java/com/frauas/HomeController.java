package com.frauas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.frauas.models.Team;
import com.frauas.models.Player;
import com.frauas.models.Position;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class HomeController {
    @FXML
    TilePane clubsDisplay;

    @FXML
    VBox tableContainer;

    @FXML
    VBox upcomingSection;

    public void initialize() {
        VBox upcomingMatch = MatchesController.matchComponent(Team.RBL, Team.FCB);
        upcomingSection.getChildren().add(upcomingMatch);

        clubsSection();
        tableSection();
    }

    private void clubsSection() {
        List<Team> clubs = Arrays.asList(Team.values());

        for (Team club : clubs) {
            Label clubCard = new Label(club.name());
            clubCard.getStyleClass().add("club-card");
            clubCard.setAlignment(Pos.CENTER);

            clubCard.setMaxHeight(80);
            clubCard.setPrefSize(80, 180);
            clubsDisplay.getChildren().add(clubCard);

            clubCard.hoverProperty().addListener((ChangeListener<Boolean>) (obs, oldVal, newVal) -> {
                if (newVal) {
                    clubCard.setText(club.toString());
                    clubCard.setStyle("-fx-font-weight: 200; -fx-font-size: 14;");
                    clubCard.setWrapText(true);
                } else {
                    clubCard.setText(club.name());
                    clubCard.setStyle("-fx-font-weight: 700; -fx-font-size: 18;");
                }
            });
        }
    }

    private void tableSection() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Kevin", "Trapp", Team.SGE, 1, Position.GOAL));
        players.add(new Player("Evan", "Ndicka", Team.SGE, 2, Position.DEF));
        players.add(new Player("Kristijan", "Jakić", Team.SGE, 6, Position.MID));
        players.add(new Player("Randal", "Kolo Muani", Team.SGE, 9, Position.ATK));
        players.add(new Player("Kevin", "Trap", Team.SGE, 1, Position.GOAL));
        players.add(new Player("Evan", "Ndicka", Team.SGE, 2, Position.DEF));
        players.add(new Player("Kristijan", "Jakić", Team.SGE, 6, Position.MID));
        players.add(new Player("Randal", "Kolo Muani", Team.SGE, 9, Position.ATK));

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
            row.getChildren().add(new Label(player.team.name()));
            row.getChildren().add(new Label(Integer.toString(player.number)));
            row.getChildren().add(new Label(player.position.name()));
            row.getChildren().add(new Label(Integer.toString(player.getAge())));

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
