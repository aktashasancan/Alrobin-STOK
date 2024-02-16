package com.example.alrobin;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;

public class Calisan extends Kisi implements Satisbilgileri{
    SimpleStringProperty isim ;
    SimpleStringProperty fiyat;

    public String getIsim() {
        return isim.get();
    }

    public SimpleStringProperty isimProperty() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim.set(isim);
    }

    public String getFiyat() {
        return fiyat.get();
    }

    public SimpleStringProperty fiyatProperty() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat.set(fiyat);
    }

    public Calisan(SimpleStringProperty isim, SimpleStringProperty modelisim, SimpleStringProperty fiyat, SimpleStringProperty miktar, SimpleStringProperty renk) {
        super(modelisim, miktar, renk);
        this.modelisim = modelisim;
        this.renk= renk;
        this.miktar=miktar;
        this.isim = isim;
        this.fiyat = fiyat;
    }



    @Override
    public void satisbilgilerigöster() throws IOException {

    }
}
