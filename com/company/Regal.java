package com.company;

import java.util.ArrayList;
import java.util.List;

public class Regal {
    private List<Przeslo> przesla;
    private int nrRegalu;


    public Regal(int nrRegalu) {
        this.nrRegalu = nrRegalu;
        this.przesla = new ArrayList<>();
    }

    public boolean addProdukt(Produkt p) {
        for (Przeslo przeslo : this.przesla) {
            if (przeslo.addProdukt(p)) {
                return true;
            }
        }
        return false;
    }

    public Produkt getProdukt(int idProdukt) {
        for (Przeslo przeslo : this.przesla) {
            Produkt p = przeslo.getProdukt(idProdukt);
            if (!p.isEmptyProd()) {
                return p;
            }
        }
        return Produkt.getNullProdukt();
    }

    public void addPrzeslo(int nrPrzesla) {
        this.przesla.add(new Przeslo(nrPrzesla));
    }

    @Override
    public String toString() {
        String s = "";
        s += "===================================\n";
        s += "Regal nr: " + this.nrRegalu + "\n";
        s += "-----------------------------------\n";
        for (Przeslo przeslo : this.przesla) {
            s += przeslo.toString();
        }
        s += "===================================\n";
        return s;
    }
    public static void main(String[] args) {
        // Test 1: Print information about the Regal class
        Regal r = new Regal(1);
        r.addPrzeslo(1);
        r.addPrzeslo(2);
        System.out.println(r.toString());

        // Test 2: Add a product to the shelf
        Produkt prod1 = new Produkt("Komputer", 10, 10, 10, 2);
        boolean result1 = r.addProdukt(prod1);
        System.out.println("Result1: " + result1);

        // Test 3: Get a product that exists/does not exist in the shelf
        int id = prod1.getId();
        Produkt prod2 = r.getProdukt(id);
        System.out.println("Result2: " + !prod2.isEmptyProd());

        id = -1;
        Produkt prod3 = r.getProdukt(id);
        System.out.println("Result3: " + prod3.isEmptyProd());
    }
}







