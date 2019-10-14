package com.example.stefan.clientsmartrestaurant;

import java.util.LinkedList;

public class Proces {
    LinkedList<Porudzbina> porudzbine;

    public Proces(){
        porudzbine=new LinkedList<Porudzbina>();
    }
    public boolean unesiElement(double cena,String naziv,int kolicina){
        try{
            Porudzbina p=new Porudzbina();
            p.setCena(cena);
            p.setNaziv(naziv);
            p.setKolicina(kolicina);
            porudzbine.add(p);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public LinkedList<Porudzbina> getPorudzbine() {
        return porudzbine;
    }



}
