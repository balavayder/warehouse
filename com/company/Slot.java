package com.company;

public class Slot{

    public static int idNB = 0;
    private final int id;
    private Produkt produkt;
    private double v; //dostepna objetosc


    public Slot(double objetosc){
        this.id = Slot.idNB++;
        this.v = objetosc;
        this.produkt = Produkt.getNullProdukt();
    }


    public boolean isOK() {
        return this.produkt.isEmptyProd() || this.produkt.getObjetosc() <= this.v;
    }


    public boolean addProdukt(Produkt p){
        if(p.getObjetosc() <= this.v && this.produkt.isEmptyProd()){
            this.produkt = p;
            return true;
        }else{
            return false;
        }
    }


    public Produkt delProdukt(){
        Produkt p = this.produkt;
        this.produkt = Produkt.getNullProdukt(); //new Produkt....
        return p;
    }


    public Produkt getProdukt(int idProduktu) {
        return this.produkt;
    }


    @Override
    public String toString(){
        String s = "";
        s += "===================================\n";
        s += "Slot id: " + this.id + "\n";
        s += "Objetosc: " + this.v + " [mm3]\n";
        s += "-----------------------------------\n";
        s += this.produkt.toString();
        s += "===================================\n";
        return s;
    }


    public static void main(String[] args){
        System.out.println(">>>TEST 1");
        Slot s = new Slot(1000);
        System.out.println(s.toString());
        System.out.println(">>>Status: " + true + "\n");

        System.out.println(">>>TEST 2a");
        Produkt p = new Produkt("Piec Gazowy", 10, 10, 10, 35);
        boolean sol = s.addProdukt(p);
        System.out.println(s.toString());
        System.out.println(">>>Status: " + sol + "\n");

        System.out.println(">>>TEST 3");
        Produkt pp = s.delProdukt();
        System.out.println(pp.toString());
        System.out.println(">>>Status: " + !pp.isEmptyProd() + "\n");

        System.out.println(">>>TEST 2b");
        p.setWymiary(1000, 1000, 1000);
        sol = s.addProdukt(p);
        System.out.println(s.toString());
        System.out.println(">>>Status: " + !sol + "\n");
    }
}