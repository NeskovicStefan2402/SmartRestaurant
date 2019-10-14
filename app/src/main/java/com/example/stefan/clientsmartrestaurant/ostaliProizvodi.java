package com.example.stefan.clientsmartrestaurant;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ostaliProizvodi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ostali_proizvodi);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
    public void izaberi(String vrsta,Double cena){
        Porudzbina p=new Porudzbina();
        p.setNaziv(vrsta);
        p.setKolicina(1);
        p.setCena(cena);
        Home.porudzbine.add(p);
        Intent i=new Intent(this,Home.class);
        finish();
        startActivity(i);
    }
    public void clickHranaOstalo(View view) {
        Intent i=new Intent(this,hrana.class);
        finish();
        startActivity(i);
    }
    public void clickPiceOstalo(View view) {
        Intent i=new Intent(this,picePodmeni.class);
        finish();
        startActivity(i);
    }
    public void otvoriKorpuOstalo(View view) {
        Intent i=new Intent(this,korpa.class);
        finish();
        startActivity(i);
    }

    public void kecapIzaberi(View view) {
        izaberi("Kecap", (double) 30);
    }

    public void pavlakaIzaberi(View view) {
        izaberi("Pavlaka", (double) 30);
    }
    public void pomfritIzaberi(View view) {
        izaberi("Pomfrit", (double) 100);
    }

    public void majonezIzaberi(View view) {
        izaberi("Majonez", (double) 30);
    }

    public void backOstalo(View view) {
        Intent i=new Intent(this,Home.class);
        finish();
        startActivity(i);
    }
}
