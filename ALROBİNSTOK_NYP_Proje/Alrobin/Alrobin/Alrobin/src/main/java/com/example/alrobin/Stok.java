package com.example.alrobin;

public class Stok {
    public Stok(String modelisim, String fiyat, String miktar, String renk) {
        this.modelisim = modelisim;
        this.fiyat = fiyat;
        this.miktar = miktar;
        this.renk = renk;
    }

    String modelisim,fiyat,miktar,renk;

    public String getModelisim() {
        return modelisim;
    }

    public void setModelisim(String modelisim) {
        this.modelisim = modelisim;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getMiktar() {
        return miktar;
    }

    public void setMiktar(String miktar) {
        this.miktar = miktar;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }
}
