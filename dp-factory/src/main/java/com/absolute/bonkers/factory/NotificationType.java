package com.absolute.bonkers.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NotificationType {
  SMS(SmsNotification.class.getSimpleName()),
  PUSH(PushNotification.class.getSimpleName()),
  EMAIL(EmailNotification.class.getSimpleName());

  String value;
}
