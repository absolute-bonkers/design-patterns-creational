package com.absolute.bonkers.singleton.eager;

import static org.junit.jupiter.api.Assertions.*;

import com.absolute.bonkers.singleton.ConnectionPool;
import com.absolute.bonkers.singleton.PoolType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EagerDatabaseConnectionPoolTest {

  @Autowired EagerDatabaseConnectionPool eagerDatabaseConnectionPool;

  @Test
  void shouldInitialiseEagerDatabaseConnectionPool() {
    ConnectionPool connectionPool = eagerDatabaseConnectionPool.getConnectionPool();

    // Since the Connection Pool was created at the time of application run it will contain default
    // information
    Assertions.assertThat(connectionPool.getPoolType()).isEqualTo(PoolType.DATABASE);
  }
}
