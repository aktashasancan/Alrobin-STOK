package com.example.alrobin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.example.alrobin.Controller.girisyapan;
import static com.example.alrobin.Main.path3;

public class Musteri extends Kisi implements Satisbilgileri{


    public Musteri(SimpleStringProperty modelisim, SimpleStringProperty miktar, SimpleStringProperty renk) {
        super(modelisim, miktar, renk);
    }


    @Override
    public void satisbilgilerigöster()throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path3));

        String yazı ="";
        String satir = reader.readLine();

        while(satir !=null){
                String array[] = satir.split(" ",5);
                String isim = array[0];
                String modelisim  = array[1];
                String fiyat = array[2];
                String miktar = array[3];
                String renk = array[4];
                if(isim.equals(girisyapan)){

                }
        }



    }
}
