package models;

public class Player {
    public String firstName;
    public String lastName;
    public Club club;
    public int number;
    public Position position;
    public int age;

    public Player(String firstName, String lastName, Club club, int number, Position position, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.club = club;
        this.number = number;
        this.position = position;
        this.age = age;
    }
}
