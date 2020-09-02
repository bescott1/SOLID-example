package com.ippon.solid.notification;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class NotificationFactory {

    private Map<String, NotificationService> notificationServices;

    private EmailNotificationService defaultNotificationService;

    public NotificationFactory(Map<String, NotificationService> notificationServices,
                               EmailNotificationService defaultNotificationService) {
        this.notificationServices = notificationServices;
        this.defaultNotificationService = defaultNotificationService;
    }

    public Optional<NotificationService> getNotificationService(String type) {
         return Optional.ofNullable(notificationServices.get(type));
    }

    public NotificationService getDefaultNotificationService() {
        return defaultNotificationService;
    }
}
