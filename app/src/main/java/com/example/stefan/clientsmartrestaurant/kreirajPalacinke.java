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

public class kreirajPalacinke extends AppCompatActivity implements Adapter.ItemClickListener{
    ImageView banana,plazma,nutella,marmelada,palacinke,malina,visnja;
    TextView txtIzaberi,vrsta;
    ArrayList<String> sastojci=new ArrayList<String>();
    RecyclerView lista;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kreiraj_palacinke);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        palacinke=findViewById(R.id.imageViewPalacinke);
        lista=findViewById(R.id.rvAnimals);
        banana=findViewById(R.id.imageViewB);
        malina=findViewById(R.id.imageViewM);
        plazma=findViewById(R.id.imageViewP);
        marmelada=findViewById(R.id.imageViewEK);
        visnja=findViewById(R.id.imageViewV);
        nutella=findViewById(R.id.imageViewN);

        RecyclerView recyclerView = findViewById(R.id.rvSastojci);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, sastojci);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }
    public void unesi(String naziv){
        sastojci.add(naziv);
    }
    public void izbaci(String naziv){
        int i=sastojci.indexOf(naziv);
        sastojci.remove(sastojci.get(i));
    }
    public void nutella(View view) {
        if(nutella.getDrawable()==null){
            nutella.setImageResource(R.drawable.trueicon);
            unesi("   Nutella");
        }else{
            izbaci("   Nutella");
            nutella.setImageDrawable(null);
        }
    }
    public void banana(View view) {
        if(banana.getDrawable()==null){
            banana.setImageResource(R.drawable.trueicon);
            unesi("   Banana");
        }else{
            izbaci("   Banana");
            banana.setImageDrawable(null);
        }
    }
    public void plazma(View view) {
        if(plazma.getDrawable()==null){
            plazma.setImageResource(R.drawable.trueicon);
            unesi("   Plazma");
        }else{
            izbaci("   Plazma");
            plazma.setImageDrawable(null);
        }
    }
    public void visnja(View view) {
        if(visnja.getDrawable()==null){
            visnja.setImageResource(R.drawable.trueicon);
            unesi("   Visnja");
        }else{
            izbaci("   Visnja");
            visnja.setImageDrawable(null);
        }
    }
    public void marmelada(View view) {
        if(marmelada.getDrawable()==null){
            marmelada.setImageResource(R.drawable.trueicon);
            unesi("   Marmelada");
        }else{
            izbaci("   Marmelada");
            marmelada.setImageDrawable(null);
        }
    }
    public void malina(View view) {
        if(malina.getDrawable()==null){
            malina.setImageResource(R.drawable.trueicon);
            unesi("   Malina");
        }else{
            izbaci("   Malina");
            malina.setImageDrawable(null);
        }
    }

    public void backHomeKreiranaP(View view) {
        Intent i=new Intent(this,Home.class);
        finish();
        startActivity(i);
    }

    public void otvoriKorpuKreiranaP(View view) {
        Intent i=new Intent(this,korpa.class);
        finish();
        startActivity(i);
    }

    public void clickHranaKreiranaP(View view) {
        Intent i=new Intent(this,hrana.class);
        finish();
        startActivity(i);
    }

    public void clickPiceKreiranaP(View view) {
        Intent i=new Intent(this,picePodmeni.class);
        finish();
        startActivity(i);
    }

    @Override
    public void onItemClick(View view, int position) {
    }
    public String ispisiSastojke(){
        String rec="";
        for(int i=0;i<sastojci.size();i++){
            rec=rec+","+sastojci.get(i);
        }
        return rec;
    }
    public void zavrsiKreiranaP(View view) {
        if(sastojci.size()!=0){
            Porudzbina p=new Porudzbina();
            p.setNaziv("Palacinke sa : "+ispisiSastojke());
            p.setCena(Double.parseDouble(String.valueOf(150)));
            p.setKolicina(1);
            Home.porudzbine.add(p);
            Intent i=new Intent(this,Home.class);
            finish();
            startActivity(i);
        }else{
            Toast.makeText(this, "Morate izabrati sastojak!", Toast.LENGTH_SHORT).show();
        }
    }
}
