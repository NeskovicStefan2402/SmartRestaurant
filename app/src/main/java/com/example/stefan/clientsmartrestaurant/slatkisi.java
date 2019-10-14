package com.example.stefan.clientsmartrestaurant;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class slatkisi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slatkisi);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }
    public void otvoriKorpuSlatkisi(View view) {
        Intent i= new Intent(this,korpa.class);
        finish();
        startActivity(i);
    }

    public void clickPiceSlatkisi(View view) {
        Intent i= new Intent(this,picePodmeni.class);
        finish();
        startActivity(i);
    }

    public void clickHranaSlatkisi(View view) {
        Intent i= new Intent(this,hrana.class);
        finish();
        startActivity(i);
    }

    public void kreirajPalacinke(View view) {
        Intent i=new Intent(this,kreirajPalacinke.class);
        finish();
        startActivity(i);
    }

    public void birajObicneSlatkise(View view) {
        Intent i=new Intent(this,slatkisiVrste.class);
        finish();
        startActivity(i);
    }
}
