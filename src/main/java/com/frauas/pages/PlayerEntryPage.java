package com.frauas.pages;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Locale;

import org.bson.types.ObjectId;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import com.frauas.BaseController;
import com.frauas.database.DatabaseAPI;
import com.frauas.models.Player;
import com.frauas.models.Position;
import com.frauas.models.Team;

import javafx.beans.NamedArg;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PlayerEntryPage extends VBox {
    @FXML
    Label playerPageHeader;

    @FXML
    TextField fnameTF;

    @FXML
    TextField lnameTF;

    @FXML
    ComboBox<Team> teamCB;

    @FXML
    ComboBox<Integer> numCB;

    @FXML
    ComboBox<Position> posCB;

    @FXML
    ComboBox<String> nationCB;

    @FXML
    ComboBox<Integer> dobDayCB;

    @FXML
    ComboBox<Integer> dobMonthCB;

    @FXML
    ComboBox<Integer> dobYearCB;

    @FXML
    Label msg;

    @FXML
    Button confBtn;
    Button delBtn;

    @FXML
    HBox btnContainer;

    private Player playerToEdit;

    public PlayerEntryPage(@NamedArg("player") Player playerToEdit) {
        this.playerToEdit = playerToEdit;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create.fxml"));
        fxmlLoader.setController(this);
        try {
            getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        prefWidthProperty().bind(BaseController.root.widthProperty());
    }

    public void initialize() {
        int lom = 31;

        teamCB.getItems().addAll(Team.values());
        posCB.getItems().addAll(Position.values());
        nationCB.getItems().addAll(Locale.getISOCountries());

        for (int i = 1; i < 50; i++) {
            numCB.getItems().add(i);
        }

        for (int i = 1; i <= lom; i++) {
            dobDayCB.getItems().add(i);
        }

        for (int i = 1; i <= 12; i++) {
            dobMonthCB.getItems().add(i);
        }

        for (int i = 1980; i <= 2005; i++) {
            dobYearCB.getItems().add(i);
        }

        if (playerToEdit == null) {
            confBtn.setDisable(true);
            confBtn.setText("Create");
            playerPageHeader.setText("CREATE A NEW PLAYER");

            teamCB.getSelectionModel().selectFirst();
            numCB.getSelectionModel().selectFirst();
            posCB.getSelectionModel().selectFirst();
            nationCB.getSelectionModel().selectFirst();
            dobDayCB.getSelectionModel().selectFirst();
            dobMonthCB.getSelectionModel().selectFirst();
            dobYearCB.getSelectionModel().selectFirst();

            nationCB.getSelectionModel().select("DE");
            dobYearCB.getSelectionModel().selectLast();
        } else {
            confBtn.setText("Update");
            playerPageHeader.setText(
                    "EDIT " + playerToEdit.firstName.toUpperCase() + " " + playerToEdit.lastName.toUpperCase());

            fnameTF.setText(playerToEdit.firstName);
            lnameTF.setText(playerToEdit.lastName);

            teamCB.getSelectionModel().select(playerToEdit.team);
            numCB.getSelectionModel().select(Integer.valueOf(playerToEdit.number));
            posCB.getSelectionModel().select(playerToEdit.position);
            nationCB.getSelectionModel().select(playerToEdit.nationality);
            dobDayCB.getSelectionModel().select(Integer.valueOf(playerToEdit.birthDate.getDayOfMonth()));
            dobMonthCB.getSelectionModel().select(Integer.valueOf(playerToEdit.birthDate.getMonthValue()));
            dobYearCB.getSelectionModel().select(Integer.valueOf(playerToEdit.birthDate.getYear()));

            delBtn = new Button("Delete");
            delBtn.getStyleClass().add("cancl-btn");
            delBtn.setOnAction(action -> deletePlayer(playerToEdit.id));

            btnContainer.getChildren().add(delBtn);
        }

        YearMonth y = YearMonth.of(dobYearCB.getValue(), dobMonthCB.getValue());
        lom = y.lengthOfMonth();

        ChangeListener<String> c = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                if (fnameTF.textProperty().getValue().isBlank() || lnameTF.textProperty().getValue().isBlank()) {
                    confBtn.setDisable(true);
                } else {
                    confBtn.setDisable(false);
                }
            }
        };

        fnameTF.textProperty().addListener(c);
        lnameTF.textProperty().addListener(c);
    }

    private void createPlayer() {
        Player player = new Player(
                null,
                fnameTF.getText(),
                lnameTF.getText(),
                teamCB.getValue(),
                numCB.getValue(),
                posCB.getValue(),
                LocalDate.of(dobYearCB.getValue(), dobMonthCB.getValue(), dobDayCB.getValue()),
                nationCB.getValue());

        if (DatabaseAPI.createPlayer(player)) {
            confBtn.setDisable(true);
            msg.setStyle("-fx-text-fill: #50b977");
            msg.setText("Created new Player " + player.firstName + " " + player.lastName);
        } else {
            msg.setText("Creation failed for " + player.firstName + " " + player.lastName);
            msg.setStyle("-fx-text-fill: red");
        }
    }

    private void editPlayer() {
        Player player = new Player(
                playerToEdit.id,
                fnameTF.getText(),
                lnameTF.getText(),
                teamCB.getValue(),
                numCB.getValue(),
                posCB.getValue(),
                LocalDate.of(dobYearCB.getValue(), dobMonthCB.getValue(), dobDayCB.getValue()),
                nationCB.getValue());

        if (DatabaseAPI.editPlayer(player)) {
            confBtn.setDisable(true);
            delBtn.setDisable(true);
            msg.setStyle("-fx-text-fill: #50b977");
            msg.setText("Updated Player " + playerToEdit.firstName + " " + playerToEdit.lastName);
        } else {
            msg.setText("Update failed for " + playerToEdit.firstName + " " + playerToEdit.lastName);
            msg.setStyle("-fx-text-fill: red");
        }
    }

    private void deletePlayer(ObjectId id) {
        if (DatabaseAPI.deletePlayer(id)) {
            confBtn.setDisable(true);
            delBtn.setDisable(true);
            msg.setStyle("-fx-text-fill: #50b977");
            msg.setText("Deleted Player " + playerToEdit.firstName + " " + playerToEdit.lastName);
        } else {
            msg.setText("Delete failed for " + playerToEdit.firstName + " " + playerToEdit.lastName);
            msg.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    private void playerPageAction() {
        if (playerToEdit == null) {
            createPlayer();
        } else {
            editPlayer();
        }
    }
}
