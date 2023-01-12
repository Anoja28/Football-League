package com.frauas;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;

public class BaseController {

    @FXML
    VBox menuContainer;

    @FXML
    ScrollPane scrollPane;

    @FXML
    Button tabHome;

    @FXML
    Button tabMatches;

    @FXML
    Button tabPlayers;

    @FXML
    Button tabCreate;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void gotoHome() throws IOException {
        scrollPane.setContent(App.loadFXML("home"));
        selectTab(tabHome);
    }

    @FXML
    private void gotoPlayers() throws IOException {
        scrollPane.setContent(App.loadFXML("players"));
        selectTab(tabPlayers);
    }

    @FXML
    private void gotoCreate() throws IOException {
        scrollPane.setContent(App.loadFXML("create"));
        selectTab(tabCreate);
    }

    @FXML
    private void gotoMatches() throws IOException {
        scrollPane.setContent(App.loadFXML("matches"));
        selectTab(tabMatches);
    }

    private void selectTab(Button btn) {
        for (Node node : menuContainer.getChildren()) {
            if (node instanceof Button && node != btn) {
                ((Button) node).setStyle("-fx-background-color: black;");
            }
        }

        btn.setStyle("-fx-background-color: #aba2f9;");
    }

    public void initialize() throws IOException {
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollPane.setContent(App.loadFXML("home"));

        tabHome.setStyle("-fx-background-color: #aba2f9;");
    }

}