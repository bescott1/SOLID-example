package com.ippon.solid.account;

import com.ippon.solid.notification.EmailNotificationService;
import com.ippon.solid.notification.SmsNotificationService;
import org.springframework.stereotype.Service;

@Service
public class BadAccountService {

    public static final String MESSAGE = "You've been notified!";
    private EmailNotificationService emailNotificationService;
    private SmsNotificationService smsNotificationService;

    public BadAccountService(EmailNotificationService emailNotificationService,
                             SmsNotificationService smsNotificationService) {
        this.emailNotificationService = emailNotificationService;
        this.smsNotificationService = smsNotificationService;
    }

    public void notifyAccount(Account account) {

        switch (account.getNotificationPreference()) {
            case "sms":
                smsNotificationService.notify(account.getName(), MESSAGE);
                break;
            case "email":
            default:
                emailNotificationService.notify(account.getName(), MESSAGE);
        }
    }
}
