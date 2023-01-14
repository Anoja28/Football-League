package com.frauas.pages;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.frauas.BaseController;
import com.frauas.components.LeagueTable;
import com.frauas.components.MatchCard;
import com.frauas.models.Match;
import com.frauas.models.Team;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LeaguePage extends VBox {
    @FXML
    VBox createRoot;

    @FXML
    HBox dateSelect;

    @FXML
    VBox matchesContainer;

    public LeaguePage() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../league.fxml"));
        fxmlLoader.setController(this);
        try {
            getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        prefWidthProperty().bind(BaseController.root.widthProperty());
    }

    public void initialize() {
        Map<LocalDate, List<Match>> season = new HashMap<>();
        season.put(
                LocalDate.of(2023, 1, 27),
                Arrays.asList(
                        new Match(Team.RBL, Team.VfB, 18, "Red Bull Arena")));

        season.put(
                LocalDate.of(2023, 1, 28),
                Arrays.asList(
                        new Match(Team.SCF, Team.FCA, 18, "Europa-Park Stadion"),
                        new Match(Team.M05, Team.BOC, 18, "MEWA ARENA"),
                        new Match(Team.TSG, Team.BMG, 18, "PreZero Arena"),
                        new Match(Team.BSC, Team.KOE, 18, "Olympiastadion"),
                        new Match(Team.SVW, Team.WOB, 18, "wohninvest WESERSTADION"),
                        new Match(Team.FCB, Team.SGE, 18, "Allianz Arena")));

        season.put(
                LocalDate.of(2023, 1, 29),
                Arrays.asList(
                        new Match(Team.B04, Team.BVB, 18, "BayArena")));

        for (LocalDate date : season.keySet()) {
            Label dateL = new Label(date.getDayOfWeek().name().substring(0, 3) + ", " + date.getDayOfMonth());
            dateL.getStyleClass().add("date-select-btn");

            dateL.setOnMouseClicked(action -> {
                if (dateL.getStyleClass().contains("date-select-btn-selected")) {
                    return;
                }

                matchesContainer.getChildren().clear();
                for (Match match : season.get(date)) {
                    match.date = date;
                    matchesContainer.getChildren().add(new MatchCard(match));
                }

                for (Node btn : dateSelect.getChildren()) {
                    if (btn instanceof Label) {
                        ((Label) btn).getStyleClass().clear();
                        if (btn == dateL) {
                            ((Label) btn).getStyleClass().add("date-select-btn-selected");
                        } else {
                            ((Label) btn).getStyleClass().add("date-select-btn");
                        }
                    }
                }
            });

            dateSelect.getChildren().add(dateL);
        }

        createRoot.getChildren().add(new LeagueTable());
    }
}
