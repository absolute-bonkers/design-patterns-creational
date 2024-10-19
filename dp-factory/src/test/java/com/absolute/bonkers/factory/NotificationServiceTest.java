package com.absolute.bonkers.factory;

import static com.absolute.bonkers.factory.NotificationType.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NotificationServiceTest {

  @Autowired NotificationService notificationService;

  private LogCaptor logCaptor;

  @AfterEach
  void tearDown() {
    logCaptor.clearLogs();
    logCaptor.close();
  }

  @Test
  void shouldUsePushNotification() {
    logCaptor = LogCaptor.forClass(PushNotification.class);

    /**
     * delegating notificationService to use Push mechanism with type {@link NotificationType#PUSH}
     */
    notificationService.sendNotification(PUSH, "some push");

    // asserting log message to verify right implementation call
    assertThat(logCaptor.getInfoLogs().size()).isEqualTo(1);
    assertThat(logCaptor.getInfoLogs()).contains("Push notification sent");
  }

  @Test
  void shouldUseSMSNotification() {
    logCaptor = LogCaptor.forClass(SmsNotification.class);
    /**
     * delegating notificationService to use SMS mechanism with type {@link NotificationType#SMS}
     */
    notificationService.sendNotification(SMS, "some sms");

    // asserting log message to verify right implementation call
    assertThat(logCaptor.getInfoLogs().size()).isEqualTo(1);
    assertThat(logCaptor.getInfoLogs()).contains("SMS sent");
  }

  @Test
  void shouldUseEmailNotification() {
    logCaptor = LogCaptor.forClass(EmailNotification.class);
    /**
     * delegating notificationService to use Email mechanism with type {@link NotificationType#EMAIL}
     */
    notificationService.sendNotification(EMAIL, "some email");

    // asserting log message to verify right implementation call
    assertThat(logCaptor.getInfoLogs().size()).isEqualTo(1);
    assertThat(logCaptor.getInfoLogs()).contains("Email sent");
  }
}
