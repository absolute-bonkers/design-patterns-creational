package com.absolute.bonkers.factory;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationCreator extends NotificationCreator {

  @Override
  protected Notification createNotification() {
    return new EmailNotification();
  }
}
