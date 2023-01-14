package com.frauas.components;

import com.frauas.models.Match;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MatchCard extends VBox {
    private Match match;

    public MatchCard(Match match) {
        this.match = match;

        initialize();
    }

    int lgHeight = 60;
    int lgWidth = 160;

    private void initialize() {
        HBox hero = new HBox();
        hero.setAlignment(Pos.CENTER);
        getStyleClass().add("match-card");

        Label leftL = new Label(match.a.toString());
        Label rightL = new Label(match.b.toString());
        Label timeL = new Label("20:30");
        leftL.setPrefWidth(100);
        rightL.setPrefWidth(100);

        ImageView leftImg = new ImageView(new Image(match.a.logo));
        ImageView rightImg = new ImageView(new Image(match.b.logo));

        Label leftImgL = new Label();
        leftImg.setFitHeight(lgHeight);
        leftImg.setPreserveRatio(true);
        leftImgL.setPrefWidth(lgWidth);
        leftImgL.setGraphic(leftImg);
        leftImgL.setAlignment(Pos.CENTER);

        Label rightImgL = new Label();
        rightImg.setFitHeight(lgHeight);
        rightImg.setPreserveRatio(true);
        rightImgL.setPrefWidth(lgWidth);
        rightImgL.setGraphic(rightImg);
        rightImgL.setAlignment(Pos.CENTER);

        hero.getChildren().add(leftL);
        hero.getChildren().add(leftImgL);
        hero.getChildren().add(timeL);
        hero.getChildren().add(rightImgL);
        hero.getChildren().add(rightL);

        for (Node n : hero.getChildren()) {
            if (n instanceof Label) {
                ((Label) n).setStyle("-fx-font-size: 14; -fx-font-weight: 600; -fx-text-fill: black; -fx-padding: 8");
                ((Label) n).setWrapText(true);
            } else {
                n.setStyle("-fx-padding: 4");
            }
        }

        timeL.setStyle("-fx-font-size: 12; -fx-font-weight: 200; -fx-padding: 2 8 2 8; -fx-text-fill: black;");

        HBox info = new HBox();
        Label stdL = new Label(
                match.stadium + " · "
                        + match.date.getDayOfWeek().name().substring(0, 3) + " "
                        + match.date.getDayOfMonth() + " "
                        + match.date.getMonth().name().substring(0, 3) + " · Matchday "
                        + match.matchday);
        stdL.setStyle("-fx-font-size: 12; -fx-font-weight: 200; -fx-padding: 2 8 2 8; -fx-text-fill: black;");
        info.getChildren().add(stdL);
        info.setAlignment(Pos.CENTER);

        getChildren().add(hero);
        getChildren().add(info);
    }
}
