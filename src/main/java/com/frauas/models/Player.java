package com.frauas.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class Player {
    public String firstName;
    public String lastName;
    public Team team;
    public int number;
    public Position position;
    public LocalDate birthDate;
    public Locale nationality;
    public int height;
    public int weight;

    public Player(String firstName, String lastName, Team team, int number, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        this.number = number;
        this.position = position;

        birthDate = LocalDate.of(2000, 1, 1);
        height = 183;
        weight = 70;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthDate, now);
        return period.getYears();
    }
}
