package com.example.stefan.clientsmartrestaurant;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class picePodmeni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pice_podmeni);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }

    public void birajObicna(View view) {
        Intent i=new Intent(this,piceVrsta.class);
        vrstapice.povratak=false;
        vrstapice.vrsta="Obicno";
        finish();
        startActivity(i);
    }

    public void clickPicePicePodmeni(View view) {
    }

    public void topliIzaberi(View view) {
        Intent i=new Intent(this,vrstapice.class);
        vrstapice.povratak=false;
        vrstapice.vrsta="Kreirana";
        finish();
        startActivity(i);
    }

    public void clickHranaPicePodmeni(View view) {
        Intent i=new Intent(this,hrana.class);
        finish();
        startActivity(i);
    }

    public void otvoriKorpuPicePodmeni(View view) {
        Intent i=new Intent(this,korpa.class);
        finish();
        startActivity(i);
    }
}
