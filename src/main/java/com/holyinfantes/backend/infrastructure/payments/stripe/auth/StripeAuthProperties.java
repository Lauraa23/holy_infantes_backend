package com.holyinfantes.backend.infrastructure.payments.stripe.auth;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
public class StripeAuthProperties {

    @Value("${stripe.api_key}")
    private String api_key;

    @Value("${stripe.api_secret}")
    private String api_secret;
}
