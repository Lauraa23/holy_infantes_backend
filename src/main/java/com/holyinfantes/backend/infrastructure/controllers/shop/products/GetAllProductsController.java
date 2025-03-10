package com.holyinfantes.backend.infrastructure.controllers.shop.products;

import com.holyinfantes.backend.application.shop.products.GetAllProducts;
import com.holyinfantes.backend.domain.shop.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products/getAllProducts")
public class GetAllProductsController {

    private final GetAllProducts getAllProducts;

    @Autowired
    public GetAllProductsController(GetAllProducts getAllProducts) {
        this.getAllProducts = getAllProducts;
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = getAllProducts.getAll();
        return ResponseEntity.ok(products);
    }
}
