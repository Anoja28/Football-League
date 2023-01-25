package com.frauas.components;

import java.util.Arrays;

import com.frauas.models.Match;
import com.frauas.models.Season;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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
        HBox midSection = new HBox();
        leftL.setPrefWidth(100);
        rightL.setPrefWidth(100);

        ImageView leftImg = new ImageView(new Image(match.a.logo));
        ImageView rightImg = new ImageView(new Image(match.b.logo));

        Label leftImgL = new Label();
        leftImg.setFitHeight(lgHeight);
        leftImg.setFitWidth(lgWidth);
        leftImg.setPreserveRatio(true);
        leftImgL.setPrefWidth(lgWidth);
        leftImgL.setGraphic(leftImg);
        leftImgL.setAlignment(Pos.CENTER);

        Label rightImgL = new Label();
        rightImg.setFitHeight(lgHeight);
        rightImg.setFitWidth(lgWidth);
        rightImg.setPreserveRatio(true);
        rightImgL.setPrefWidth(lgWidth);
        rightImgL.setGraphic(rightImg);
        rightImgL.setAlignment(Pos.CENTER);

        hero.getChildren().add(leftL);
        hero.getChildren().add(leftImgL);
        hero.getChildren().add(midSection);
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

        if (match.hasPassed()) {
            TextField aGoalTf = new TextField(Integer.toString(match.aGoals));
            TextField bGoalTf = new TextField(Integer.toString(match.bGoals));
            for (TextField tField : Arrays.asList(aGoalTf, bGoalTf)) {
                tField.setStyle(
                        "-fx-background-color: transparent; -fx-font-weight: 800; -fx-font-size: 18;");
                tField.setMaxWidth(40);
                tField.setAlignment(Pos.CENTER);
                tField.textProperty().addListener((obs, oldVal, newVal) -> {
                    if (!newVal.matches("\\d*")) {
                        tField.setText(newVal.replaceAll("[^\\d]", ""));
                    }
                });
            }

            aGoalTf.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    match.aGoals = Integer.valueOf(aGoalTf.getText());
                    Season.loadTeamScores();
                }
            });

            bGoalTf.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    match.bGoals = Integer.valueOf(bGoalTf.getText());
                    Season.loadTeamScores();
                }
            });

            Label colonL = new Label();
            colonL.setText(" : ");
            colonL.setStyle("-fx-font-weight: 800; -fx-font-size: 18; -fx-padding: 2 8 2 8;");
            midSection.getChildren().add(aGoalTf);
            midSection.getChildren().add(colonL);
            midSection.getChildren().add(bGoalTf);
        }

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
