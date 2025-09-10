/**
 * @author Kamile Maleiškaitė, PS 5 grupė
 * Decorator is a structural design pattern that lets you attach new behaviors to objects by placing
 * these objects inside special wrapper objects that contain the behaviors.
 *  Use the Decorator pattern when you need to be able to assign extra behaviors
 *  to objects at runtime without breaking the code that uses these objects.
 */
package com.example.onlineshop.decorator;
import com.example.onlineshop.Produktas;

public class Dekoratorius implements Produktas {
    protected Produktas produktas;
    public Dekoratorius(Produktas produktas) {
        this.produktas = produktas;
    }
    @Override public String getDescription(){return produktas.getDescription();};
    @Override public String getName(){return produktas.getName();};
    @Override public double getPrice(){return produktas.getPrice();};
}
