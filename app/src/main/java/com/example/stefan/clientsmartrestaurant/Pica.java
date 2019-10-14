package com.example.stefan.clientsmartrestaurant;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pica extends AppCompatActivity implements Adapter.ItemClickListener {
    ImageView ch,kc,orig,my,pizza;
    TextView txtIzaberi,vrsta;
    ArrayList<String> sastojci=new ArrayList<String>();
    RecyclerView lista;
    Adapter adapter;
    public static int brPice=0;
    public static String cena;
    public static String nazPice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pica);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        pizza=findViewById(R.id.imageViewPizza);
        lista=findViewById(R.id.rvAnimals);
        kc=findViewById(R.id.imageViewEK);
        orig=findViewById(R.id.imageView5);
        ch=findViewById(R.id.imageView6);
        my=findViewById(R.id.imageView7);
        txtIzaberi=findViewById(R.id.textView2);
        vrsta=findViewById(R.id.textView);
        if(brPice==1){
            pizza.setImageResource(R.drawable.capriccosa);
            vrsta.setText(nazPice);
            txtIzaberi.setText("");
        }else if(brPice==2){
            pizza.setImageResource(R.drawable.margherita);
            vrsta.setText(nazPice);
            txtIzaberi.setText("");
        }else if(brPice==3){
            pizza.setImageResource(R.drawable.vegeterijana);
            vrsta.setText(nazPice);
            txtIzaberi.setText("");
        }else if(brPice==4){
            pizza.setImageResource(R.drawable.quattro);
            vrsta.setText(nazPice);
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
    public void oregano(View view) {
        if(orig.getDrawable()==null){
        orig.setImageResource(R.drawable.trueicon);
        unesi("   Oregano");
        }else{
            izbaci("   Oregano");
            orig.setImageDrawable(null);
        }
    }
    public void mayo(View view) {
        if(my.getDrawable()==null){
            my.setImageResource(R.drawable.trueicon);
            unesi("   Mayonese");
        }else{
            izbaci("   Mayonese");
            my.setImageDrawable(null);
        }
    }
    public void ketchup(View view) {
        if(kc.getDrawable()==null){
            kc.setImageResource(R.drawable.trueicon);
            unesi("   Ketchup");
        }else{
            izbaci("   Ketchup");
            kc.setImageDrawable(null);
        }
    }
    public void chilli(View view) {
        if(ch.getDrawable()==null){
            ch.setImageResource(R.drawable.trueicon);
            unesi("   Chilli");
        }else{
            izbaci("   Chilli");
            ch.setImageDrawable(null);
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

    public void izaberiPicu(View view) {
        txtIzaberi.setText("");
        vrstapice.vrsta="Pica";
        vrstapice.povratak=true;
        Intent i=new Intent(this,vrstapice.class);
        finish();
        startActivity(i);
    }

    public void otvoriKorpuPica(View view) {
        Intent i= new Intent(this,korpa.class);
        finish();
        startActivity(i);
    }

    public void clickPicePica(View view) {
        Intent i= new Intent(this,picePodmeni.class);
        finish();
        startActivity(i);
    }

    public void clickHranaPica(View view) {
        Intent i= new Intent(this,hrana.class);
        finish();
        startActivity(i);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void zavrsi(View view) {
        if(brPice!=0){
        Porudzbina p=new Porudzbina();
        p.setNaziv(nazPice);
        p.setCena(Double.parseDouble(String.valueOf(cena)));
        p.setKolicina(1);
        Home.porudzbine.add(p);
        sastojci.clear();
        brPice=0;
        Intent i=new Intent(this,Home.class);
        finish();
        startActivity(i);
        }else{
            Toast.makeText(this, "Morate izabrati vrstu pice!", Toast.LENGTH_SHORT).show();
        }
    }
}
