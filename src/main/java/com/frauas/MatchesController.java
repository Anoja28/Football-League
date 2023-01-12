package com.frauas;

import com.frauas.models.Team;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MatchesController {
    @FXML
    VBox createRoot;

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            createRoot.getChildren().add(matchComponent(Team.getRandomTeam(), Team.getRandomTeam()));
        }
    }

    public static VBox matchComponent(Team left, Team right) {
        VBox container = new VBox();
        HBox hero = new HBox();
        hero.setAlignment(Pos.CENTER);
        container.getStyleClass().add("match-card");
        container.getStyleClass().add("gray");

        Label leftL = new Label(left.toString());
        Label rightL = new Label(right.toString());
        Label timeL = new Label("20:30");
        leftL.setPrefWidth(100);
        rightL.setPrefWidth(100);

        ImageView leftImg = new ImageView(new Image(left.logo));
        ImageView rightImg = new ImageView(new Image(right.logo));

        Label leftImgL = new Label();
        leftImg.setFitHeight(80);
        leftImg.setPreserveRatio(true);
        leftImgL.setPrefWidth(200);
        leftImgL.setGraphic(leftImg);
        leftImgL.setAlignment(Pos.CENTER);

        Label rightImgL = new Label();
        rightImg.setFitHeight(80);
        rightImg.setPreserveRatio(true);
        rightImgL.setPrefWidth(200);
        rightImgL.setGraphic(rightImg);
        rightImgL.setAlignment(Pos.CENTER);

        hero.getChildren().add(leftL);
        hero.getChildren().add(leftImgL);
        hero.getChildren().add(timeL);
        hero.getChildren().add(rightImgL);
        hero.getChildren().add(rightL);

        for (Node n : hero.getChildren()) {
            if (n instanceof Label) {
                ((Label) n).setStyle("-fx-font-size: 18; -fx-font-weight: 600; -fx-text-fill: black; -fx-padding: 8");
                ((Label) n).setWrapText(true);
            } else {
                n.setStyle("-fx-padding: 4");
            }
        }

        timeL.setStyle("-fx-font-size: 12; -fx-font-weight: 200; -fx-padding: 2 8 2 8; -fx-text-fill: black;");

        HBox info = new HBox();
        Label stdL = new Label("Red Bull Arena · FR 20th Jan · FCB favored");
        stdL.setStyle("-fx-font-size: 12; -fx-font-weight: 200; -fx-padding: 2 8 2 8; -fx-text-fill: black;");
        info.getChildren().add(stdL);
        info.setAlignment(Pos.CENTER);

        container.getChildren().add(hero);
        container.getChildren().add(info);

        return container;
    }
}
