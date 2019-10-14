package com.example.stefan.clientsmartrestaurant;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class hrana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hrana);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }

    public void piceClc(View view) {
        Intent i =new Intent(this,picaPodmeni.class);
        finish();
        startActivity(i);
    }
    public void korpa(View view){
        Intent i =new Intent(this,korpa.class);
        finish();
        startActivity(i);
    }

    public void otvoriKorpuHrana(View view) {
        Intent i= new Intent(this,korpa.class);
        finish();
        startActivity(i);
    }

    public void clickPiceHrana(View view) {
        Intent i= new Intent(this,picePodmeni.class);
        finish();
        startActivity(i);
    }

    public void clickHranaHrana(View view) {
        Intent i= new Intent(this,hrana.class);
        finish();
        startActivity(i);
    }

    public void burgerOpen(View view) {
        Intent i =new Intent(this,vrstapice.class);
        vrstapice.povratak=false;
        vrstapice.vrsta="Burger";
        finish();
        startActivity(i);
    }

    public void sendvicOpen(View view) {
        Intent i =new Intent(this,sendvic.class);
        finish();
        startActivity(i);
    }

    public void slatkisiClick(View view) {
        Intent i=new Intent(this,slatkisi.class);
        finish();
        startActivity(i);
    }

    public void ostaloClick(View view) {
        Intent i=new Intent(this,ostaliProizvodi.class);
        finish();
        startActivity(i);
    }
}
