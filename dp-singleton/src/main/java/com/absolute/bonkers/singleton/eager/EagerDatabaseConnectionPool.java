package com.absolute.bonkers.singleton.eager;

import com.absolute.bonkers.singleton.ConnectionPool;
import com.absolute.bonkers.singleton.PoolType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
