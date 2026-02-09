package com.design_patterns.creational.factory.notification_factory_example.classes.concrete_products;

import com.design_patterns.creational.factory.notification_factory_example.interfaces.products.Notification;

public class NotificationFactory_1 {

    public Notification createInstance(String type){
        switch (type){
            case "email" : return new EmailNotification();
            case "sms" : return new SMSNotification();
            case "telegram" : return new TelegramNotification();
            default: return null;
        }
    }

}
