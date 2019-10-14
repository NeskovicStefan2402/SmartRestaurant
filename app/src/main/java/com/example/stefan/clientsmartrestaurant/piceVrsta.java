package com.example.stefan.clientsmartrestaurant;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;

public class piceVrsta extends AppCompatActivity {
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
        setContentView(R.layout.activity_pice_vrsta);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ispisiPiceObicno();
        lView = (ListView) findViewById(R.id.androidList);

        lAdapter = new AdapterArtikal(piceVrsta.this, nazivi, cene, slike);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Porudzbina p=new Porudzbina();
                    p.setNaziv(nazivi.get(i));
                    p.setCena(Double.parseDouble(cene.get(i)));
                    p.setKolicina(1);
                    Home.porudzbine.add(p);
                    nazad();
            }
        });
    }
    public void nazad(){
        Intent i=new Intent(this,Home.class);
        finish();
        startActivity(i);
    }
    public void ispisiPiceObicno(){
        ArrayList<Proizvod> proizvodi=meniHrana.pice();
        for (int i=0;i<proizvodi.size();i++){
            if(proizvodi.get(i).getPodtip().equals("Obicno")) {
                nazivi.add(proizvodi.get(i).getNaziv());
                cene.add(String.valueOf(proizvodi.get(i).getCena()));
                if (proizvodi.get(i).getNaziv().contains("Koka kola")) {
                    slike.add(R.drawable.cocacola);
                } else if (proizvodi.get(i).getNaziv().contains("Kokta")) {
                    slike.add(R.drawable.cockta);
                } else if (proizvodi.get(i).getNaziv().contains("Fanta")) {
                    slike.add(R.drawable.fanta);
                } else if (proizvodi.get(i).getNaziv().contains("Kisela voda")) {
                    slike.add(R.drawable.knjaz);
                } else if (proizvodi.get(i).getNaziv().contains("Naturalna voda")) {
                    slike.add(R.drawable.rosa);
                } else {
                    slike.add(0);
                }
            }
        }
    }

    public void otvoriKorpuObicno(View view) {
        Intent i= new Intent(this,korpa.class);
        finish();
        startActivity(i);
    }

    public void clickPiceObicno(View view) {
        Intent i= new Intent(this,picePodmeni.class);
        finish();
        startActivity(i);
    }

    public void clickHranaObicno(View view) {
        Intent i= new Intent(this,hrana.class);
        finish();
        startActivity(i);
    }

    public void backObicno(View view) {
        Intent i= new Intent(this,Home.class);
        finish();
        startActivity(i);
    }

}
