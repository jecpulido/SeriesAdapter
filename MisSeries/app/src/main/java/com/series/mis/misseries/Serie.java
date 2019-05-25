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
    private String duracion;
    private int image;

    public DetailSerie(String name, String synopsis, String duracion, int image) {
        this.name = name;
        this.synopsis = synopsis;
        this.duracion = duracion;
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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
