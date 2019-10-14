package com.example.stefan.clientsmartrestaurant;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class korpa extends AppCompatActivity implements Adapter.ItemClickListener {
    ImageView slika;
    ArrayList<Porudzbina> por=new ArrayList<>();
    Adapter adapter;
    TextView suma;
    Button korpa,end,hrana,pice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korpa);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        StrictMode.ThreadPolicy policy =
                new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        slika=findViewById(R.id.imageView);
        suma=findViewById(R.id.tvSuma);
        end=findViewById(R.id.button3);
        if(Home.brojac==0){
            suma.setText("  "+(int) Suma()+".00RSD");
        }else{
            double euro=Math.round(Suma())/117.5;
            DecimalFormat f = new DecimalFormat("##.00");
            suma.setText("  "+f.format(euro)+" EUR");
        }

        korpa=findViewById(R.id.btn_korpaKorpa);
        hrana=findViewById(R.id.btn_hrana2);
        pice=findViewById(R.id.btn_pice2);
        povecaj(korpa);
        Home.prevedi(hrana,pice,korpa,null);
        prevediZavrsi();

        RecyclerView recyclerView = findViewById(R.id.rvStavka);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, stavke());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    public static void povecaj(Button btn){
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) btn.getLayoutParams();
        params.width = 350;
        btn.setLayoutParams(params);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void zavrsiKupovinu(View view) throws IOException {
        klik("Porudzbina");
        if(Home.porudzbine.size()!=0){

        Animation zoom = AnimationUtils.loadAnimation(this, R.anim.zoom);
        slika.startAnimation(zoom);
        Intent i=new Intent(this,Home.class);
        startActivity(i);
        Home.porudzbine=new ArrayList<Porudzbina>();
        }else{
            Toast.makeText(this,"Prazna korpa!",Toast.LENGTH_LONG).show();
        }
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void posalji() throws IOException {
        URL url=new URL ("https://192.168.0.166:5000/");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        ArrayList<Porudzbina> porudzbine=Home.porudzbine;
        for(int i=0;i<porudzbine.size();i++){
            JSONObject obj=new JSONObject();
            obj.put("Naziv",porudzbine.get(i).getNaziv());
            obj.put("Cena",porudzbine.get(i).getCena());
            obj.put("Kolicina",porudzbine.get(i).getKolicina());
            jsonArray.add(obj);
        }
        jsonObject.put("Proizvodi",jsonArray);

        String jsonInputString=jsonObject.toJSONString();
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }


    }
    public String ispisiPorudzbinu(){
        String rec="";
        for(int i=0;i< Home.porudzbine.size();i++){
            rec+=Home.porudzbine.get(i).getNaziv()+"  ";
        }
        return rec;
    }
    public void back(View view) {
        Intent i=new Intent(this,Home.class);
        finish();
        startActivity(i);
        }

    public double Suma(){
        double sumaS=0;
        for (int i=0;i<Home.porudzbine.size();i++){
            sumaS+=(double) Home.porudzbine.get(i).getCena()*Home.porudzbine.get(i).getKolicina();
        }
        return sumaS;
    }
    public void klik(String ele){
        URL url;
        HttpURLConnection con = null;
        try {
            url = new URL("http://192.168.0.166:5000/"+ele);
            con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(1500);
            con.setReadTimeout(1000);
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader
                    (con.getInputStream(), "UTF-8"));
            String odgovor = null;
            String rezultat = "";
            while((odgovor = reader.readLine())!=null) {
                rezultat += odgovor;
            }

            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if(con != null)
                con.disconnect();
        }

    }
    @Override
    public void onItemClick(View view, int position) {
         Home.porudzbine.remove(Home.porudzbine.get(position));
         Intent i=new Intent(this,korpa.class);
         startActivity(i);
    }
    public ArrayList<String> stavke(){
        ArrayList<Porudzbina> p=Home.porudzbine;
        ArrayList<String> prozvodi=new ArrayList<String>();
        for (int i=0;i<p.size();i++){
            prozvodi.add(p.get(i).getNaziv()+"      "+p.get(i).getCena()+" RSD");
        }
        return prozvodi;

    }
    public void clickPice(View view) {
        Intent i=new Intent(this,picePodmeni.class);
        finish();
        startActivity(i);
    }
    public void clickHrana(View view) {
        Intent i=new Intent(this,hrana.class);
        vrstapice.povratak=false;
        vrstapice.vrsta="Obicno";
        finish();
        startActivity(i);
    }
    public void prevediZavrsi(){
        if(Home.brojac==0){
            end.setText("Zavrsi kupovinu");
        }else if(Home.brojac==1){
            end.setText("Finish");
        }else if(Home.brojac==2){
            end.setText("Terminer");
        }else{
            end.setText("Fertig");
        }
    }
}
