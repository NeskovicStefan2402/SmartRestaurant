package com.example.stefan.clientsmartrestaurant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.VideoView;

import java.util.ArrayList;

import static com.example.stefan.clientsmartrestaurant.R.*;

public class Home extends AppCompatActivity {
    int nivo;
    public static int brojac=0;
    Button mutebtn;
    String jezik="Srpski";
    Button pice, hrana,jez,korpa;
    public static ArrayList<Porudzbina> porudzbine = new ArrayList<Porudzbina>();
    public static MediaPlayer player;
    VideoView vv;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        jez=findViewById(id.language);
        mutebtn=findViewById(id.mute);
        hrana=findViewById(id.btn_hrana);
        pice=findViewById(id.btn_pice);
        korpa=findViewById(id.btn_korpa);
        vv=findViewById(id.imageView2);

        prevedi(hrana,pice,korpa,jez);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.robovideo);
        vv.setVideoURI(uri);
        vv.start();
        vv.setOnCompletionListener ( new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                vv.start();
            }
        });
        /*if(player==null) {
            player = MediaPlayer.create(this, R.raw.jazz);
        }player.start();
        */
    }

    public void clickPice(View view) {
        Intent i = new Intent(this, picePodmeni.class);
        finish();
        startActivity(i);
    }

    public void clickHrana(View view) {
        Intent i = new Intent(this, hrana.class);
        finish();
        startActivity(i);
    }

    public void back(View view) {
        pocetno();
    }

    public void pocetno() {
        pice.setBackgroundResource(R.drawable.drink);
        hrana.setBackgroundResource(R.drawable.food);
    }

    public static void animacija(View view) {
        TranslateAnimation animation1 = new TranslateAnimation(5.0f, -4.0f,
                00.0f, 0.0f);
        animation1.setDuration(300);
        animation1.setRepeatCount(1);
        animation1.setRepeatMode(2);
        view.startAnimation(animation1);
    }

    public void otvoriKorpu(View view) {
        Intent i = new Intent(this, korpa.class);
        startActivity(i);
    }

    public void birajJezik(View view) {
        if(brojac==3){
            brojac=0;
        }else{
            brojac++;
        }
        prevedi(hrana,pice,korpa,jez);
    }

    public void mute(View view) {
    /*if(player!=null){
        int duzina=player.getCurrentPosition();
        if(player.isPlaying()){
            mutebtn.setBackgroundResource(R.drawable.off);
            player.pause();
        }else{
            mutebtn.setBackgroundResource(R.drawable.on);
            player.seekTo(duzina);
            player.start();
        }
    }else{
        player.start();
    }*/
 }
    public static void prevedi(Button hrana,Button pice,Button korpa,Button jez){
        if(Home.brojac==0){
            if(jez!=null) {
                jez.setBackgroundResource(drawable.srb);
            }hrana.setText("Hrana");
            pice.setText("Pice");
            korpa.setText("Korpa");
        }else if(Home.brojac==1){
            if(jez!=null) {
                jez.setBackgroundResource(drawable.eng);
            }
            hrana.setText("Food");
            pice.setText("Drink");
            korpa.setText("Cart");
        }else if(Home.brojac==2){
            if(jez!=null) {
                jez.setBackgroundResource(drawable.france);
            }
            hrana.setText("Aliments");
            pice.setText("Boire");
            korpa.setText("Chariot");
        }else{
            if(jez!=null) {
                jez.setBackgroundResource(drawable.ger);
            }
            hrana.setText("Essen");
            pice.setText("Trinken");
            korpa.setText("Wagen");
        }
    }

    public void pizza(View view) {
    }

}
