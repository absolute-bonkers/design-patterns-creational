package com.absolute.bonkers.abstractfactory.paypal;

import com.absolute.bonkers.abstractfactory.RefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaypalRefundService implements RefundService {
  @Override
  public void processRefund(String transactionId) {
    // some fancy refund processing logic
    log.info("Refund via PayPal for transactionId %s is successful".formatted(transactionId));
  }
}
