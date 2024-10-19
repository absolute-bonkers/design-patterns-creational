package com.absolute.bonkers.abstractfactory.factories;

import com.absolute.bonkers.abstractfactory.PaymentService;
import com.absolute.bonkers.abstractfactory.RefundService;
import com.absolute.bonkers.abstractfactory.paypal.PaypalPaymentService;
import com.absolute.bonkers.abstractfactory.paypal.PaypalRefundService;
import org.springframework.stereotype.Component;

@Component
public class PaypalFactory implements PaymentGatewayFactory {
  @Override
  public PaymentService createPaymentService() {
    return new PaypalPaymentService();
  }

  @Override
  public RefundService createRefundService() {
    return new PaypalRefundService();
  }
}
