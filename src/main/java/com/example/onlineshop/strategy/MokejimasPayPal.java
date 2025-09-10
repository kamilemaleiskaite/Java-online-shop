package com.example.onlineshop.strategy;

import com.example.onlineshop.MokejimoBudas;

public class MokejimasPayPal implements MokejimoBudas {
    private String email;
    private String password;

    @Override public void vartotojoDuomenys() {
        email = "...";
        password = "...";
    }
    @Override public boolean duomenuPatikrinimas() {
        //patikrinam, ar geri duomenys
        return true;
    }
    @Override public void mokejimas(double amount){
        System.out.println("Mokama " + amount + "PayPal");
    }
}
