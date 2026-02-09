package com.design_patterns.creational.factory;


import com.design_patterns.creational.factory.notification_factory_example.classes.concrete_factory.EmailNotificationFactory;
import com.design_patterns.creational.factory.notification_factory_example.classes.concrete_factory.SMSNotificationFactory;
import com.design_patterns.creational.factory.notification_factory_example.interfaces.factory.NotificationFactory;
import com.design_patterns.creational.factory.notification_factory_example.interfaces.products.Notification;

public class FactoryMain {

    public static void main(String[] args) {
//        Notification notification = new SMSNotification();
//        Notification notification1 = new EmailNotification();
//        notification.send("msg");
//
//        NotificationFactory_1 notificationFactory = new NotificationFactory_1();
//        Notification email = notificationFactory.createInstance("email");
        String type = "sms";
        Notification notification = switch (type) {
            case "email" -> new EmailNotificationFactory().createInstance();
            case "sms"   -> new SMSNotificationFactory().createInstance();
            default -> null;
        };

        notification.send("hello");
    }

}



/*
*  Design pattern :
*
*  factory -> concrete factory -> product -> concrete product
*
*
*  Abstract Factory Pattern - Factory of Factory
* Car factory - suv
* india  car factory  -   SUV, JEEP
* europe car factory -  HATCHBACK, SEDAN
*
* */