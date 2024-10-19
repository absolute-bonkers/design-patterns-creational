package com.absolute.bonkers.singleton.lazy;

import com.absolute.bonkers.singleton.ConnectionPool;
import com.absolute.bonkers.singleton.PoolType;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * This service will be initiated at the time we request to get ConnectionPool for the first time.
 * Once we request for ConnectionPool, it will provide the same instance of ConnectionPool every
 * time after initialization.
 */
@Slf4j
@Service
public class LazyDatabaseConnectionPool {
  private static volatile ConnectionPool connectionPool;

  private LazyDatabaseConnectionPool() {}

  // Static method to provide the connection pool lazily
  public static ConnectionPool getConnectionPool(PoolType poolType) {
    // First check (without synchronization) to improve performance
    if (Objects.isNull(connectionPool)) {
      synchronized (LazyDatabaseConnectionPool.class) {
        // Double-check locking - ensures only one instance is created
        if (Objects.isNull(connectionPool)) {
          connectionPool = ConnectionPool.createPool(poolType);
          log.info(
              "Lazy Database connection pool initialization is successful with poolId: {}, and poolType: {}",
              connectionPool.getPoolId(),
              connectionPool.getPoolType());
        }
      }
    }
    return connectionPool;
  }
}
