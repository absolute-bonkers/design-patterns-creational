package com.absolute.bonkers.abstractfactory.factories;

import com.absolute.bonkers.abstractfactory.PaymentService;
import com.absolute.bonkers.abstractfactory.RefundService;
import com.absolute.bonkers.abstractfactory.stripe.StripePaymentService;
import com.absolute.bonkers.abstractfactory.stripe.StripeRefundService;
import org.springframework.stereotype.Component;

@Component
public class StripeFactory implements PaymentGatewayFactory {
  @Override
  public PaymentService createPaymentService() {
    return new StripePaymentService();
  }

  @Override
  public RefundService createRefundService() {
    return new StripeRefundService();
  }
}
