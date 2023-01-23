package com.frauas.models;

import java.time.LocalDate;

public class Match {
    public Team a;
    public Team b;
    public int matchday;
    public String stadium;
    public LocalDate date;

    public int aGoals = 0;
    public int bGoals = 0;

    public Match(Team a, Team b, int matchday, String stadium) {
        this.a = a;
        this.b = b;
        this.matchday = matchday;
        this.stadium = stadium;
    }

    public Match(Team a, Team b, int matchday, int aGoals, int bGoals, String stadium) {
        this.a = a;
        this.b = b;
        this.matchday = matchday;
        this.aGoals = aGoals;
        this.bGoals = bGoals;
        this.stadium = stadium;
    }

    public boolean hasPassed() {
        return date.isBefore(LocalDate.now());
    }
}
