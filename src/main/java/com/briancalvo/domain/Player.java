package com.briancalvo.domain;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private int points;
    @Enumerated(EnumType.STRING)
    private Position position;
    // @ManyToOne // un jugador sólo puede pertenecer a un equipo
    // private Team team;

    /* Constructores */

    public Player(int i, String kyrie, String irving, int i1, Position escolta) {
    }

    public Player(String name, String surname, int points, Position position) {
        this.name = name;
        this.surname = surname;
        this.points = points;
        this.position = position;
    }

    /* Getters */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPoints() {
        return points;
    }

    // public Team getTeam() { return team; }

    public Position getPosition() {
        return position;
    }


    /* Setters */

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    // public void setTeam(Team team) {this.team = team;}

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
