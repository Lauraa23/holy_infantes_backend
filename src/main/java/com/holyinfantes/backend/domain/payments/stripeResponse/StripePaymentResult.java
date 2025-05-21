package com.holyinfantes.backend.domain.payments.stripeResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StripePaymentResult {
    private String id;
    private String object;
    private Double amount;
    private Double amountCapturable;
    private StripePaymentsResultAmountDetails amountsDetails;
    private Double amountReceived;
    private String application;
    private String applicationFeeAccount;
    private StripePaymentResultAutomaticPaymentMethods automaticPaymentMethods;
    private String canceledAt;
    private String cancellationReason;
    private String capturedMethod;
    private String clientSecret;
    private String confirmationMethod;
    private Long created;
    private String currency;
    private String customer;
    private String description;

}
