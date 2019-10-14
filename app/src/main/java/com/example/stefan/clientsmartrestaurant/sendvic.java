package com.example.stefan.clientsmartrestaurant;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class sendvic extends AppCompatActivity implements  Adapter.ItemClickListener  {
    ImageView zelena,kc,pavlaka,my,sendvicNone,krastavac,paradajz;
    TextView txtIzaberi,vrsta;
    ArrayList<String> sastojci=new ArrayList<String>();
    RecyclerView lista;
    Adapter adapter;
    public static int brSendvic=0;
    public static String cena;
    public static String nazSendvic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendvic);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        sendvicNone=findViewById(R.id.imageViewSendvic);
        lista=findViewById(R.id.rvAnimals);
        kc=findViewById(R.id.imageViewEK);
        pavlaka=findViewById(R.id.imageView5);
        zelena=findViewById(R.id.imageView6);
        my=findViewById(R.id.imageView7);
        krastavac=findViewById(R.id.imageView8);
        paradajz=findViewById(R.id.imageView3);

        txtIzaberi=findViewById(R.id.textView2);
        vrsta=findViewById(R.id.textView);
        if(brSendvic==1){
            sendvicNone.setImageResource(R.drawable.kulen);
            vrsta.setText(nazSendvic);
            txtIzaberi.setText("");
        }else if(brSendvic==2){
            sendvicNone.setImageResource(R.drawable.sunka);
            vrsta.setText(nazSendvic);
            txtIzaberi.setText("");
        }else if(brSendvic==3){
            sendvicNone.setImageResource(R.drawable.suvivrat);
            vrsta.setText(nazSendvic);
            txtIzaberi.setText("");
        }else if(brSendvic==4){
            sendvicNone.setImageResource(R.drawable.pecenica);
            vrsta.setText(nazSendvic);
            txtIzaberi.setText("");
        }
    }
    public void unesi(String naziv){
        sastojci.add(naziv);
        pozivFunkcije();
    }
    public void izbaci(String naziv){
        int i=sastojci.indexOf(naziv);
        sastojci.remove(sastojci.get(i));
        pozivFunkcije();
    }
    public void pozivFunkcije(){
        RecyclerView recyclerView = findViewById(R.id.rvSastojci);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, sastojci);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    public void pavlaka(View view) {
        if(pavlaka.getDrawable()==null){
            pavlaka.setImageResource(R.drawable.trueicon);
            unesi("   Pavlaka");
        }else{
            izbaci("   Pavlaka");
            pavlaka.setImageDrawable(null);
        }
    }
    public void paradajz(View view) {
        if(paradajz.getDrawable()==null){
            paradajz.setImageResource(R.drawable.trueicon);
            unesi("   Paradajz");
        }else{
            izbaci("   Paradajz");
            paradajz.setImageDrawable(null);
        }
    }
    public void krastavac(View view) {
        if(krastavac.getDrawable()==null){
            krastavac.setImageResource(R.drawable.trueicon);
            unesi("   Krastavac");
        }else{
            izbaci("   Krastavac");
            krastavac.setImageDrawable(null);
        }
    }
    public void mayo(View view) {
        if(my.getDrawable()==null){
            my.setImageResource(R.drawable.trueicon);
            unesi("   Majonez");
        }else{
            izbaci("   Majonez");
            my.setImageDrawable(null);
        }
    }
    public void ketchup(View view) {
        if(kc.getDrawable()==null){
            kc.setImageResource(R.drawable.trueicon);
            unesi("   Kecap");
        }else{
            izbaci("   Kecap");
            kc.setImageDrawable(null);
        }
    }
    public void salata(View view) {
        if(zelena.getDrawable()==null){
            zelena.setImageResource(R.drawable.trueicon);
            unesi("   Cili");
        }else{
            izbaci("   Cili");
            zelena.setImageDrawable(null);
        }
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    public void back(View view) {
        Intent i=new Intent(this,Home.class);
        finish();
        startActivity(i);
    }

    public void izaberiSendvic(View view) {
        txtIzaberi.setText("");
        sendviciVrste.vrsta="Sendvic";
        sendviciVrste.povratak=true;
        Intent i=new Intent(this,sendviciVrste.class);
        finish();
        startActivity(i);
    }

    public void otvoriKorpuSendvic1(View view) {
        Intent i= new Intent(this,korpa.class);
        finish();
        startActivity(i);
    }

    public void clickPiceSendvic1(View view) {
        Intent i= new Intent(this,picePodmeni.class);
        finish();
        startActivity(i);
    }

    public void clickHranaSendvic1(View view) {
        Intent i= new Intent(this,hrana.class);
        finish();
        startActivity(i);
    }

    public void zavrsi(View view) {
        if(brSendvic!=0){
            Porudzbina p=new Porudzbina();
            p.setNaziv(nazSendvic);
            p.setCena(Double.parseDouble(String.valueOf(cena)));
            p.setKolicina(1);
            Home.porudzbine.add(p);
            Intent i=new Intent(this,Home.class);
            finish();
            startActivity(i);
        }else{
            Toast.makeText(this, "Morate izabrati vrstu sendvica!", Toast.LENGTH_SHORT).show();
        }
    }

    public void backSendvic1(View view) {
        Intent i=new Intent(this,Home.class);
        finish();
        startActivity(i);
    }
}

