package com.example.alrobin;

import javafx.beans.property.SimpleStringProperty;

public abstract class Kisi {
    SimpleStringProperty modelisim;
    SimpleStringProperty miktar;
    SimpleStringProperty renk;

    public Kisi(SimpleStringProperty modelisim, SimpleStringProperty miktar, SimpleStringProperty renk) {
        this.modelisim = modelisimProperty();
        this.miktar = miktarProperty();
        this.renk = renkProperty();
    }

    public String getModelisim() {
        return modelisim.get();
    }

    public SimpleStringProperty modelisimProperty() {
        return modelisim;
    }

    public void setModelisim(String modelisim) {
        this.modelisim.set(modelisim);
    }

    public String getMiktar() {
        return miktar.get();
    }

    public SimpleStringProperty miktarProperty() {
        return miktar;
    }

    public void setMiktar(String miktar) {
        this.miktar.set(miktar);
    }

    public String getRenk() {
        return renk.get();
    }

    public SimpleStringProperty renkProperty() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk.set(renk);
    }
}
