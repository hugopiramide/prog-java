package com.liceolapaz.daw.hcd;

public class Jugador {
    private int id;
    private String first_name;
    private String last_name;
    private String position;
    private int weight_pounds;
    private String conference;
    private String division;
    private String team_name;

    public Jugador(int id, String first_name, String last_name, String position, int weight_pounds, String conference, String division, String team_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.weight_pounds = weight_pounds;
        this.conference = conference;
        this.division = division;
        this.team_name = team_name;
    }

    public String toString(){
        return "::::::::::::::::\n" +
                "id => "+ id +"\n" +
                "first_name => \""+ first_name +"\"\n" +
                "last_name => \""+ last_name +"\"\n" +
                "position => \"" + position + "\"\n" +
                "weight_pounds => "+ weight_pounds +"\n" +
                "conference => \""+conference+"\"\n" +
                "division => \""+division+"\"\n" +
                "team_name => \""+team_name+"\"\n";
    }
}
