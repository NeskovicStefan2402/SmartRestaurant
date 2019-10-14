package com.example.stefan.clientsmartrestaurant;// Android Custom ListView with Image and Text Tutorial with Example and Source Code
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class vrstapice extends AppCompatActivity {

    public static String vrsta="";
    public static boolean povratak=false;
    LinkedList<Integer> slike=new LinkedList<>();
    LinkedList<String> nazivi=new LinkedList<>();
    LinkedList<String> cene=new LinkedList<>();
    ListView lView;

    AdapterArtikal lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylistview);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        menu();
        lView = (ListView) findViewById(R.id.androidList);

        lAdapter = new AdapterArtikal(vrstapice.this, nazivi, cene, slike);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(povratak==true){
                    if(nazivi.get(i).contains("capricciosa")){
                        Pica.brPice=1;
                    }else if(nazivi.get(i).contains("margherita")){
                        Pica.brPice=2;
                    }else if(nazivi.get(i).contains("vegetariana")){
                        Pica.brPice=3;
                    }else{
                        Pica.brPice=4;
                    }
                    Pica.cena=cene.get(i);
                    Pica.nazPice=nazivi.get(i);
                    back1(view);
                }else{
                    Porudzbina p=new Porudzbina();
                    p.setNaziv(nazivi.get(i));
                    p.setCena(Double.parseDouble(cene.get(i)));
                    p.setKolicina(1);
                    Home.porudzbine.add(p);
                    nazad();
                }
            }
        });

    }
    public void menu(){
        if(vrsta.equals("Pica")){
           ispisi();
        }else if(vrsta.equals("Pica parce")){
            ispisiParce();
        }else if(vrsta.equals("Burger")){
            ispisiBurgere();
        }else if(vrsta.equals("Obicno")){
            ispisiPiceObicno();
        }else if(vrsta.equals("Kreirana")){
            ispisiPiceKreirana();
        }else{
            ispisi();
        }
    }
    public void ispisiSendvice(){
        ArrayList<Proizvod> proizvodi=meniHrana.pice();
        for (int i=0;i<proizvodi.size();i++){
            if(proizvodi.get(i).getPodtip().equals("Sendvic")){
                nazivi.add(proizvodi.get(i).getNaziv());
                cene.add(String.valueOf(proizvodi.get(i).getCena()));
                if(proizvodi.get(i).getNaziv().contains("kulenom")){
                    slike.add(R.drawable.cocacola);
                }else if(proizvodi.get(i).getNaziv().contains("sunkom")){
                    slike.add(R.drawable.cockta);
                }else if(proizvodi.get(i).getNaziv().contains("suvim vratom")){
                    slike.add(R.drawable.fanta);
                }else if(proizvodi.get(i).getNaziv().contains("pecenicom")){
                    slike.add(R.drawable.knjaz);
                }else{
                    slike.add(0);}
            }
        }
    }
    public void nazad(){
        Intent intent= new Intent(this,Home.class);
        finish();
        startActivity(intent);
    }
    public void ispisiPiceObicno(){
        ArrayList<Proizvod> proizvodi=meniHrana.pice();
        for (int i=0;i<proizvodi.size();i++){
            if(proizvodi.get(i).getPodtip().equals("Obicno")){
                nazivi.add(proizvodi.get(i).getNaziv());
                cene.add(String.valueOf(proizvodi.get(i).getCena()));
                if(proizvodi.get(i).getNaziv().contains("Koka kola")){
                    slike.add(R.drawable.cocacola);
                }else if(proizvodi.get(i).getNaziv().contains("Kokta")){
                    slike.add(R.drawable.cockta);
                }else if(proizvodi.get(i).getNaziv().contains("Fanta")){
                    slike.add(R.drawable.fanta);
                }else if(proizvodi.get(i).getNaziv().contains("Kisela voda")){
                    slike.add(R.drawable.knjaz);
                }else if(proizvodi.get(i).getNaziv().contains("Naturalna voda")){
                    slike.add(R.drawable.rosa);
                }else if(proizvodi.get(i).getNaziv().contains("jagode")){
                    slike.add(R.drawable.jagoda);
                }else if(proizvodi.get(i).getNaziv().contains("jabuke")){
                    slike.add(R.drawable.jabuka);
                }else if(proizvodi.get(i).getNaziv().contains("Cedjena")){
                    slike.add(R.drawable.pomorandza);
                }else if(proizvodi.get(i).getNaziv().contains("Limunada")){
                    slike.add(R.drawable.limunada);
                }else if(proizvodi.get(i).getNaziv().contains("mix")){
                    slike.add(R.drawable.mix);
                }else{
                slike.add(0);}
            }
        }
    }

    public void ispisiPiceKreirana(){
        ArrayList<Proizvod> proizvodi=meniHrana.pice();
        for (int i=0;i<proizvodi.size();i++){
            if(proizvodi.get(i).getPodtip().equals("Kreirana")){
                nazivi.add(proizvodi.get(i).getNaziv());
                cene.add(String.valueOf(proizvodi.get(i).getCena()));
                if(proizvodi.get(i).getNaziv().contains("Proteinski")){
                    slike.add(R.drawable.proteinski);
                }else if(proizvodi.get(i).getNaziv().contains("Plazma")){
                    slike.add(R.drawable.plazma);
                }else if(proizvodi.get(i).getNaziv().contains("Oreo")){
                    slike.add(R.drawable.oreo);
                }else if(proizvodi.get(i).getNaziv().contains("Nescafe")){
                    slike.add(R.drawable.nescafe);
                }else if(proizvodi.get(i).getNaziv().contains("Espresso")){
                    slike.add(R.drawable.espresso);
                }else if(proizvodi.get(i).getNaziv().contains("Cappuccino")){
                    slike.add(R.drawable.cap);
                }else if(proizvodi.get(i).getNaziv().contains("Topla")){
                    slike.add(R.drawable.topla);
                }else {
                    slike.add(0);
                }
            }
        }
    }
    public void ispisiParce(){
        ArrayList<Proizvod> proizvodi=meniHrana.hrana();
        for (int i=0;i<proizvodi.size();i++){
            if(proizvodi.get(i).getPodtip().equals("Pica parce")){
                nazivi.add(proizvodi.get(i).getNaziv());
                cene.add(String.valueOf(proizvodi.get(i).getCena()));
                if(proizvodi.get(i).getNaziv().contains("capricciosa")) {
                    slike.add(R.drawable.capricciosaparce);
                }else if(proizvodi.get(i).getNaziv().contains("margherita")) {
                    slike.add(R.drawable.margheritaparce);
                }else if(proizvodi.get(i).getNaziv().contains("quattro formaggi")) {
                    slike.add(R.drawable.quattroparce);
                }else if(proizvodi.get(i).getNaziv().contains("vegetariana")) {
                    slike.add(R.drawable.vegetarijanaparce);
                }else{
                    slike.add(0);
                }
            }
        }
    }
    public void ispisiBurgere(){
        ArrayList<Proizvod> proizvodi=meniHrana.hrana();
        for (int i=0;i<proizvodi.size();i++){
            if(proizvodi.get(i).getPodtip().equals("Burger")){
                nazivi.add(proizvodi.get(i).getNaziv());
                cene.add(String.valueOf(proizvodi.get(i).getCena()));
                if(proizvodi.get(i).getNaziv().contains("Chickenburger")) {
                    slike.add(R.drawable.chicken);
                }else if(proizvodi.get(i).getNaziv().contains("Cheeseburger")) {
                    slike.add(R.drawable.cheese);
                }else if(proizvodi.get(i).getNaziv().contains("Hot dog")) {
                    slike.add(R.drawable.hotdog);
                }else if(proizvodi.get(i).getNaziv().contains("Hamburger")) {
                    slike.add(R.drawable.hmburger);
                }else if(proizvodi.get(i).getNaziv().contains("cevapa")) {
                    slike.add(R.drawable.cevapi);
                }else{
                    slike.add(0);
                }
            }
        }
    }
    public void ispisi(){
        ArrayList<Proizvod> proizvodi=meniHrana.hrana();
        for (int i=0;i<proizvodi.size();i++){
            if(proizvodi.get(i).getPodtip().equals("Pica")){
                nazivi.add(proizvodi.get(i).getNaziv());
                cene.add(String.valueOf(proizvodi.get(i).getCena()));
                if(proizvodi.get(i).getNaziv().contains("capricciosa")) {
                    slike.add(R.drawable.capriccosa);
                }else if(proizvodi.get(i).getNaziv().contains("margherita")) {
                    slike.add(R.drawable.margherita);
                }else if(proizvodi.get(i).getNaziv().contains("quattro formaggi")) {
                    slike.add(R.drawable.quattro);
                }else if(proizvodi.get(i).getNaziv().contains("vegetariana")) {
                    slike.add(R.drawable.vegeterijana);
                }else{
                    slike.add(0);
                }
            }

        }
    }

    public void back1(View view) {
        if(povratak==true){
            Intent i =new Intent(this,Pica.class);
            finish();
            startActivity(i);
        }else{
            Intent i =new Intent(this,Home.class);
            finish();
            startActivity(i);
        }
    }
    public void otvoriKorpuVrsta(View view) {
        Intent i= new Intent(this,korpa.class);
        finish();
        startActivity(i);
    }

    public void clickPiceVrsta(View view) {
        Intent i= new Intent(this,picePodmeni.class);
        finish();
        startActivity(i);
    }
    public void clickHranaVrsta(View view) {
        Intent i= new Intent(this,hrana.class);
        finish();
        startActivity(i);
    }
}