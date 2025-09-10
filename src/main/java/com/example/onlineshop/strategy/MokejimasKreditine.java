package com.example.onlineshop.strategy;

import com.example.onlineshop.MokejimoBudas;

public class MokejimasKreditine implements MokejimoBudas {
    private KreditoKortele kreditine;
        @Override public void vartotojoDuomenys() {
            kreditine = new KreditoKortele("kortelesNr", "galiojimoData", "cvv");
        }
        @Override public boolean duomenuPatikrinimas(){
            //patikrinam
            return true;
        }
        @Override public void mokejimas(double amount) {
            System.out.println("Mokama " + amount + "kreditine kortele");
            kreditine.setAmount(kreditine.getAmount() - amount);
        }
}
