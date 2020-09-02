package com.ippon.solid.account;

import com.ippon.solid.notification.EmailNotificationService;
import com.ippon.solid.notification.SmsNotificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private BadAccountService badAccountService;

    @MockBean
    private EmailNotificationService emailNotificationService;

    @MockBean
    private SmsNotificationService smsNotificationService;

    @Test
    void badAccountNotificationTest() {
        Account emailPreference = new Account("Ben", "email");
        Account smsPreference = new Account("Cecilia", "sms");
        Account unknownPreference = new Account("John", "unknown");

        badAccountService.notifyAccount(emailPreference);
        badAccountService.notifyAccount(smsPreference);
        badAccountService.notifyAccount(unknownPreference);


        verify(emailNotificationService, times(1))
                .notify("Ben", "You've been notified!");

        verify(smsNotificationService, times(1))
                .notify("Cecilia", "You've been notified!");

        verify(emailNotificationService, times(1))
                .notify("John", "You've been notified!");
    }

    @Test
    void notificationTest() {
        Account emailPreference = new Account("Ben", "email");
        Account smsPreference = new Account("Cecilia", "sms");
        Account unknownPreference = new Account("John", "unknown");

        accountService.notifyAccount(emailPreference);
        accountService.notifyAccount(smsPreference);
        accountService.notifyAccount(unknownPreference);


        verify(emailNotificationService, times(1))
                .notify("Ben", "You've been notified!");

        verify(smsNotificationService, times(1))
                .notify("Cecilia", "You've been notified!");

        verify(emailNotificationService, times(1))
                .notify("John", "You've been notified!");
    }


}
