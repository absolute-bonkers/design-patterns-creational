package com.absolute.bonkers.singleton;

import java.io.Serializable;
import java.sql.Connection;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ConnectionPool implements Serializable {

  String poolId;
  PoolType poolType;
  Connection connection;

  public static ConnectionPool createPool(PoolType poolType) {
    return ConnectionPool.builder().poolId(UUID.randomUUID().toString()).poolType(poolType).build();
  }
}
