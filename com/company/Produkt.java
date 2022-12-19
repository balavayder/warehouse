package com.company;

import javax.swing.text.Style;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Produkt {
    private int volume;
    public static int nbId = 0;

    private int id;
    private String nazwa;

    private String kolor;
    private float x; // mm
    private float y; // mm
    private float z; // mm
    private float m; // kg


    public Produkt(int volume) {
        this.volume = volume;
    }


    public static Produkt getNullProdukt() {
        return new Produkt();
    }


    public boolean isEmptyProd() {
        return this.nazwa.equals("Produkt") && this.kolor.equals("BRAK") && this.x == 0 && this.y == 0 && this.z == 0 && this.m == 0; // Replace this with the correct implementation
    }


    public int getId() {
        return this.id;
    }


    public void setNbId(){
        this.id = Produkt.nbId++;
        //Produkt.nbId = Produkt.nbId + 1;
    }


    public Produkt(){
        this.setNbId();
        this.nazwa = "Produkt";
        this.setKolor("BRAK");
        this.setWymiary(0,0,0);
        this.setWaga(0);
    }


    public Produkt(String nazwa, String kolor, float x, float y, float z, float m ){
        this.setNbId();
        this.nazwa = nazwa;
        this.setKolor(kolor);
        this.setWymiary(x,y,z);
        this.setWaga(m);
    }


    public Produkt(String kolor, float x, float y, float z, float m ){
        this.setNbId();
        this.nazwa = "Produkt";
        this.setKolor(kolor);
        this.setWymiary(x,y,z);
        this.setWaga(m);
    }


    public void setKolor(String kolor) {
        this.kolor = kolor;
    }


    public void setWaga(float m) {
        if (m > 0 && m <= 500) {
            this.m = m;
        }else{
            this.m = 0;
        }
    }


    public void setWymiary(float x, float y, float z){
        this.x = 0;
        this.y = 0;
        this.z = 0;
        if (x > 0  && x <= 1500)
            this.x = x;
        if (y > 0  && y <= 1500)
            this.y = y;
        if (z > 0  && z <= 1500)
            this.z = z;
    }


    public void save(){
        try {

            FileWriter w = new FileWriter(this.nazwa + "_" + this.id + "_.txt");
            w.write(this.nazwa + "\n");
            w.write(this.kolor + "\n");
            w.write(this.x + "\n");
            w.write(this.y + "\n");
            w.write(this.z + "\n");
            w.write(this.m + "\n");
            w.close();

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }


    @Override
    public String toString() {
        String s = "";
        s += "==================================\n";
        s += this.nazwa + " [" + this.id + "]\n";
        s += "==============INFO================\n";
        s += "   Waga [m]:  " + this.m + " [kg]\n";
        s += "   Kolor: " + this.kolor + "\n";
        s += "----------------------------------\n";
        s += "Wymiary\n";
        s += "   szer [x]: " + this.x + " [mm]\n";
        s += "   dlug [y]: " + this.y + " [mm]\n";
        s += "   wyso [z]: " + this.z + " [mm]\n";
        s += "==================================\n";

        return s;
    }


    public static void getRandomSet(int n, int startID){
        Produkt.nbId = startID;
        for (int i = 0; i < n; i++){
            Random rr = new Random();
            Produkt p = new Produkt("czerewony", rr.nextInt(1500), rr.nextInt(1500), rr.nextInt(1500), rr.nextFloat(500));
            p.save();
            System.out.println(p.toString());
        }
    }


    public static void main(String[] args) {
//        Produkt p1 = new Produkt();
//        System.out.println(p1.toString());
//
//        Produkt p2 = new Produkt();
//        p2.setWymiary(-100,200,-300);
//        System.out.println(p2.toString());
//
//        Produkt p3 = new Produkt("Produkt testowy", "czerwony", 100, 200 ,300, 50);
//        System.out.println(p3.toString());
//
//        Produkt p4 = new Produkt("czerewony", 100, 200, 300, 50);
//        System.out.println(p4.toString());

//        for (int i = 0; i < 10; i++){
//            Random rr = new Random();
//            Produkt p = new Produkt("czerewony", rr.nextInt(1500), rr.nextInt(1500), rr.nextInt(1500), rr.nextFloat(500));
//            p.save();
//            System.out.println(p.toString());
//        }

        //System.out.println(Produkt.nbId);


        Produkt.getRandomSet(10, 0);
        Produkt.getRandomSet(10, 100);

    }

    public double getObjetosc() {

        return this.x * this.y * this.z;
    }
}
