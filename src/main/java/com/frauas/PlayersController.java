package com.frauas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.conversions.Bson;

import com.frauas.components.PlayerTable;
import com.frauas.database.DatabaseAPI;
import com.frauas.models.Player;
import com.frauas.models.Position;
import com.frauas.models.Team;
import com.mongodb.client.model.Filters;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayersController {
    @FXML
    VBox tableContainer;

    @FXML
    HBox pageSelectContainer;

    @FXML
    TextField searchTF;

    @FXML
    ComboBox<String> nationCB;

    @FXML
    ComboBox<String> teamCB;

    @FXML
    ComboBox<String> posCB;

    private int currentPage = 1;
    private Bson currentFilter = Filters.empty();
    private List<Player> players = new ArrayList<>();
    private HashMap<String, Bson> activeFilters = new HashMap<>();
    public static int pageSize = 20;

    private void update() {
        tableContainer.getChildren().clear();
        pageSelectContainer.getChildren().clear();
        build();
    }

    private void build() {
        int totalDocsCount = DatabaseAPI.getPlayerCount(currentFilter);
        int pageCount = totalDocsCount / pageSize;
        players = DatabaseAPI.getPlayers(currentPage, currentFilter);
        tableContainer.getChildren().add(new PlayerTable(players));
        Label prevPage = new Label("⟵ PAGE " + (currentPage - 1));
        Label nextPage = new Label("PAGE " + (currentPage + 1) + " ⟶");
        for (Label mdBtn : Arrays.asList(prevPage, nextPage)) {
            mdBtn.getStyleClass().add("matchday-select-btn");
        }

        nextPage.setOnMouseClicked(action -> {
            currentPage++;
            update();
        });

        prevPage.setOnMouseClicked(action -> {
            currentPage--;
            update();
        });

        if (currentPage > 1) {
            pageSelectContainer.getChildren().add(prevPage);
        }

        for (int i = 1; i < pageCount; i += 2) {
            Label pageLabel = new Label(Integer.toString(i));
            pageLabel.getStyleClass().add("matchday-select-btn");
            if (Integer.valueOf(pageLabel.getText()) == currentPage) {
                pageLabel.setStyle("-fx-background-color: black; -fx-text-fill: white;");
            }
            pageLabel.setOnMouseClicked(action -> {
                currentPage = Integer.valueOf(pageLabel.getText());
                update();
            });
            pageSelectContainer.getChildren().add(pageLabel);
        }

        if (currentPage < totalDocsCount / pageSize) {
            pageSelectContainer.getChildren().add(nextPage);
        }
    }

    private void filter() {
        currentFilter = Filters.empty();
        for (String category : activeFilters.keySet()) {
            currentFilter = Filters.and(currentFilter, activeFilters.get(category));
        }
        currentPage = 1;
        update();
    }

    public void initialize() {
        searchTF.prefHeightProperty().bind(teamCB.heightProperty());

        searchTF.setOnKeyPressed(action -> {
            if (action.getCode() == KeyCode.ENTER) {
                if (searchTF.getText() == null || searchTF.getText().isBlank()) {
                    activeFilters.remove("search");
                } else {
                    Pattern pattern = Pattern.compile("^" + searchTF.getText() + "$", Pattern.CASE_INSENSITIVE);
                    activeFilters.put("search", Filters.or(
                            Filters.regex("firstName", pattern),
                            Filters.regex("lastName", pattern)));
                }
                filter();
            }
        });

        for (ComboBox<?> cBox : Arrays.asList(teamCB, posCB, nationCB)) {
            cBox.getItems().add(null);
        }

        List<String> teamCBVals = new ArrayList<>();
        for (Team team : Team.values()) {
            teamCBVals.add(team.name());
        }

        List<String> posCBVals = new ArrayList<>();
        for (Position position : Position.values()) {
            posCBVals.add(position.name());
        }

        teamCB.getItems().addAll(teamCBVals);
        posCB.getItems().addAll(posCBVals);
        nationCB.getItems().addAll(DatabaseAPI.getDistinctNations());

        teamCB.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            insertIntoFilterMap(newVal, "team");
        });

        posCB.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            insertIntoFilterMap(newVal, "position");
        });

        nationCB.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            insertIntoFilterMap(newVal, "nationality");
        });

        build();
    }

    private void insertIntoFilterMap(String value, String field) {
        if (value == null || value.isBlank()) {
            activeFilters.remove(field);
        } else {
            activeFilters.put(field, Filters.eq(field, value));
        }
        filter();
    }
}
