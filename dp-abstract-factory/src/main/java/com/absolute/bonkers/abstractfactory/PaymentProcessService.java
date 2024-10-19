package com.absolute.bonkers.abstractfactory;

import com.absolute.bonkers.abstractfactory.factories.PaymentGatewayFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessService {
  @Autowired private PaymentGatewayFactoryProvider paymentGatewayFactoryProvider;

  public void processPayment(PaymentGateway gateway, double amount) {
    PaymentGatewayFactory factory = paymentGatewayFactoryProvider.getFactory(gateway);
    PaymentService paymentService = factory.createPaymentService();
    paymentService.processPayment(amount);
  }

  public void processRefund(PaymentGateway gateway, String transactionId) {
    PaymentGatewayFactory factory = paymentGatewayFactoryProvider.getFactory(gateway);
    RefundService refundService = factory.createRefundService();
    refundService.processRefund(transactionId);
  }
}
