package com.example.alrobin;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.*;
import java.net.URL;

import java.util.ResourceBundle;

import static com.example.alrobin.Main.*;


public class Controller implements Initializable,Satisbilgileri {
    @FXML
    private Label toplamlabel;
    @FXML
    private Button satısbutton;
    @FXML
    private TableView<Stok> tablo;
    @FXML
    private Button stokeklebutton;
    @FXML
    private TableColumn<Stok,String> tablofiyat;
    @FXML
    private TableColumn<Stok,String> tablomiktar;
    @FXML
    private TableColumn<Stok,String> tablomodelisim;
    @FXML
    private TableColumn<Stok,String> tablorenk;
    @FXML
    private TableView<Calisan> tablo2;
    @FXML
    private TableColumn<Calisan, String> tablo2isim;
    @FXML
    private TableColumn<Calisan, String> tablo2fiyat;
    @FXML
    private TableColumn<Calisan, String> tablo2miktar;
    @FXML
    private TableColumn<Calisan, String> tablo2modelisim;
    @FXML
    private TableColumn<Calisan, String> tablo2renk;
    @FXML
    private Button kayitol_kayitol_btn;
    @FXML
    private Button giriş_kayitol_btn;
    @FXML
    private TextField miktartext;
    @FXML
    private Button satınalbutton;
    @FXML
    private Button onaylabutton;
    @FXML
    private TextField fiyattext;
    @FXML
    private TextField ödemeay;
    @FXML
    private Pane kartpane;
    @FXML
    private TextField ödemecvv;

    @FXML
    private TextField ödemeisim;

    @FXML
    private TextField ödemekartnumarası;

    @FXML
    private TextField ödemeyıl;
    @FXML
    private TextField miktarsatınal;
    @FXML
    private TextField renktext;
    @FXML
    private TextField modelisimtext;
    @FXML
    private Button geributton;
    @FXML
    private Button gerikard;
    @FXML
    private Button stokgeri_btn;
    @FXML
    private Button girisyap_girisyap_btn;
    @FXML
    private Button silbutton;
    @FXML
    private Button satısgeri_btn;
    @FXML
    private Button hesapla;
    @FXML
    private Pane satışpane;
    @FXML
    private Pane girişekranı;
    @FXML
    private Pane stokpane;
    @FXML
    private Button stokbutton;
    @FXML
    private Button girisekranıgeri_btn;
    @FXML
    private CheckBox çalışancheckbox;
    @FXML
    private CheckBox müştericheckbox;
    @FXML
    private Pane kayitol_pane;

