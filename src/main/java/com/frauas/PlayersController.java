package com.frauas;

import java.util.List;

import com.frauas.components.PlayerTable;
import com.frauas.database.DatabaseAPI;
import com.frauas.models.Player;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class PlayersController {
    @FXML
    VBox tableContainer;

    public void initialize() {
        List<Player> players = DatabaseAPI.getPlayers();

        tableContainer.getChildren().add(new PlayerTable(players));
    }
}
