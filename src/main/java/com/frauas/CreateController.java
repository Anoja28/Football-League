package com.frauas;

import com.frauas.models.Team;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Locale;

import com.frauas.database.DatabaseAPI;
import com.frauas.models.Player;
import com.frauas.models.Position;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateController {
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
    ComboBox<Integer> heightCB;

    @FXML
    ComboBox<Integer> weightCB;

    @FXML
    ComboBox<Integer> dobDayCB;

    @FXML
    ComboBox<Integer> dobMonthCB;

    @FXML
    ComboBox<Integer> dobYearCB;

    @FXML
    Label msg;

    @FXML
    Button createBtn;

    public void initialize() {
        int lom = 31;

        teamCB.getItems().addAll(Team.values());
        posCB.getItems().addAll(Position.values());
        nationCB.getItems().addAll(Locale.getISOCountries());

        for (int i = 1; i < 50; i++) {
            numCB.getItems().add(i);
        }

        for (int i = 150; i < 240; i++) {
            heightCB.getItems().add(i);
        }

        for (int i = 50; i < 150; i++) {
            weightCB.getItems().add(i);
        }

        for (int i = 1; i < lom; i++) {
            dobDayCB.getItems().add(i);
        }

        for (int i = 1; i < 12; i++) {
            dobMonthCB.getItems().add(i);
        }

        for (int i = 1980; i < 2005; i++) {
            dobYearCB.getItems().add(i);
        }

        teamCB.getSelectionModel().selectFirst();
        numCB.getSelectionModel().selectFirst();
        posCB.getSelectionModel().selectFirst();
        nationCB.getSelectionModel().select("DE");
        heightCB.getSelectionModel().selectFirst();
        weightCB.getSelectionModel().selectFirst();
        dobDayCB.getSelectionModel().selectFirst();
        dobMonthCB.getSelectionModel().selectFirst();
        dobYearCB.getSelectionModel().selectLast();

        YearMonth y = YearMonth.of(dobYearCB.getValue(), dobMonthCB.getValue());
        lom = y.lengthOfMonth();

        createBtn.setDisable(true);

        ChangeListener<String> c = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                if (fnameTF.textProperty().getValue().isBlank() || lnameTF.textProperty().getValue().isBlank()) {
                    createBtn.setDisable(true);
                } else {
                    createBtn.setDisable(false);
                }
            }
        };

        fnameTF.textProperty().addListener(c);
        lnameTF.textProperty().addListener(c);
    }

    @FXML
    private void createPlayer() {
        Player player = new Player(fnameTF.getText(), lnameTF.getText(), teamCB.getValue(), numCB.getValue(),
                posCB.getValue());
        player.birthDate = LocalDate.of(dobYearCB.getValue(), dobMonthCB.getValue(), dobDayCB.getValue());
        if (DatabaseAPI.createPlayer(player)) {
            createBtn.setDisable(true);
            msg.setStyle("-fx-text-fill: #50b977");
            msg.setText("Created new Player " + player.firstName + " " + player.lastName);
        } else {
            msg.setText("Creation failed for " + player.firstName + " " + player.lastName);
            msg.setStyle("-fx-text-fill: red");
        }
    }

}
