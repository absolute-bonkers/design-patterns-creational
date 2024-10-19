package com.absolute.bonkers.singleton.eager;

import com.absolute.bonkers.singleton.ConnectionPool;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BreakSingletonPatternByReflectionTest {

  @Autowired EagerDatabaseConnectionPool eagerDatabaseConnectionPool;

  @Test
  void breakEagerConnectionPoolSingletonPatternViaReflection()
      throws InvocationTargetException, InstantiationException, IllegalAccessException {
    // this initialises the first instance
    ConnectionPool connectionPool1 = eagerDatabaseConnectionPool.getConnectionPool();

    // this retrieves the same instance again
    ConnectionPool connectionPool2 = eagerDatabaseConnectionPool.getConnectionPool();

    Assertions.assertThat(connectionPool1.hashCode()).isEqualTo(connectionPool2.hashCode());

    // Break singleton pattern using reflection
    Constructor[] declaredConstructors =
        EagerDatabaseConnectionPool.class.getDeclaredConstructors();

    // Allowing dynamic access to constructors
    declaredConstructors[0].setAccessible(true);

    // Creating new instance with reflection
    EagerDatabaseConnectionPool eagerDatabaseConnectionPool =
        (EagerDatabaseConnectionPool) declaredConstructors[0].newInstance();
    ConnectionPool connectionPool3 = eagerDatabaseConnectionPool.getConnectionPool();

    // Assert the new instance is different
    Assertions.assertThat(connectionPool3.hashCode()).isNotEqualTo(connectionPool1.hashCode());
  }
}
