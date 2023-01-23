package com.frauas.pages;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.frauas.BaseController;
import com.frauas.components.LeagueTable;
import com.frauas.components.MatchCard;
import com.frauas.models.Match;
import com.frauas.models.Season;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class LeaguePage extends VBox {
    @FXML
    VBox createRoot;

    @FXML
    Label seasonHeader;

    @FXML
    HBox matchdaySelect;

    @FXML
    HBox dateSelect;

    @FXML
    VBox matchesContainer;

    @FXML
    VBox leagueTableContainer;

    private int currentMatchday = 18;

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

    private void update() {
        for (Pane pane : Arrays.asList(
                matchdaySelect,
                dateSelect,
                matchesContainer,
                leagueTableContainer)) {
            pane.getChildren().clear();
        }

        initialize();
    }

    public void initialize() {
        seasonHeader.setText("BUNDESLIGA MATCHDAY " + currentMatchday);

        Label matchDayPrev = new Label("⟵ MATCHDAY " + (currentMatchday - 1));
        Label matchDayNext = new Label("MATCHDAY " + (currentMatchday + 1) + " ⟶");
        for (Label mdBtn : Arrays.asList(matchDayPrev, matchDayNext)) {
            mdBtn.getStyleClass().add("matchday-select-btn");
        }

        if (currentMatchday > 1) {
            matchdaySelect.getChildren().add(matchDayPrev);
        }

        if (currentMatchday < 34) {
            matchdaySelect.getChildren().add(matchDayNext);
        }

        Region mdMenuSpacer = new Region();
        HBox.setHgrow(mdMenuSpacer, Priority.ALWAYS);
        matchdaySelect.getChildren().add(mdMenuSpacer);

        Label jumpToL = new Label("JUMP TO MATCHDAY");
        jumpToL.setStyle("-fx-font-weight: 700");

        TextField jumpToTf = new TextField(String.valueOf(currentMatchday));
        jumpToTf.getStyleClass().add("tfield");
        jumpToTf.setMaxWidth(40);

        HBox jumpToContainer = new HBox();
        jumpToContainer.setAlignment(Pos.CENTER);
        jumpToContainer.setSpacing(10);
        jumpToContainer.getChildren().add(jumpToL);
        jumpToContainer.getChildren().add(jumpToTf);
        matchdaySelect.getChildren().add(jumpToContainer);

        jumpToTf.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.matches("\\d*")) {
                jumpToTf.setText(newVal.replaceAll("[^\\d]", ""));
            }
        });

        jumpToTf.setOnKeyPressed(event -> {
            int val = Integer.valueOf(jumpToTf.getText());
            if (event.getCode() == KeyCode.ENTER && val > 0 && val < 35) {
                currentMatchday = val;
                update();
            }
        });

        matchDayNext.setOnMouseClicked(action -> {
            currentMatchday++;
            update();
        });
        matchDayPrev.setOnMouseClicked(action -> {
            currentMatchday--;
            update();
        });

        Map<LocalDate, List<Match>> matchdayMap = Season.getMatchdayList(currentMatchday);

        boolean selectedFirst = false;
        for (LocalDate date : matchdayMap.keySet()) {
            Label dateL = new Label(date.getDayOfWeek().name().substring(0, 3) + ", " + date.getDayOfMonth());
            if (selectedFirst) {
                dateL.getStyleClass().add("date-select-btn");
            } else {
                dateL.getStyleClass().add("date-select-btn-selected");
                for (Match match : matchdayMap.get(date)) {
                    match.date = date;
                    matchesContainer.getChildren().add(new MatchCard(match));
                }
                selectedFirst = true;
            }

            dateL.setOnMouseClicked(action -> {
                if (dateL.getStyleClass().contains("date-select-btn-selected")) {
                    return;
                }

                matchesContainer.getChildren().clear();
                for (Match match : matchdayMap.get(date)) {
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

        leagueTableContainer.getChildren().add(new LeagueTable());
    }
}
