/**
 * @author Kamile Maleiškaitė, PS 5 grupė
 * replace direct object construction calls (using the new operator) with calls to a special factory method.
 */
package com.example.onlineshop.factories;
import com.example.onlineshop.Produktas;
import com.example.onlineshop.products.KnygaProduktas;

public class Knyga extends ProduktasKlase {
    @Override
    public Produktas createProduktas(String name, double price) {
        return new KnygaProduktas(name, price);
    }
}
