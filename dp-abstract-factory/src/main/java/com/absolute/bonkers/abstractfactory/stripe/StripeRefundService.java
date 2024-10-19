package com.absolute.bonkers.abstractfactory.stripe;

import com.absolute.bonkers.abstractfactory.RefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StripeRefundService implements RefundService {
  @Override
  public void processRefund(String transactionId) {
    // some fancy refund processing logic
    log.info("Refund via Stripe for transactionId %s is successful".formatted(transactionId));
  }
}
