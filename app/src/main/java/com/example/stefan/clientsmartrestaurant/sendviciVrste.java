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

public class sendviciVrste extends AppCompatActivity {
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
        setContentView(R.layout.activity_sendvici_vrste);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ispisiSendvice();
        lView = (ListView) findViewById(R.id.androidList);

        lAdapter = new AdapterArtikal(sendviciVrste.this, nazivi, cene, slike);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(povratak==true){
                    if(nazivi.get(i).contains("kulenom")){
                        sendvic.brSendvic=1;
                    }else if(nazivi.get(i).contains("sunkom")){
                        sendvic.brSendvic=2;
                    }else if(nazivi.get(i).contains("suvim vratom")){
                        sendvic.brSendvic=3;
                    }else{
                        sendvic.brSendvic=4;
                    }
                    sendvic.cena=cene.get(i);
                    sendvic.nazSendvic=nazivi.get(i);
                    nazad();
                }else{
                    Porudzbina p=new Porudzbina();
                    p.setNaziv(nazivi.get(i));
                    p.setCena(Double.parseDouble(cene.get(i)));
                    p.setKolicina(1);
                    Home.porudzbine.add(p);
                    backSendvic(view);
                }
            }
        });

    }
    public void clickHranaSendvic(View view) {
        Intent i =new Intent(this,hrana.class);
        finish();
        startActivity(i);
        
    }
    public void clickPiceSendvic(View view) {
        Intent i =new Intent(this,picePodmeni.class);
        finish();
        startActivity(i);
    }
    public void otvoriKorpuSendvic(View view) {
        Intent i =new Intent(this,korpa.class);
        finish();
        startActivity(i);
    }
    public void backSendvic(View view) {
        Intent i =new Intent(this,Home.class);
        finish();
        startActivity(i);
    }
    public void ispisiSendvice(){
        ArrayList<Proizvod> proizvodi=meniHrana.hrana();
        for (int i=0;i<proizvodi.size();i++){
            if(proizvodi.get(i).getPodtip().equals("Sendvic")){
                nazivi.add(proizvodi.get(i).getNaziv());
                cene.add(String.valueOf(proizvodi.get(i).getCena()));
                if(proizvodi.get(i).getNaziv().contains("kulenom")){
                    slike.add(R.drawable.kulen);
                }else if(proizvodi.get(i).getNaziv().contains("sunkom")){
                    slike.add(R.drawable.sunka);
                }else if(proizvodi.get(i).getNaziv().contains("suvim vratom")){
                    slike.add(R.drawable.suvivrat);
                }else if(proizvodi.get(i).getNaziv().contains("pecenicom")){
                    slike.add(R.drawable.pecenica);
                }else{
                    slike.add(0);}
            }
        }
    }

    public void nazad(){
        Intent i =new Intent(this,sendvic.class);
        finish();
        startActivity(i);
    }
}
