package com.absolute.bonkers.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PushNotification implements Notification {

  @Override
  public void sendMessage(String message) {
    // push notification logic goes here
    log.info("Push notification sent");
  }
}
