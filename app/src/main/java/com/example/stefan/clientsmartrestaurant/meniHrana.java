package com.example.stefan.clientsmartrestaurant;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
public class meniHrana extends AppCompatActivity implements Adapter.ItemClickListener {
    public ArrayList<Porudzbina> porudzbine=new ArrayList<>();
    Adapter adapter;
    String bu;
    Button hranabtn,picebtn,korpabtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meni_hrana);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        hranabtn=findViewById(R.id.btn_hranaPH);
        picebtn=findViewById(R.id.btn_picePH);
        korpabtn=findViewById(R.id.btn_korpaPH);
        Home.prevedi(hranabtn,picebtn,korpabtn,null);

        ArrayList<String> animalNames=new ArrayList<>();
        bu=getIntent().getStringExtra("BR");
        if(bu.equals("hrana")){
            animalNames= proizvodCena(hrana());
            korpa.povecaj(hranabtn);
        }else if(bu.equals("pice")){
            animalNames=proizvodCena(pice());
            korpa.povecaj(picebtn);
        }
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Home.animacija(view);
        ArrayList<Proizvod> proizvodi;
        if(bu.equals("pice"))proizvodi=pice();
        else proizvodi=hrana();

           for (int i=0;i<proizvodi.size();i++){
            if(i==position) {
                if(daLiPostoji(proizvodi.get(i).getNaziv())==true){
                    for (int j=0;j<Home.porudzbine.size();j++){
                        if(proizvodi.get(i).getNaziv().equals(Home.porudzbine.get(j).getNaziv())){
                            Home.porudzbine.get(j).setKolicina(Home.porudzbine.get(j).getKolicina()+1);
                        }
                    }
                }else{
                    Porudzbina p=new Porudzbina();
                    p.setNaziv(proizvodi.get(i).getNaziv());
                    p.setCena(proizvodi.get(i).getCena());
                    p.setKolicina(1);
                    Home.porudzbine.add(p);
                }
            }


        }

    }
    public boolean daLiPostoji(String naziv){
        for (int i=0;i<Home.porudzbine.size();i++){
            if(naziv.equals(Home.porudzbine.get(i).getNaziv())) return true;
        }
        return false;
    }
    public static ArrayList<Proizvod> pice(){
        ArrayList<Proizvod> proizvodi = new ArrayList<Proizvod>();
        Proizvod p=new Proizvod();
        p.setNaziv("Fanta");
        p.setCena(140);
        p.setPodtip("Obicno");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Kokta");
        p.setCena(130);
        p.setPodtip("Obicno");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Koka kola");
        p.setCena(140);
        p.setPodtip("Obicno");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Plazma sejk");
        p.setCena(230);
        p.setPodtip("Kreirana");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Oreo sejk");
        p.setCena(250);
        p.setPodtip("Kreirana");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Topla cokolada");
        p.setCena(170);
        p.setPodtip("Kreirana");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Kisela voda");
        p.setCena(110);
        p.setPodtip("Obicno");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Naturalna voda");
        p.setCena(80);
        p.setPodtip("Obicno");
        proizvodi.add(p);

        p=new Proizvod();
        p.setNaziv("Proteinski sejk");
        p.setCena(250);
        p.setPodtip("Kreirana");
        proizvodi.add(p);


        p=new Proizvod();
        p.setNaziv("Nescafe");
        p.setCena(130);
        p.setPodtip("Kreirana");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Cappuccino");
        p.setCena(130);
        p.setPodtip("Kreirana");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Espresso");
        p.setCena(170);
        p.setPodtip("Kreirana");
        proizvodi.add(p);
            return proizvodi;
    }
    public ArrayList<String> proizvodCena(ArrayList<Proizvod> pr){
            ArrayList<Proizvod> p=pr;
            ArrayList<String> prozvodi=new ArrayList<String>();
        for (int i=0;i<p.size();i++){
            prozvodi.add("  "+p.get(i).getNaziv()+"      "+p.get(i).getCena()+" RSD");
        }
        return prozvodi;
    }
    public static ArrayList<Proizvod> hrana(){
        ArrayList<Proizvod> proizvodi = new ArrayList<Proizvod>();
        Proizvod p=new Proizvod();

        p.setNaziv("Hamburger");
        p.setCena(250);
        p.setPodtip("Burger");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Cheeseburger");
        p.setCena(250);
        p.setPodtip("Burger");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Chickenburger");
        p.setCena(250);
        p.setPodtip("Burger");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Hot dog");
        p.setCena(150);
        p.setPodtip("Burger");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Pet sarajevskih cevapa");
        p.setCena(220);
        p.setPodtip("Burger");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Deset sarajevskih cevapa");
        p.setCena(440);
        p.setPodtip("Burger");
        proizvodi.add(p);
        p=new Proizvod();



        p=new Proizvod();
        p.setNaziv("Pica parce capricciosa");
        p.setCena(120);
        p.setPodtip("Pica parce");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Pica parce vegetariana");
        p.setCena(130);
        p.setPodtip("Pica parce");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Pica parce margherita");
        p.setCena(110);
        p.setPodtip("Pica parce");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Pica parce quattro formaggi");
        p.setCena(150);
        p.setPodtip("Pica parce");
        proizvodi.add(p);

        p=new Proizvod();
        p.setNaziv("Pica capricciosa 25cm");
        p.setCena(330);
        p.setPodtip("Pica");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Pica vegetariana 25cm");
        p.setCena(350);
        p.setPodtip("Pica");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Pica margherita 25cm");
        p.setCena(300);
        p.setPodtip("Pica");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Pica quattro formaggi 25cm");
        p.setCena(370);
        p.setPodtip("Pica");
        proizvodi.add(p);

        p=new Proizvod();
        p.setNaziv("Pica capricciosa 32cm");
        p.setCena(550);
        p.setPodtip("Pica");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Pica vegetariana 32cm");
        p.setCena(570);
        p.setPodtip("Pica");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Pica margherita 32cm");
        p.setCena(530);
        p.setPodtip("Pica");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Pica quattro formaggi 32cm");
        p.setCena(600);
        p.setPodtip("Pica");
        proizvodi.add(p);

        p=new Proizvod();
        p.setNaziv("Pica capricciosa 42cm");
        p.setCena(770);
        p.setPodtip("Pica");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Pica vegetariana 42cm");
        p.setCena(780);
        p.setPodtip("Pica");
        proizvodi.add(p);
        p=new Proizvod();
        p.setNaziv("Pica margherita 42cm");
        p.setCena(750);
        p.setPodtip("Pica");
        proizvodi.add(p);
        p=new Proizvod();
        p.setPodtip("Pica");
        p.setNaziv("Pica quattro formaggi 42cm");
        p.setCena(820);
        proizvodi.add(p);

        p=new Proizvod();
        p.setPodtip("Sendvic");
        p.setNaziv("Sendvic sa pecenicom");
        p.setCena(170);
        proizvodi.add(p);
        p=new Proizvod();
        p.setPodtip("Sendvic");
        p.setNaziv("Sendvic sa sunkom");
        p.setCena(160);
        proizvodi.add(p);
        p=new Proizvod();
        p.setPodtip("Sendvic");
        p.setNaziv("Sendvic sa kulenom");
        p.setCena(160);
        proizvodi.add(p);
        p=new Proizvod();
        p.setPodtip("Sendvic");
        p.setNaziv("Sendvic sa suvim vratom");
        p.setCena(170);
        proizvodi.add(p);

        p=new Proizvod();
        p.setPodtip("Slatkis");
        p.setNaziv("Cheesecake");
        p.setCena(170);
        proizvodi.add(p);
        p=new Proizvod();
        p.setPodtip("Slatkis");
        p.setNaziv("Cokoladna bomba");
        p.setCena(170);
        proizvodi.add(p);
        p=new Proizvod();
        p.setPodtip("Slatkis");
        p.setNaziv("Vocna salata");
        p.setCena(210);
        proizvodi.add(p);
        p=new Proizvod();
        p.setPodtip("Slatkis");
        p.setNaziv("Sladoled sa vanilom");
        p.setCena(150);
        proizvodi.add(p);
        p=new Proizvod();
        p.setPodtip("Slatkis");
        p.setNaziv("Sladoled sa cokoladom");
        p.setCena(150);
        proizvodi.add(p);
        p=new Proizvod();
        p.setPodtip("Slatkis");
        p.setNaziv("Sladoled sa jagodom");
        p.setCena(150);
        proizvodi.add(p);
        p=new Proizvod();
        p.setPodtip("Slatkis");
        p.setNaziv("Sladoled sa sumskim vocem");
        p.setCena(150);
        proizvodi.add(p);
        p=new Proizvod();
        p.setPodtip("Slatkis");
        p.setNaziv("Mafin sa visnjom");
        p.setCena(120);
        proizvodi.add(p);
        p=new Proizvod();
        p.setPodtip("Slatkis");
        p.setNaziv("Mafin sa cokoladom");
        p.setCena(150);
        proizvodi.add(p);

        return proizvodi;

    }

    public void back(View view) {
        Intent i=new Intent(this,Home.class);
        startActivity(i);
    }public void clickPice(View view) {
        Intent i=new Intent(this,meniHrana.class);
        String br="pice";
        i.putExtra("BR",br);
        startActivity(i);
    }
    public void clickHrana(View view) {
        Intent i=new Intent(this,meniHrana.class);
        String br="hrana";
        i.putExtra("BR",br);
        startActivity(i);
    }
    public void otvoriKorpu(View view) {
        Intent i=new Intent(this,korpa.class);
        startActivity(i);
    }

}