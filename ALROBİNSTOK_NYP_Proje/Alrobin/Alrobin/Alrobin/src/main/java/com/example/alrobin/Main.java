package com.example.alrobin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

import java.io.File;

public class Main extends Application {
    static String path3 = "C:\\Users\\asus\\Desktop\\Alrobin\\Alrobin\\Alrobin\\src\\main\\resources\\com\\example\\alrobin\\Satışbilgileri.txt";
    static String path2 = "C:\\Users\\asus\\Desktop\\Alrobin\\Alrobin\\Alrobin\\src\\main\\resources\\com\\example\\alrobin\\stok.txt";
    static String path = "C:\\Users\\asus\\Desktop\\Alrobin\\Alrobin\\Alrobin\\src\\main\\resources\\com\\example\\alrobin\\Alrobindosya.txt";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 608, 450);
        stage.setTitle("ALROBİN TEKSTİL!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
        File file = new File("Alrobindosya.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        File file2 = new File("stok.txt");
        if(!file2.exists()){
            file2.createNewFile();
        }

    File file3 = new File("Satisbilgileri.txt");
        if(!file3.exists()){
        file3.createNewFile();
    }
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
    }

}