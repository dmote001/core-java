package com.design_patterns.creational.factory.notification_factory_example.classes.concrete_products;

import com.design_patterns.creational.factory.notification_factory_example.interfaces.products.Notification;

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Email Notification Sent ---->>");
    }
}
