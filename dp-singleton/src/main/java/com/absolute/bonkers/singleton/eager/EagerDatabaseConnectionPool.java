package com.absolute.bonkers.singleton.eager;

import com.absolute.bonkers.singleton.ConnectionPool;
import com.absolute.bonkers.singleton.PoolType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * This service will be initiated at the time of application startup, as it declares and defines
 * ConnectionPool at the same time Each time we try to get ConnectionPool it will give the same
 * instance
 */
@Getter
@Slf4j
@Service
public class EagerDatabaseConnectionPool {
  /** Initialising the Bean at the time of application startup only */
  private final ConnectionPool connectionPool = ConnectionPool.createPool(PoolType.DATABASE);

  private EagerDatabaseConnectionPool() {
    log.info(
        "Eager Database connection pool initialization is successful with poolId: %s, and poolType: %s"
            .formatted(this.connectionPool.getPoolId(), this.connectionPool.getPoolType()));
  }
}
