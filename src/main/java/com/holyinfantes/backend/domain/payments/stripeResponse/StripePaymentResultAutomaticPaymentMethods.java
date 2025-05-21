package com.holyinfantes.backend.domain.payments.stripeResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StripePaymentResultAutomaticPaymentMethods {
    private Boolean enabled;
}
