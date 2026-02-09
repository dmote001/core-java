package com.design_patterns.creational.factory.notification_factory_example.classes.concrete_factory;

import com.design_patterns.creational.factory.notification_factory_example.classes.concrete_products.SMSNotification;
import com.design_patterns.creational.factory.notification_factory_example.classes.concrete_products.TelegramNotification;
import com.design_patterns.creational.factory.notification_factory_example.interfaces.factory.NotificationFactory;
import com.design_patterns.creational.factory.notification_factory_example.interfaces.products.Notification;

public class TelegramNotificationFactory implements NotificationFactory {
    @Override
    public Notification createInstance() {
        return new TelegramNotification();
    }
}
