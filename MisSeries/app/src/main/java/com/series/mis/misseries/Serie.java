package com.series.mis.misseries;

import java.io.Serializable;

public class Serie implements Serializable {

    private String name;
    private int image;

    public Serie(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
class DetailSerie implements Serializable{

    private String name;
    private String synopsis;
    private String season;
    private String recomendation;
    private int image;

    public DetailSerie(String name, String synopsis, String season, String recomendation, int image) {
        this.name = name;
        this.synopsis = synopsis;
        this.season = season;
        this.recomendation = recomendation;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
