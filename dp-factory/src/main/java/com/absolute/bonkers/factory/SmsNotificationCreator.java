package com.absolute.bonkers.factory;

import org.springframework.stereotype.Component;

@Component
public class SmsNotificationCreator extends NotificationCreator {

  @Override
  protected Notification createNotification() {
    return new SmsNotification();
  }
}
