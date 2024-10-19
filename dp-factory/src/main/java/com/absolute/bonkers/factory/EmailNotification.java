package com.absolute.bonkers.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailNotification implements Notification {

  @Override
  public void sendMessage(String message) {
    // email notification logic goes here
    log.info("Email sent");
  }
}
