package com.holyinfantes.backend.domain.payments;

import com.holyinfantes.backend.domain.shop.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private List<ProductRequestDto> products;
}
