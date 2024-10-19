package com.absolute.bonkers.factory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {
  private final Map<String, Notification> notificationServices;

  /**
   * This loads all available implementation with constructor and builds the final Map with all
   * implementation.
   *
   * <p>Map Key is implementation class name (type) and bean as value
   *
   * @param notifications spring load all implementations
   */
  @Autowired
  public NotificationFactory(List<Notification> notifications) {
    notificationServices =
        notifications.stream()
            .collect(
                Collectors.toMap(
                    service -> service.getClass().getSimpleName(), service -> service));
  }

  /**
   * this method provides right implementation of notification based on type provided
   *
   * <p>also check {@link NotificationType}
   *
   * @param type Notification type defines which implementation to provide
   * @return the right implementation
   */
  public Notification getNotificationService(NotificationType type) {
    return notificationServices.get(type.getValue());
  }
}
