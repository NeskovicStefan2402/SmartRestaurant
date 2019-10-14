package com.example.stefan.clientsmartrestaurant;

public class Proizvod {
    private String naziv;
    private String podtip;
    private double cena;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getPodtip() {
        return podtip;
    }

    public void setPodtip(String podtip) {
        this.podtip = podtip;
    }
}
