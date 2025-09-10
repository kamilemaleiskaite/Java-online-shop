package com.example.onlineshop.strategy;


public class KreditoKortele {
    private double amount = 100000;
    private final String number;
    private final String date;
    private final String cvv;

    public KreditoKortele(String number, String date, String cvv) {
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }
    public double getAmount() {return amount;}
    public String getNumber() {return number;}
    public String getDate() {return date;}
    public String getCvv() {return cvv;}
    public void setAmount(double amount) {this.amount = amount;}
}
