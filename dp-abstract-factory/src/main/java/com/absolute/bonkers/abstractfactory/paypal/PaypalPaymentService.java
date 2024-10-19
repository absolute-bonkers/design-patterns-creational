package com.absolute.bonkers.abstractfactory.paypal;

import com.absolute.bonkers.abstractfactory.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaypalPaymentService implements PaymentService {
  @Override
  public void processPayment(Double amount) {
    // some fancy payment processing logic
    log.info("Payment via PayPal of amount %f is successful".formatted(amount));
  }
}
