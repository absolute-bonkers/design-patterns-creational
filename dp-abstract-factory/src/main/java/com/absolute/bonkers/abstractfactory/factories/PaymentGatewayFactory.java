package com.absolute.bonkers.abstractfactory.factories;

import com.absolute.bonkers.abstractfactory.PaymentService;
import com.absolute.bonkers.abstractfactory.RefundService;

public interface PaymentGatewayFactory {

  PaymentService createPaymentService();

  RefundService createRefundService();
}
