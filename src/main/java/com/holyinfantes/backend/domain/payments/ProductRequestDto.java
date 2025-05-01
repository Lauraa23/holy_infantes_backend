package com.holyinfantes.backend.domain.payments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private String productName;
    private String productDescription;
    private Double productPrice;
    private String paymentMethod;
}
