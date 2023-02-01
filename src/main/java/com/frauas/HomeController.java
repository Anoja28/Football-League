package com.frauas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.frauas.models.Team;
import com.frauas.models.User;
import com.frauas.pages.TeamPage;
import com.frauas.components.MatchCard;
import com.frauas.models.Match;
import com.frauas.models.Player;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class HomeController {
    @FXML
    TilePane clubsDisplay;

    @FXML
    VBox tableContainer;

    @FXML
    VBox upcomingSection;

    @FXML
    Label welcomeLabel;

    public void initialize() {
        welcomeLabel.setText("Welcome, " + User.getInstance().getUsername());

        Match um = new Match(Team.FCA, Team.B04, 19, "WWK ARENA");
        um.date = LocalDate.of(2023, 2, 3);
        VBox upcomingMatch = new MatchCard(um);
        upcomingSection.getChildren().add(upcomingMatch);

        List<Player> players = new ArrayList<>();
        players.add(new Player("Kevin", "Trapp", 5));
        players.add(new Player("Evan", "Ndicka", 7));
        players.add(new Player("Kristijan", "Jakić", 8));
        players.add(new Player("Randal", "Kolo Muani", 1));
        players.add(new Player("Kevin", "Trap", 2));
        players.add(new Player("Evan", "Ndicka", 3));
        players.add(new Player("Kristijan", "Jakić", 16));
        players.add(new Player("Randal", "Kolo Muani", 12));

        clubsSection();
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

            clubCard.setOnMouseClicked(action -> {
                BaseController.navigateTo(new TeamPage(club));
            });
        }
    }
}
