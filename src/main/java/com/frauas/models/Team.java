package com.frauas.models;

import java.util.Random;

public enum Team {
    FCB("FC Bayern", "#dc052d", 15, 10, 4, 1, 49, 13, 36, 26),
    RBL("RB Leipzig", "#ffffff", 15, 10, 4, 1, 49, 13, 36, 26),
    BVB("Borussia Dortmund", "#ffd900", 15, 10, 4, 1, 49, 13, 36, 26),
    WOB("VfL Wolfsburg", "#64b42d", 15, 10, 4, 1, 49, 13, 36, 26),
    SGE("Eintracht Frankfurt", "#000000", 15, 10, 4, 1, 49, 13, 36, 26),
    B04("Bayer Leverkusen", "#ff0000", 15, 10, 4, 1, 49, 13, 36, 26),
    BMG("Borussia Mönchengladbach", "#000000", 15, 10, 4, 1, 49, 13, 36, 26),
    VfB("VfB Stuttgart", "#ffffff", 15, 10, 4, 1, 49, 13, 36, 26),
    SCF("SC Freiburg", "#e4002b", 15, 10, 4, 1, 49, 13, 36, 26),
    TSG("TSG Hoffenheim", "#1f5da6", 15, 10, 4, 1, 49, 13, 36, 26),
    M05("FSV Mainz", "#e30613", 15, 10, 4, 1, 49, 13, 36, 26),
    FCA("FC Augsburg", "#cd1719", 15, 10, 4, 1, 49, 13, 36, 26),
    BSC("Hertha BSC", "#0069b4", 15, 10, 4, 1, 49, 13, 36, 26),
    KOE("FC Köln", "#ff0000", 15, 10, 4, 1, 49, 13, 36, 26),
    BOC("VfL Bochum", "#1456a2", 15, 10, 4, 1, 49, 13, 36, 26),
    SVW("SV Werder Bremen", "#008149", 15, 10, 4, 1, 49, 13, 36, 26),
    S04("FC Schalke 04", "#004b9c", 15, 10, 4, 1, 49, 13, 36, 26);
    // DSC("Arminia Bielefeld", Color.web("#dc052d")), // Deutscher Sportclub
    // (Arminia Bielefeld)
    // FCU("Union Berlin"), // (1.) Fußballclub Union (Berlin)

    private Team(String fullName, String color, int p, int w, int d, int l, int gf, int ga, int gd, int pts) {
        this.color = color;
        this.fullName = fullName;
        logo = getClass().getResource("../img/" + name() + ".png").toExternalForm();

        this.p = p;
        this.w = w;
        this.d = d;
        this.l = l;
        this.gf = gf;
        this.ga = ga;
        this.gd = gd;
        this.pts = pts;
    }

    public String logo;
    public String color;
    private String fullName;

    /*
     * League table scores
     */
    public int p;
    public int w;
    public int d;
    public int l;
    public int gf;
    public int ga;
    public int gd;
    public int pts;

    /**
     * Get random team
     * 
     * @return Team enum object
     */
    public static Team getRandomTeam() {
        Random rand = new Random();
        return Team.values()[rand.nextInt(values().length)];
    }

    @Override
    public String toString() {
        return fullName;
    }
}
