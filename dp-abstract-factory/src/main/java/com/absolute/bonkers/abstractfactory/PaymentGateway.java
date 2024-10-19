package com.absolute.bonkers.abstractfactory;

import com.absolute.bonkers.abstractfactory.factories.PaypalFactory;
import com.absolute.bonkers.abstractfactory.factories.StripeFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentGateway {
  PAYPAL(PaypalFactory.class.getSimpleName()),
  STRIPE(StripeFactory.class.getSimpleName());

  String value;
}
