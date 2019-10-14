package com.example.stefan.clientsmartrestaurant;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class picaPodmeni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pica_podmeni);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }

    public void kreiraj(View view) {
        vrstapice.vrsta="Pica";
        vrstapice.povratak=true;
        Intent i=new Intent(this,Pica.class);
        finish();
        startActivity(i);
    }
    public void birajParce(View view) {
        vrstapice.vrsta="Pica parce";
        vrstapice.povratak=false;
        Intent i=new Intent(this,vrstapice.class);
        finish();
        startActivity(i);
    }
    public void birajCelu(View view) {
        vrstapice.vrsta="Pica";
        vrstapice.povratak=false;
        Intent i=new Intent(this,vrstapice.class);
        finish();
        startActivity(i);
    }

    public void otvoriKorpuPodmeni(View view) {
        Intent i= new Intent(this,korpa.class);
        finish();
        startActivity(i);
    }

    public void clickPicePodmeni(View view) {
        Intent i= new Intent(this,picePodmeni.class);
        finish();
        startActivity(i);
    }

    public void clickHranaPodmeni(View view) {
        Intent i= new Intent(this,hrana.class);
        finish();
        startActivity(i);
    }
}
