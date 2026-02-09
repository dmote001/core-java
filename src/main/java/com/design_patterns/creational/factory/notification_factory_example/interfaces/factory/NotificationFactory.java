package com.design_patterns.creational.factory.notification_factory_example.interfaces.factory;

import com.design_patterns.creational.factory.notification_factory_example.interfaces.products.Notification;

public interface NotificationFactory {

    Notification createInstance();
}
