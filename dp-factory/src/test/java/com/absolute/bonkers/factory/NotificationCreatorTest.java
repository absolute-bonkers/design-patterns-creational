package com.absolute.bonkers.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NotificationCreatorTest {

  @Test
  void emailCreatorChoosesEmailProduct() {
    NotificationCreator creator = new EmailNotificationCreator();

    assertThat(creator.createNotification()).isInstanceOf(EmailNotification.class);
  }

  @Test
  void smsCreatorChoosesSmsProduct() {
    NotificationCreator creator = new SmsNotificationCreator();

    assertThat(creator.createNotification()).isInstanceOf(SmsNotification.class);
  }

  @Test
  void pushCreatorChoosesPushProduct() {
    NotificationCreator creator = new PushNotificationCreator();

    assertThat(creator.createNotification()).isInstanceOf(PushNotification.class);
  }
}
