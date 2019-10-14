package com.example.stefan.clientsmartrestaurant;

public class Porudzbina {

    private String naziv;
    private int kolicina;
    private double cena;
    public int getKolicina() {
        return kolicina;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
