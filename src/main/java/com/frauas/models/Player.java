package com.frauas.models;

import java.time.LocalDate;
import java.time.Period;

import org.bson.types.ObjectId;

public class Player {
    public ObjectId id;
    public String firstName;
    public String lastName;
    public Team team;
    public int number;
    public Position position;
    public LocalDate birthDate;
    public String nationality;

    public Player(ObjectId id, String firstName, String lastName, Team team, int number, Position position,
            LocalDate birthdDate,
            String nationality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        this.number = number;
        this.position = position;
        this.birthDate = birthdDate;
        this.nationality = nationality;
    }

    public Player(String firstName, String lastName, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        team = Team.SGE;
        position = Position.ATK;
        birthDate = LocalDate.of(2000, 1, 1);
        nationality = "DE";
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthDate, now);
        return period.getYears();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Team getTeam() {
        return team;
    }

    public int getNumber() {
        return number;
    }

    public Position getPosition() {
        return position;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getNationality() {
        return nationality;
    }
}
