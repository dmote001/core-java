package com.design_patterns.creational.factory.notification_factory_example.classes.concrete_factory;

import com.design_patterns.creational.factory.notification_factory_example.classes.concrete_products.EmailNotification;
import com.design_patterns.creational.factory.notification_factory_example.interfaces.factory.NotificationFactory;
import com.design_patterns.creational.factory.notification_factory_example.interfaces.products.Notification;

public class EmailNotificationFactory implements NotificationFactory {
    @Override
    public Notification createInstance() {
        return new EmailNotification();
    }
}
