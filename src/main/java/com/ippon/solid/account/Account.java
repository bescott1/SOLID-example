package com.ippon.solid.account;

public class Account {

    private String name;
    private String notificationPreference;

    public String getName() {
        return name;
    }

    public Account(String name, String notificationPreference) {
        this.name = name;
        this.notificationPreference = notificationPreference;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotificationPreference() {
        return notificationPreference;
    }

    public void setNotificationPreference(String notificationPreference) {
        this.notificationPreference = notificationPreference;
    }
}
