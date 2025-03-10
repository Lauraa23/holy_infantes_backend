package com.holyinfantes.backend.infrastructure.controllers.shop.products;

import com.holyinfantes.backend.application.shop.products.GetProductById;
import com.holyinfantes.backend.domain.shop.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/products/getProductById")
public class GetProductByIdController {

    private final GetProductById getProductById;

    @Autowired
    public GetProductByIdController(GetProductById getProductById) {
        this.getProductById = getProductById;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
        Optional<Products> products = getProductById.getById(id);
        return products.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
