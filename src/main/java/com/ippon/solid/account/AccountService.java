package com.ippon.solid.account;

import com.ippon.solid.notification.NotificationFactory;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private NotificationFactory notificationFactory;

    public AccountService(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    public void notifyAccount(Account account) {
        notificationFactory
                .getNotificationService(account.getNotificationPreference())
                .orElseGet(notificationFactory::getDefaultNotificationService)
                .notify(account.getName(), "You've been notified!");
    }
}
