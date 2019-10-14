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

public class slatkisiVrste extends AppCompatActivity {
    LinkedList<Integer> slike=new LinkedList<>();
    LinkedList<String> nazivi=new LinkedList<>();
    LinkedList<String> cene=new LinkedList<>();
    ListView lView;

    AdapterArtikal lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slatkisi_vrste);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ispisiSlatkise();
        lView = (ListView) findViewById(R.id.androidList);

        lAdapter = new AdapterArtikal(slatkisiVrste.this, nazivi, cene, slike);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Porudzbina p = new Porudzbina();
                p.setNaziv(nazivi.get(i));
                p.setCena(Double.parseDouble(cene.get(i)));
                p.setKolicina(1);
                Home.porudzbine.add(p);
                backHomeSlatkisi(view);
            }
        });

    }
    public void backHomeSlatkisi(View view) {
        Intent i =new Intent(this,Home.class);
        finish();
        startActivity(i);
    }

    public void otvoriKorpuSlatkisiVrsta(View view) {
        Intent i=new Intent(this,korpa.class);
        finish();
        startActivity(i);
    }

    public void clickHranaSlatkisiVrsta(View view) {
        Intent i=new Intent(this,hrana.class);
        finish();
        startActivity(i);
    }

    public void clickPiceSlatkisiVrsta(View view) {
        Intent i=new Intent(this,picePodmeni.class);
        finish();
        startActivity(i);
    }
    public void ispisiSlatkise(){
        ArrayList<Proizvod> proizvodi=meniHrana.hrana();
        for (int i=0;i<proizvodi.size();i++){
            if(proizvodi.get(i).getPodtip().equals("Slatkis")){
                nazivi.add(proizvodi.get(i).getNaziv());
                cene.add(String.valueOf(proizvodi.get(i).getCena()));
                if(proizvodi.get(i).getNaziv().contains("jagodom")){
                    slike.add(R.drawable.jagoda);
                }else if(proizvodi.get(i).getNaziv().contains("sumskim")){
                    slike.add(R.drawable.sumskovoce);
                }else if(proizvodi.get(i).getNaziv().contains("vanilom")){
                    slike.add(R.drawable.vanila);
                }else if(proizvodi.get(i).getNaziv().contains("Sladoled sa cokoladom")){
                    slike.add(R.drawable.cokolada);
                }else if(proizvodi.get(i).getNaziv().contains("visnjom")){
                    slike.add(R.drawable.mv);
                }else if(proizvodi.get(i).getNaziv().contains("Mafin sa cokoladom")){
                    slike.add(R.drawable.mafincokolada);
                }else if(proizvodi.get(i).getNaziv().contains("Cheesecake")){
                    slike.add(R.drawable.cheesecake);
                }else if(proizvodi.get(i).getNaziv().contains("bomba")){
                    slike.add(R.drawable.slatkis);
                }else if(proizvodi.get(i).getNaziv().contains("Vocna")){
                    slike.add(R.drawable.vocnasalata);
                }else{
                    slike.add(0);}
            }
        }
    }
}

