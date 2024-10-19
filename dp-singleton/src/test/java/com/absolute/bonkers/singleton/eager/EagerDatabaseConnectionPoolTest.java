package com.absolute.bonkers.singleton.eager;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.absolute.bonkers.singleton.ConnectionPool;
import com.absolute.bonkers.singleton.PoolType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EagerDatabaseConnectionPoolTest {

  @Autowired EagerDatabaseConnectionPool eagerDatabaseConnectionPool;

  @Test
  void shouldInitialiseEagerDatabaseConnectionPool() {
    ConnectionPool connectionPool1 = eagerDatabaseConnectionPool.getConnectionPool();
    ConnectionPool connectionPool2 = eagerDatabaseConnectionPool.getConnectionPool();

    // Since the Connection Pool was created at the time of application run it will contain default
    // information
    assertThat(connectionPool1.getPoolType()).isEqualTo(PoolType.DATABASE);
    assertThat(connectionPool2.getPoolType()).isEqualTo(PoolType.DATABASE);

    // assert hashCodes
    assertThat(connectionPool1.hashCode()).isEqualTo(connectionPool2.hashCode());
  }
}
