/**
 * @author Kamile Maleiškaitė, PS 5 grupė
 * Observer is a behavioral design pattern that lets you define a subscription
 * mechanism to notify multiple objects about any events that happen to the object they’re observing.
 */
package com.example.onlineshop.observer;
import com.example.onlineshop.EventListener;
import com.example.onlineshop.Produktas;

public class  NotificationService implements EventListener {
    private String username;
    public NotificationService(String username) {
        this.username = username;
    }
    public void notify(Produktas produktas) {
        System.out.println("[" + username + "] Naujos prekės sandėlyje: " +
                produktas.getName() + " - " + produktas.getPrice() + " EUR");
    }
}
