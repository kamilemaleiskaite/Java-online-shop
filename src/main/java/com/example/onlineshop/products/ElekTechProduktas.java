/**
 * @author Kamile Maleiškaitė, PS 5 grupė
 * replace direct object construction calls (using the new operator) with calls to a special factory method.
 */
package com.example.onlineshop.products;
import com.example.onlineshop.Decorator;
import com.example.onlineshop.Produktas;

public class ElekTechProduktas implements Produktas, Decorator {
    private String name;
    private double price;

    public ElekTechProduktas(String name, double price) {this.name = name; this.price = price;}
    @Override public String getName() {return name;}
    @Override public double getPrice() {return price;}
    @Override public String getDescription() {return name;}
}
