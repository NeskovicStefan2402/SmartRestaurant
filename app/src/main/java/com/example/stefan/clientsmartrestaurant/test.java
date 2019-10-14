package com.example.stefan.clientsmartrestaurant;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class test {

    public static ArrayList<Porudzbina> unesi(){
        ArrayList<Porudzbina> porudzbine=new ArrayList<>();
        Porudzbina p=new Porudzbina();
        p.setNaziv("Koka Kola");
        p.setCena(120);
        p.setKolicina(1);
        porudzbine.add(p);
        p=new Porudzbina();
        p.setNaziv("Kokta");
        p.setCena(120);
        p.setKolicina(1);
        porudzbine.add(p);
        p=new Porudzbina();
        p.setNaziv("Fanta");
        p.setCena(120);
        p.setKolicina(1);
        porudzbine.add(p);
        return porudzbine;
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void posalji() throws IOException {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }
    public static void jsonPost() throws IOException {
        FileWriter file = new FileWriter("C:\\Users\\Stefan\\Desktop\\ClientSmartRestaurant\\app\\src\\main\\java\\com\\example\\stefan\\clientsmartrestaurant\\JSONExample.json");
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        jsonObject.put("Sto",1);
        jsonObject.put("Radnik","Milos Milosevic");
        jsonObject.put("Korisnik",1234);
        ArrayList<Porudzbina> porudzbine=unesi();
        for(int i=0;i<porudzbine.size();i++){
            JSONObject obj=new JSONObject();
            obj.put("Naziv",porudzbine.get(i).getNaziv());
            obj.put("Cena",porudzbine.get(i).getCena());
            obj.put("Kolicina",porudzbine.get(i).getKolicina());
            jsonArray.add(obj);
        }
        jsonObject.put("Proizvodi",jsonArray);
        String jsonString=jsonObject.toJSONString();
        System.out.println(jsonString);
        file.write(jsonObject.toJSONString());
    }

    public static void jsonGet() throws IOException, ParseException {
        FileReader file = new FileReader("C:\\Users\\Stefan\\Desktop\\ClientSmartRestaurant\\app\\src\\main\\java\\com\\example\\stefan\\clientsmartrestaurant\\JSONExample.json");
        JSONParser parser=new JSONParser();
        Object obj=parser.parse(file);
        JSONObject object=(JSONObject) obj;
        JSONArray lista= (JSONArray) object.get("Proizvodi");
        for (int i=0;i<lista.size();i++){
            JSONObject objekat= (JSONObject) lista.get(i);
            if(objekat.get("Naziv").equals("Fanta")){
                System.out.println(lista.get(i).toString());
            }
        }
    }
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void main(String[] args){
        //jsonPost();
            try {
                jsonGet();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //posalji();
    }

}