    @FXML
    private Pane girisyap_pane;
    @FXML
    private TextField kayitol_isim_txtfield;
    @FXML
    private TextField kayitol_kullaniciadi_txtfield;
    @FXML
    private PasswordField kayitol_parola_passwordfield;
    @FXML
    private TextField girisyap_kullaniciadi_txtfield;
    @FXML
    private PasswordField girisyap_parola_passwordfield;
    static String girisyapan;
    @FXML
    public void girisekranıgeri_btn(ActionEvent event)throws IOException{
        girisyap_pane.toFront();
    }
    @FXML
    public void satısgeri_btn(ActionEvent event)throws IOException{
        girişekranı.toFront();
    }
    @FXML
    public void stokgeri_btn(ActionEvent event)throws IOException{
        girişekranı.toFront();
    }
    @FXML
    public void giriş_kayitol_btn(ActionEvent actionEvent)throws IOException {
        kayitol_pane.toFront();
    }
    ObservableList<Stok> tablo1 = FXCollections.observableArrayList();
    ObservableList<Calisan> tablo3 = FXCollections.observableArrayList();
    public void initialize (URL url , ResourceBundle rb){

      BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String satir = null;
        try {
            satir = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(satir!=null){

            String veri[] = satir.split(" ", 4);
            String isim = veri[0];
            String fiyat = veri[1];
            String miktar = veri[2];
            String renk = veri[3];

            tablo1.add(new Stok(veri[0], veri[1], veri[2], veri[3]));

            try {
                satir = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        tablomodelisim.setCellValueFactory(new PropertyValueFactory<Stok,String>("modelisim"));
        tablofiyat.setCellValueFactory(new PropertyValueFactory<Stok,String>("fiyat"));
        tablomiktar.setCellValueFactory(new PropertyValueFactory<Stok,String>("miktar"));
        tablorenk.setCellValueFactory(new PropertyValueFactory<Stok,String>("renk"));

        tablo.setItems(tablo1);


    }
    @FXML
    public void satısbutton(ActionEvent event)throws IOException{
        if(kisi ==false) {
            tablo2isim.setVisible(false);
            tablo2fiyat.setVisible(false);
            tablo2modelisim.setPrefWidth(200);
            tablo2miktar.setPrefWidth(200);
            tablo2renk.setPrefWidth(200);
            satışpane.toFront();
            müsterisatısbilgileri(girisyapan);
        }else{
            tablo2isim.setVisible(true);
            tablo2fiyat.setVisible(true);
            satışpane.toFront();
            satisbilgilerigöster();
        }
    }
    @FXML
    public void hesaplabutton(ActionEvent event)throws IOException {

        if(tablo.getSelectionModel().isEmpty()){
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setTitle("UYARI");
            warning.setHeaderText("LÜTFEN BİRŞEY SEÇİNİZ!");
            warning.show();
        }
        else if(!tablo.getSelectionModel().isEmpty() && miktarsatınal.getText().isEmpty()){
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setTitle("UYARI");
            warning.setHeaderText("LÜTFEN MİKTAR GİRİNİZ!");
            warning.show();
        }
        else{
            String fiyatstr = tablo.getSelectionModel().getSelectedItem().getFiyat();
            int fiyat = Integer.parseInt(fiyatstr);
            int miktar = Integer.parseInt(miktarsatınal.getText());
            String toplam = String.valueOf(fiyat * miktar);
            toplamlabel.setText("TOPLAM: " + toplam + "$");
        }
    }
    @FXML
    public void silbutton(ActionEvent event)throws IOException{
        String stokBilgi = "";
        BufferedReader reader = new BufferedReader(new FileReader(path2));

        int i = 0;

        String satir = reader.readLine();

        while(satir != null) {
            if(i != tablo.getSelectionModel().getSelectedIndex()) {
                stokBilgi += satir + "\n";
            }
            i++;

            satir = reader.readLine();
        }

        FileWriter writer = new FileWriter(path2);
        writer.write(stokBilgi);
        writer.close();
        tablo1.remove(tablo.getSelectionModel().getSelectedIndex());
        tablo.setItems(tablo1);

    }

   @FXML
   public void stokeklebutton(ActionEvent event)throws IOException{
       if (modelisimtext.getText().isEmpty() || fiyattext.getText().isEmpty() || renktext.getText().isEmpty() || miktartext.getText().isEmpty()) {
           Alert warning = new Alert(Alert.AlertType.WARNING);
           warning.setTitle("UYARI");
           warning.setHeaderText("LÜTFEN BOŞLUKLARI DOLDURUNUZ!");
           warning.show();
       }
    else if(modelisimtext.getText().contains(" ") || renktext.getText().contains(" ")){
           Alert warning = new Alert(Alert.AlertType.WARNING);
           warning.setTitle("UYARI");
           warning.setHeaderText("MODEL İSİM BOŞLUK İÇEREMEZ!");
           warning.show();
       }
    else{
           tablo1.add(new Stok(modelisimtext.getText(),fiyattext.getText(),miktartext.getText(),renktext.getText()));
           tablo.setItems(tablo1);
           FileWriter writer = new FileWriter(path2, true);

           String yeniVeri = "";

           yeniVeri = modelisimtext.getText() + " " + fiyattext.getText() + " " + miktartext.getText() + " " + renktext.getText() + "\n";

           writer.write(yeniVeri);
           writer.close();

       }
   }
   @FXML
   public void satınalbutton(ActionEvent event)throws IOException{

    if(tablo.getSelectionModel().isEmpty()){
        Alert warning = new Alert(Alert.AlertType.WARNING);
        warning.setTitle("UYARI");
        warning.setHeaderText("TABLODAN SEÇİM YAPINIZ!");
        warning.show();
    }
    else if(!tablo.getSelectionModel().isEmpty() && miktarsatınal.getText().isEmpty()) {
        Alert warning = new Alert(Alert.AlertType.WARNING);
        warning.setTitle("UYARI");
        warning.setHeaderText("LÜTFEN MİKTAR GİRİNİZ!");
        warning.show();
    }
    else if(tablo.getSelectionModel().getSelectedItem().getMiktar().equals("0")) {
        Alert warning = new Alert(Alert.AlertType.WARNING);
        warning.setTitle("UYARI");
        warning.setHeaderText("STOK OLMADIĞI İÇİN SATIŞ YAPILAMAZ!");
        warning.show();
    }
    else if(Integer.parseInt(miktarsatınal.getText())>Integer.parseInt(tablo.getSelectionModel().getSelectedItem().getMiktar())) {
        Alert warning = new Alert(Alert.AlertType.WARNING);
        warning.setTitle("UYARI");
        warning.setHeaderText("GİRİLEN MİKTAR STOK MİKTARINDAN FAZLA OLAMAZ!");
        warning.show();
    }


    else{
        hesaplabutton(event);


            kartpane.toFront();

    }

   }
   @FXML
   public void onaylabutton(ActionEvent event)throws IOException{
        if(ödemeisim.getText().isEmpty() || ödemeay.getText().isEmpty() || ödemecvv.getText().isEmpty() || ödemeyıl.getText().isEmpty() || ödemekartnumarası.getText().isEmpty()){
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setTitle("UYARI");
            warning.setHeaderText("LÜTFEN KART BİLGİLERİNDE BOŞLUK BIRAKMAYINIZ!");
            warning.show();
        }
        else{
            FileWriter writer = new FileWriter(path3, true);

            String yeniVeri = "";

            String modelIsimStr = tablo.getSelectionModel().getSelectedItem().modelisim;
            String fiyatStr = tablo.getSelectionModel().getSelectedItem().fiyat;

            String renkStr = tablo.getSelectionModel().getSelectedItem().renk;

            yeniVeri = girisyapan + " " + modelIsimStr + " " + fiyatStr + " " +miktarsatınal.getText() + " " + renkStr + "\n";

            writer.write(yeniVeri);
            writer.close();
            String miktarStr = String.valueOf((Integer.parseInt(tablo.getSelectionModel().getSelectedItem().miktar) - Integer.parseInt(miktarsatınal.getText())));

            BufferedReader reader = new BufferedReader(new FileReader(path2));

            String satir = reader.readLine();
            String yeniVeri2 = "";

            while(satir != null) {
                String veri[] = satir.split(" ", 4);

                if(veri[0].equals(tablo.getSelectionModel().getSelectedItem().getModelisim()) && veri[3].equals(tablo.getSelectionModel().getSelectedItem().getRenk())) {
                    String isim = veri[0];
                    String fiyat = veri[1];
                    String renk = veri[3];

                    yeniVeri2 += isim + " " + fiyat + " " + miktarStr + " " + renk + "\n";
                } else yeniVeri2 += satir + "\n";

                satir= reader.readLine();
            }

            FileWriter writer2 = new FileWriter(path2);

            writer2.write(yeniVeri2);
            writer2.close();
            Stok yenistok=new Stok(modelIsimStr,fiyatStr,miktarStr,renkStr);

            tablo1.set(tablo.getSelectionModel().getSelectedIndex(),yenistok);
            tablo.setItems(tablo1);
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setTitle("UYARI");
            warning.setHeaderText("SATIŞ İŞLEMİ BAŞARILI!");
            warning.showAndWait();
            stokpane.toFront();
        }
   }
   @FXML
   public void gerikard(ActionEvent event)throws IOException{
        stokpane.toFront();
   }
   @FXML
   public void stokbutton(ActionEvent event)throws IOException{
        stokpane.toFront();
        if(kisi==false) {
            stokeklebutton.setVisible(false);
            miktartext.setVisible(false);
            modelisimtext.setVisible(false);
            renktext.setVisible(false);
            fiyattext.setVisible(false);
            silbutton.setVisible(false);
            satınalbutton.setVisible(true);
            miktarsatınal.setVisible(true);
            toplamlabel.setVisible(true);
            hesapla.setVisible(true);



        }
        else{
            stokeklebutton.setVisible(true);
            miktartext.setVisible(true);
            modelisimtext.setVisible(true);
            renktext.setVisible(true);
            fiyattext.setVisible(true);
            silbutton.setVisible(true);
            satınalbutton.setVisible(false);
            miktarsatınal.setVisible(false);
            toplamlabel.setVisible(false);
            hesapla.setVisible(false);

        }
   }
   @FXML
   public void geributton(ActionEvent event)throws IOException{
        kayitol_pane.toBack();
        girisyap_pane.toFront();
   }

   @FXML
    public void kayitol_kayitol_btn(ActionEvent event) throws IOException {
       File file = new File("Alrobindosya.txt");
       if (!file.exists()) {
           file.createNewFile();
       }
       FileWriter fw = new FileWriter(file, true);

       BufferedWriter bw = new BufferedWriter(fw);
       if( event.getSource()==kayitol_kayitol_btn);
       try {


           if (kayitol_isim_txtfield.getText().isEmpty() || kayitol_kullaniciadi_txtfield.getText().isEmpty() || kayitol_parola_passwordfield.getText().isEmpty()) {
               Alert warning = new Alert(Alert.AlertType.WARNING);
               warning.setTitle("UYARI");
               warning.setHeaderText("LÜTFEN BOŞLUKLARI DOLDURUNUZ!");
               warning.show();

           } else if (!çalışancheckbox.isSelected() && (!müştericheckbox.isSelected())) {
               Alert warning = new Alert(Alert.AlertType.WARNING);
               warning.setTitle("UYARI");
               warning.setHeaderText("LÜTFEN SEÇİM KUTUSU SEÇİNİZ!");
               warning.show();
           } else {
               Alert warning = new Alert(Alert.AlertType.WARNING);
               warning.setTitle("UYARI");
               warning.setHeaderText("BAŞARIYLA KAYIT OLUNDU!");
               warning.show();
                String kullanıcı ="";
                if(çalışancheckbox.isSelected()) {
                    kullanıcı = "çalışan";

                }
                else{
                    kullanıcı="müşteri";
                }
               FileWriter writer= new FileWriter(path,true);
               String satır=kayitol_isim_txtfield.getText() + " " + kayitol_kullaniciadi_txtfield.getText() + " " + kayitol_parola_passwordfield.getText() + " " + kullanıcı + "\n";
               writer.write(satır);
               writer.close();
           }

       } catch (Exception e) {
           e.printStackTrace();
       }


   }
   @FXML
    public void çalışancheckbox(ActionEvent event) throws IOException{
        if(çalışancheckbox.isSelected()){
            müştericheckbox.setSelected(false);
        }
   }
   @FXML
   public void müştericheckbox(ActionEvent event) throws IOException {
           if (müştericheckbox.isSelected()) {
               çalışancheckbox.setSelected(false);
           }

       }
    boolean kisi=true;
    @FXML
    public void girisyap_girisyap_btn(ActionEvent event) throws IOException{
        File file = new File("Alrobindosya.txt");
        boolean kullaniciVarMi = false;
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String satir = reader.readLine();
        while(satir!=null){
            String index[] = satir.split(" ",4);
            String isim = index[0];
            String kullaniciadi = index[1];
            String parola = index[2];
            String kullanici = index[3];

            if(girisyap_kullaniciadi_txtfield.getText().equals(kullaniciadi) && girisyap_parola_passwordfield.getText().equals(parola)){
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("UYARI");
                warning.setHeaderText("GİRİŞ BAŞARILI!");
                warning.showAndWait();
                kullaniciVarMi = true;
                if(kullanici.equals("çalışan")){
                    kisi=true;
                    girisyapan=isim;

                }
                else{
                    kisi=false;
                    girisyapan=isim;

                }
                girişekranı.toFront();
                break;

            }
            else if(!girisyap_parola_passwordfield.getText().equals(parola) && girisyap_kullaniciadi_txtfield.getText().equals(kullaniciadi)){
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("UYARI");
                warning.setHeaderText("KULLANICI ADI VEYA PAROLA HATALI!");
                warning.show();
                kullaniciVarMi = true;
                break;
            }
            else{
                satir= reader.readLine();
            }
        }
        if(!kullaniciVarMi) {
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setTitle("UYARI");
            warning.setHeaderText("KULLANICI ADI VEYA PAROLA HATALI!");
            warning.show();
        }
    }
    public void müsterisatısbilgileri(String girisyapan) throws IOException{
        tablo3.clear();
        BufferedReader reader2 = null;
        try {
            reader2 = new BufferedReader(new FileReader(path3));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String satir2 = null;
        try {
            satir2 = reader2.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(satir2!=null) {

            String array[] = satir2.split(" ", 5);
            if (array[0].equals(girisyapan)) {


                SimpleStringProperty isim = new SimpleStringProperty(array[0]);
                SimpleStringProperty modelisim = new SimpleStringProperty(array[1]);
                SimpleStringProperty fiyat = new SimpleStringProperty(array[2]);
                SimpleStringProperty miktar = new SimpleStringProperty(array[3]);
                SimpleStringProperty renk = new SimpleStringProperty(array[4]);

                tablo3.add(new Calisan(isim, modelisim, fiyat, miktar, renk));

                tablo2isim.setCellValueFactory(new PropertyValueFactory<Calisan, String>("isim"));
                tablo2modelisim.setCellValueFactory(new PropertyValueFactory<Calisan, String>("modelisim"));
                tablo2fiyat.setCellValueFactory(new PropertyValueFactory<Calisan, String>("fiyat"));
                tablo2miktar.setCellValueFactory(new PropertyValueFactory<Calisan, String>("miktar"));
                tablo2renk.setCellValueFactory(new PropertyValueFactory<Calisan, String>("renk"));

                tablo2.setItems(tablo3);
            }
                try {
                    satir2 = reader2.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

    }

    @Override
    public void satisbilgilerigöster() throws IOException {
        tablo3.clear();
        BufferedReader reader2 = null;
        try {
            reader2 = new BufferedReader(new FileReader(path3));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String satir2 = null;
        try {
            satir2 = reader2.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(satir2!=null){

            String array[] = satir2.split(" ", 5);
            SimpleStringProperty isim =new SimpleStringProperty(array[0]);
            SimpleStringProperty modelisim  =new SimpleStringProperty(array[1]);
            SimpleStringProperty fiyat = new SimpleStringProperty(array[2]);
            SimpleStringProperty miktar = new SimpleStringProperty(array[3]);
            SimpleStringProperty renk =new SimpleStringProperty(array[4]);

            tablo3.add(new Calisan(isim,modelisim,fiyat,miktar,renk));

            try {
                satir2 = reader2.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        tablo2isim.setCellValueFactory(new PropertyValueFactory<Calisan,String>("isim"));
        tablo2modelisim.setCellValueFactory(new PropertyValueFactory<Calisan,String>("modelisim"));
        tablo2fiyat.setCellValueFactory(new PropertyValueFactory<Calisan,String>("fiyat"));
        tablo2miktar.setCellValueFactory(new PropertyValueFactory<Calisan,String>("miktar"));
        tablo2renk.setCellValueFactory(new PropertyValueFactory<Calisan,String>("renk"));

        tablo2.setItems(tablo3);
    }
}





