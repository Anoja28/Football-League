package com.frauas.models;

import java.util.Random;

public enum Team {
    FCB("FC Bayern"), // Fußball-Club Bayern (München)
    RBL("RB Leipzig"), // RasenBallsport Leipzig
    BVB("Borussia Dortmund"), // Ballsportverein Borussia (Dortmund)
    WOB("VfL Wolfsburg"), // (VfL) Wolfsburg
    SGE("Eintracht Frankfurt"), // Sportgemeinde Eintracht (Frankfurt)
    B04("Bayer Leverkusen"), // Bayer 04 (Leverkusen)
    FCU("Union Berlin"), // (1.) Fußballclub Union (Berlin)
    BMG("Borussia Mönchengladbach"), // (VfL) Borussia Mönchengladbach
    VfB("VfB Stuttgart"), // Verein für Bewegungsspiele (Stuttgart)
    SCF("SC Freiburg"), // Sport-Club Freiburg
    TSG("TSG Hoffenheim"), // Turn und Sportgemeinschaft (Hoffenheim)
    M05("FSV Mainz"), // (FSV) Mainz 05
    FCA("FC Augsburg"), // Fußball-Club Augsburg
    BSC("Hertha BSC"), // (Hertha) BSC
    DSC("Arminia Bielefeld"), // Deutscher Sportclub (Arminia Bielefeld)
    KOE("FC Köln"), // (1. FC) Köln
    BOC("VfL Bochum"); // (VfL) Bochum

    private Team(String fullName) {
        this.fullName = fullName;
        logo = getClass().getResource("../img/" + name() + ".png").toExternalForm();
    }

    public String logo;
    private String fullName;

    public static Team getRandomTeam() {
        Random rand = new Random();
        return Team.values()[rand.nextInt(values().length)];
    }

    @Override
    public String toString() {
        return fullName;
    }
}
