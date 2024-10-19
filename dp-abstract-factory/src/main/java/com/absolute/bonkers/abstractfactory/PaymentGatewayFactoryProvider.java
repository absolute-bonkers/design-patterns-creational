package com.absolute.bonkers.abstractfactory;

import com.absolute.bonkers.abstractfactory.factories.PaymentGatewayFactory;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayFactoryProvider {
  private final Map<String, PaymentGatewayFactory> factories;

  @Autowired
  public PaymentGatewayFactoryProvider(List<PaymentGatewayFactory> factoryList) {
    factories =
        factoryList.stream()
            .collect(
                Collectors.toMap(
                    factory -> factory.getClass().getSimpleName(), factory -> factory));
  }

  public PaymentGatewayFactory getFactory(PaymentGateway gateway) {
    return factories.get(gateway.getValue());
  }
}
