package com.frauas;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class PrimaryController {

    @FXML
    VBox test;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("base");
    }

    public void initialize() {
    }
}
