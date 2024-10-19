package com.absolute.bonkers.singleton.eager;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BreakSingletonPatternByCloningTest {

  @Autowired EagerDatabaseConnectionPool eagerDatabaseConnectionPool;

  @Test
  void breakEagerConnectionPoolSingletonPatternViaReflection() throws CloneNotSupportedException {
    // Break singleton pattern using cloning
    EagerDatabaseConnectionPool clonedDbConnectionPool =
        (EagerDatabaseConnectionPool) eagerDatabaseConnectionPool.clone();

    assertThat(clonedDbConnectionPool.hashCode())
        .isNotEqualTo(eagerDatabaseConnectionPool.hashCode());
  }
}
