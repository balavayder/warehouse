package com.company;

import java.util.ArrayList;
import java.util.List;

public class Przeslo {
    private List<Slot> slots;
    private int nrPrzesla;

    public Przeslo(int nrPrzesla) {
        this.nrPrzesla = nrPrzesla;
        this.slots = new ArrayList<>();
    }

    public boolean addProdukt(Produkt p) {
        for (Slot slot : this.slots) {
            if (slot.isOK() && slot.addProdukt(p)) {
                return true;
            }
        }
        return false;
    }

    public Produkt getProdukt(int idProdukt) {
        for (Slot slot : this.slots) {
            Produkt p = slot.getProdukt(idProdukt);
            if (!p.isEmptyProd()) {
                return p;
            }
        }
        return Produkt.getNullProdukt();
    }

    public boolean isOK() {
        for (Slot slot : this.slots) {
            if (!slot.isOK()) {
                return false;
            }
        }
        return true;
    }


    public void addSlot(double objetosc) {
        this.slots.add(new Slot(objetosc));
    }

    @Override
    public String toString() {
        String s = "";
        s += "===================================\n";
        s += "Przeslo nr: " + this.nrPrzesla + "\n";
        s += "-----------------------------------\n";
        for (Slot slot : this.slots) {
            s += slot.toString();
        }
        s += "===================================\n";
        return s;
    }
    public static void main(String[] args) {
        // Test 1: Print information about the Przeslo class
        Przeslo p = new Przeslo(1);
        System.out.println(p.toString());

        // Test 2: Add a product with a valid/invalid volume
        Produkt prod1 = new Produkt("Komputer", 10, 10, 10, 2);
        p.addSlot(1000);
        boolean result1 = p.addProdukt(prod1);
        System.out.println("Result1: " + result1);

        Produkt prod2 = new Produkt("Szafa", 1000, 1000, 1000, 500);
        boolean result2 = p.addProdukt(prod2);
        System.out.println("Result2: " + result2);

        // Test 3: Get a product that exists/does not exist in the shelf
        int id = prod1.getId();
        Produkt prod3 = p.getProdukt(id);
        System.out.println("Result3: " + !prod3.isEmptyProd());

        id = -1;
        Produkt prod4 = p.getProdukt(id);
        System.out.println("Result4: " + prod4.isEmptyProd());

        // Test 4: Check if the isOK() method works correctly
        boolean result5 = p.isOK();
        System.out.println("Result5: " + result5);

        p.addSlot(-1);
        boolean result6 = p.isOK();
        System.out.println("Result6: " + !result6);
    }
}
