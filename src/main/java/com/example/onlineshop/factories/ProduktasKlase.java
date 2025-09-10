/**
 * @author Kamile Maleiškaitė, PS 5 grupė
 * replace direct object construction calls (using the new operator) with calls to a special factory method.
 */
package com.example.onlineshop.factories;
import com.example.onlineshop.Produktas;

public abstract class ProduktasKlase {
    public Produktas order(String name, double price){
        Produktas produktas = createProduktas(name, price);
        return produktas;
    }
    public abstract Produktas createProduktas(String name, double price);
}






