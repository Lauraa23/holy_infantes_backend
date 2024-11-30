package com.holyinfantes.backend.infrastructure.payments.stripe;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class StripeResponseDto {

    private String id;
    private String object;
    private Long amount;

    @JsonProperty("amount_capturable")
    private Long amountCapturable;

    @JsonProperty("amount_received")
    private Long amountReceived;

    private String currency;

    @JsonProperty("client_secret")
    private String clientSecret;

    @JsonProperty("confirmation_method")
    private String confirmationMethod;

    private String status;

    @JsonProperty("payment_method_types")
    private List<String> paymentMethodTypes;

    private Map<String, Object> metadata;

    @JsonProperty("amount_details")
    private AmountDetails amountDetails;

    @JsonProperty("payment_method_options")
    private PaymentMethodOptions paymentMethodOptions;

    @Data
    public static class AmountDetails {
        private Map<String, Object> tip;
    }

    @Data
    public static class PaymentMethodOptions {
        private CardOptions card;
        private LinkOptions link;

        @Data
        public static class CardOptions {
            @JsonProperty("installments")
            private Object installments;

            @JsonProperty("request_three_d_secure")
            private String requestThreeDSecure;
        }

        @Data
        public static class LinkOptions {
            @JsonProperty("persistent_token")
            private Object persistentToken;
        }
    }
}
