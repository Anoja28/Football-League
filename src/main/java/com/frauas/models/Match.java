package com.frauas.models;

import java.time.LocalDate;

public class Match {
    public Team a;
    public Team b;
    public int matchday;
    public String stadium;
    public LocalDate date;

    public Match(Team a, Team b, int matchday, String stadium) {
        this.a = a;
        this.b = b;
        this.matchday = matchday;
        this.stadium = stadium;
    }
}
