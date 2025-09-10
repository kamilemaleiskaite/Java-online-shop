/**
 * @author Kamile Maleiškaitė, PS 5 grupė
 * replace direct object construction calls (using the new operator) with calls to a special factory method.
 */
package com.example.onlineshop.factories;
import com.example.onlineshop.Produktas;
import com.example.onlineshop.products.ElekTechProduktas;

public class ElekTech extends ProduktasKlase {
    @Override
    public Produktas createProduktas(String name, double price) {
        return new ElekTechProduktas(name, price);
    }
}

