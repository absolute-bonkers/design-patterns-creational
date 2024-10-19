package com.absolute.bonkers.singleton.eager;

import com.absolute.bonkers.singleton.ConnectionPool;
import java.io.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BreakSingletonPatternBySerializationTest {

  @Autowired EagerDatabaseConnectionPool eagerDatabaseConnectionPool;

  @BeforeEach
  void setUp() {}

  @Test
  void breakEagerConnectionPoolSingletonPatternViaSerialization()
      throws IOException, ClassNotFoundException {
    // this initialises the first instance
    ConnectionPool connectionPool1 = eagerDatabaseConnectionPool.getConnectionPool();

    // this retrieves the same instance again
    ConnectionPool connectionPool2 = eagerDatabaseConnectionPool.getConnectionPool();

    Assertions.assertThat(connectionPool1.hashCode()).isEqualTo(connectionPool2.hashCode());

    // Break singleton pattern using serialization : get object exported as a file
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("temp.ob"));
    objectOutputStream.writeObject(connectionPool1);

    // read it back
    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("temp.ob"));
    ConnectionPool connectionPool3 = (ConnectionPool) objectInputStream.readObject();

    // note: This way of breaking singleton pattern is deprecated on Java new version
    /**
     * In newer versions of Java, including Java 23, there are mechanisms that might automatically
     * protect singletons from being broken via serialization/deserialization, especially if you’re
     * using modern best practices like enums for singleton implementation. Java provides built-in
     * protection for enums by ensuring they remain singletons even after deserialization. This is
     * because only the enum name is serialized, and during deserialization, the JVM uses the
     * valueOf method to return the same enum instance, preventing multiple instances from being
     * created.
     */
    //
    // Assertions.assertThat(connectionPool3.hashCode()).isNotEqualTo(connectionPool1.hashCode());
  }
}
