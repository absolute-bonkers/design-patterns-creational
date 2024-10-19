package com.absolute.bonkers.abstractfactory;

import static com.absolute.bonkers.abstractfactory.PaymentGateway.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.absolute.bonkers.abstractfactory.paypal.PaypalPaymentService;
import com.absolute.bonkers.abstractfactory.paypal.PaypalRefundService;
import com.absolute.bonkers.abstractfactory.stripe.StripePaymentService;
import com.absolute.bonkers.abstractfactory.stripe.StripeRefundService;
import java.util.UUID;
import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentProcessServiceTest {

  @Autowired private PaymentProcessService paymentProcessService;

  private LogCaptor logCaptor;

  @AfterEach
  void tearDown() {
    logCaptor.clearLogs();
    logCaptor.close();
  }

  @Test
  void processPaypalPayment() {
    logCaptor = LogCaptor.forClass(PaypalPaymentService.class);

    // given payment processing via PAYPAL
    paymentProcessService.processPayment(PAYPAL, 100.0);

    assertThat(logCaptor.getInfoLogs().size()).isEqualTo(1);

    // verify the Paypal payment is called
    assertThat(logCaptor.getInfoLogs())
        .contains("Payment via PayPal of amount %f is successful".formatted(100.0));
  }

  @Test
  void processPaypalRefund() {
    String transactionId = UUID.randomUUID().toString();

    logCaptor = LogCaptor.forClass(PaypalRefundService.class);
    // given payment refund via PAYPAL
    paymentProcessService.processRefund(PAYPAL, transactionId);

    assertThat(logCaptor.getInfoLogs().size()).isEqualTo(1);
    // verify the Paypal refund is called
    assertThat(logCaptor.getInfoLogs())
        .contains("Refund via PayPal for transactionId %s is successful".formatted(transactionId));
  }

  @Test
  void processStripePayment() {
    logCaptor = LogCaptor.forClass(StripePaymentService.class);

    // given payment processing via STRIPE
    paymentProcessService.processPayment(STRIPE, 120.0);

    assertThat(logCaptor.getInfoLogs().size()).isEqualTo(1);

    // verify the Stripe payment is called
    assertThat(logCaptor.getInfoLogs())
        .contains("Payment via Stripe of amount %f is successful".formatted(120.0));
  }

  @Test
  void processStripeRefund() {
    String transactionId = UUID.randomUUID().toString();

    logCaptor = LogCaptor.forClass(StripeRefundService.class);
    // given payment refund via STRIPE
    paymentProcessService.processRefund(STRIPE, transactionId);

    assertThat(logCaptor.getInfoLogs().size()).isEqualTo(1);

    // verify the Stripe refund is called
    assertThat(logCaptor.getInfoLogs())
        .contains("Refund via Stripe for transactionId %s is successful".formatted(transactionId));
  }
}
