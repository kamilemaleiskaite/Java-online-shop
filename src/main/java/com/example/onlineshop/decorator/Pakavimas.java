/**
 * @author Kamile Maleiškaitė, PS 5 grupė
 * Decorator is a structural design pattern that lets you attach new behaviors to objects by placing
 * these objects inside special wrapper objects that contain the behaviors.
 *  Use the Decorator pattern when you need to be able to assign extra behaviors to
 *  objects at runtime without breaking the code that uses these objects.
 */
package com.example.onlineshop.decorator;
import com.example.onlineshop.Produktas;

public class Pakavimas extends Dekoratorius{
    public Pakavimas(Produktas produktas) {
        super(produktas);
    }
    @Override public String getDescription() {
        String description = super.getDescription();
        return description + " + Sutvarkymas";
    }
}
