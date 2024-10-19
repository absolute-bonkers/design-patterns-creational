package com.absolute.bonkers.singleton.lazy;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.absolute.bonkers.singleton.ConnectionPool;
import com.absolute.bonkers.singleton.PoolType;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LazyDatabaseConnectionPoolTest {

  @Test
  void shouldInitialiseLazeConnectionPoolOnDemand() {
    ConnectionPool connectionPool1 =
        LazyDatabaseConnectionPool.getConnectionPool(PoolType.EXTERNAL_API);

    ConnectionPool connectionPool2 =
        LazyDatabaseConnectionPool.getConnectionPool(PoolType.DATABASE);

    assertThat(connectionPool1.getPoolType()).isEqualTo(PoolType.EXTERNAL_API);
    assertThat(connectionPool2.getPoolType()).isNotEqualTo(PoolType.DATABASE);
    assertThat(connectionPool1.hashCode()).isEqualTo(connectionPool2.hashCode());
  }

  @Test
  public void testLazyConnectionPoolThreadSafety() throws InterruptedException, ExecutionException {
    int threadCount = 10;
    ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
    Set<Future<ConnectionPool>> futures = new HashSet<>();

    // Submit multiple tasks to simulate concurrent access
    Callable<ConnectionPool> task =
        () -> LazyDatabaseConnectionPool.getConnectionPool(PoolType.DATABASE);

    for (int i = 0; i < threadCount; i++) {
      futures.add(executorService.submit(task));
    }

    // Wait for all threads to complete and collect the results
    ConnectionPool firstInstance = null;
    for (Future<ConnectionPool> future : futures) {
      ConnectionPool pool = future.get();
      if (firstInstance == null) {
        firstInstance = pool;
      }
      // Assert that all threads return the same instance
      assertSame(
          firstInstance, pool, "All threads should return the same ConnectionPool instance.");
    }

    executorService.shutdown();
  }
}
