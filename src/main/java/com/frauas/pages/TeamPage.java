package com.frauas.pages;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import com.frauas.BaseController;
import com.frauas.components.PlayerTable;
import com.frauas.database.DatabaseAPI;
import com.frauas.models.Player;
import com.frauas.models.Team;

import javafx.beans.NamedArg;

public class TeamPage extends VBox {
    private Team team;

    @FXML
    Label teamName;

    @FXML
    HBox teamPageHeader;

    @FXML
    Label logoContainer;

    @FXML
    VBox content;

    public TeamPage(@NamedArg("Team") Team team) {
        this.team = team;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../team.fxml"));
        fxmlLoader.setController(this);
        try {
            getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        prefWidthProperty().bind(BaseController.root.widthProperty());
    }

    public void initialize() {
        teamPageHeader.setStyle("-fx-padding: 40; -fx-background-color: " + team.color);
        teamName.setText(team.toString().toUpperCase());

        if (team.color.equals("#ffffff")) {
            teamName.setTextFill(Color.BLACK);
        } else {
            teamName.setTextFill(Color.WHITE);
        }

        ImageView logo = new ImageView(team.logo);
        logo.setFitHeight(80);
        logo.setPreserveRatio(true);
        logoContainer.setGraphic(logo);

        List<Player> cadre = DatabaseAPI.getPlayers(team);
        PlayerTable cadreTable = new PlayerTable(cadre);

        content.getChildren().add(cadreTable);
    }
}
