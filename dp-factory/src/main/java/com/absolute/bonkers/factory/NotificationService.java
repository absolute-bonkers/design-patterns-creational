package com.absolute.bonkers.factory;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

  @Autowired NotificationFactory notificationFactory;

  public void sendNotification(NotificationType type, String message) {
    Notification notification = notificationFactory.getNotificationService(type);

    if (Objects.nonNull(notification)) {
      notification.sendMessage(message);
    } else {
      throw new IllegalArgumentException("Unknown notification type: " + type);
    }
  }
}
