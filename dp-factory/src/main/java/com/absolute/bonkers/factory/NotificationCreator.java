package com.absolute.bonkers.factory;

public abstract class NotificationCreator {

  public void sendNotification(String message) {
    createNotification().sendMessage(message);
  }

  protected abstract Notification createNotification();
}
