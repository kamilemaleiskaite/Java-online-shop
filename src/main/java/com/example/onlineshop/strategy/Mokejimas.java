package com.example.onlineshop.strategy;

import com.example.onlineshop.Controller2;
import com.example.onlineshop.MokejimoBudas;

public class Mokejimas {
    double cost;
    double amount;
    private MokejimoBudas mokejimoBudas;

    public void setMokejimoBudas(MokejimoBudas mokejimoBudas) {this.mokejimoBudas = mokejimoBudas;}
    public void apdorotiUzsakyma(Controller2 controller){
        this.cost = controller.apskaiciuoti();
        mokejimoBudas.vartotojoDuomenys();
        if(mokejimoBudas.duomenuPatikrinimas()){
            mokejimoBudas.mokejimas(cost);
        }
    }
}
