package com.absolute.bonkers.factory;

import org.springframework.stereotype.Component;

@Component
public class PushNotificationCreator extends NotificationCreator {

  @Override
  protected Notification createNotification() {
    return new PushNotification();
  }
}
