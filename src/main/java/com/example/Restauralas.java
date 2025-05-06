package com.example;

public class Restauralas {
    private int id;
    private int paintingId;
    private String datum;
    private String muvelet;
    private String megjegyzes;

    public Restauralas(int id, int paintingId, String datum, String muvelet, String megjegyzes) {
        this.id = id;
        this.paintingId = paintingId;
        this.datum = datum;
        this.muvelet = muvelet;
        this.megjegyzes = megjegyzes;
    }

    // Getters és Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(int paintingId) {
        this.paintingId = paintingId;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getMuvelet() {
        return muvelet;
    }

    public void setMuvelet(String muvelet) {
        this.muvelet = muvelet;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }

    // CSV formátumba alakítás
    public String toCSVString() {
        return id + ";" + paintingId + ";" + datum + ";" + muvelet + ";" + megjegyzes;
    }
}
