package com.holyinfantes.backend.infrastructure.payments;

import com.holyinfantes.backend.domain.payments.PaymentRequest;
import com.holyinfantes.backend.domain.payments.ProductRequestDto;
import com.holyinfantes.backend.domain.shop.Products;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;

public class ProcessPayment {

    private static final Dotenv env = Dotenv.load();
    private static final String secretKey = env.get("STRIPE_SECRET_KEY");

    public static String process(PaymentRequest paymentRequest)  throws StripeException {

        Stripe.apiKey = secretKey;

        List<ProductRequestDto> products = paymentRequest.getProducts();
        System.out.println("request" + paymentRequest);
        long totalAmount = 0;
        for (ProductRequestDto product : products) {
            System.out.println("Product: " + product.getProductName());
            System.out.println("total products" + products);
            ProductCreateParams productParams =
                ProductCreateParams.builder()
                        .setName(product.getProductName())
                        .setDescription(product.getProductDescription())
                        .build();

         Product stripeProduct = Product.create(productParams);
         System.out.println("hell yeah" + stripeProduct.getId());

         Long priceInCents = Math.round(product.getProductPrice() * 100);

         PriceCreateParams priceParams = PriceCreateParams.builder()
                 .setUnitAmount(priceInCents)
                 .setCurrency("eur")
                 .setProduct(stripeProduct.getId())
                 .build();
            Price price = Price.create(priceParams);

            totalAmount += priceInCents;
        }

        PaymentIntentCreateParams paymentParams = PaymentIntentCreateParams.builder()
                .setAmount(totalAmount)
                .setCurrency("eur")
                .build();

        PaymentIntent paymentIntent = PaymentIntent.create(paymentParams);

        return paymentIntent.getStatus();
    }

}
