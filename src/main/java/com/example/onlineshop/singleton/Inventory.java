/**
 * @author Kamile Maleiškaitė, PS 5 grupė
 * Singleton is a creational design pattern that lets you ensure
 * that a class has only one instance, while providing a global access point to this instance.
 * Make the default constructor private, to prevent other objects from using the new operator with the Singleton class.
 * Create a static creation method that acts as a constructor. Under the hood, this method calls the private constructor
 * to create an object and saves it in a static field. All following calls to this method return the cached object.
 */
package com.example.onlineshop.singleton;
import com.example.onlineshop.EventListener;
import com.example.onlineshop.Produktas;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static volatile Inventory instance;
    private List<Produktas> produktai;
    private List<EventListener> listeners = new ArrayList<>();

    private Inventory() {produktai = new ArrayList<>();}

    public static Inventory getInstance() {
        Inventory inventory = instance;
        if(inventory == null){
            synchronized (Inventory.class) {
                inventory = instance;
                if (inventory == null) {
                    instance = inventory = new Inventory();
                }
            }
        }
        return inventory;
    }
    public void addObserver(EventListener eventListener) {listeners.add(eventListener);}
    public void addProduct(Produktas produktas) {produktai.add(produktas); notifyObservers(produktas);}
    public void notifyObservers(Produktas produktas) {
        for (EventListener listener : listeners) {
            listener.notify(produktas);
        }
    }
    public List<Produktas> getProducts() {return produktai;}


}
