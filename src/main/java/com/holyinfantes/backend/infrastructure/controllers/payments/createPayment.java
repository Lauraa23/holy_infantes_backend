package com.holyinfantes.backend.infrastructure.controllers.payments;

import com.holyinfantes.backend.domain.payments.PaymentRequest;
import com.holyinfantes.backend.infrastructure.payments.ProcessPayment;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class createPayment {

    private ProcessPayment processPayment;

    @PostMapping("/create")
    public String create(@RequestBody PaymentRequest paymentRequest) {
       try {
           return ProcessPayment.process(paymentRequest);
       } catch (StripeException e) {
           throw new RuntimeException("stripe error" + e);
       }
    }

}
