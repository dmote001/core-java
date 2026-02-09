package com.design_patterns.creational.factory.notification_factory_example.classes.concrete_factory;

import com.design_patterns.creational.factory.notification_factory_example.classes.concrete_products.EmailNotification;
import com.design_patterns.creational.factory.notification_factory_example.classes.concrete_products.SMSNotification;
import com.design_patterns.creational.factory.notification_factory_example.interfaces.factory.NotificationFactory;
import com.design_patterns.creational.factory.notification_factory_example.interfaces.products.Notification;
import lombok.Builder;
import lombok.Data;

@Data
public class SMSNotificationFactory implements NotificationFactory {
    @Override
    public Notification createInstance() {
        return SMSNotification.builder().build();
    }
}
