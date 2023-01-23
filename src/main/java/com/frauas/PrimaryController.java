package com.frauas;

import java.io.IOException;

import com.frauas.models.User;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    TextField usernameTF;

    @FXML
    private void switchToSecondary() throws IOException {
        String name = usernameTF.getText();
        User.getInstance().setUsername(name);

        App.setRoot("base");
    }
}
