package com.holyinfantes.backend.infrastructure.controllers.shop.products;

import com.holyinfantes.backend.application.shop.products.CreateProduct;
import com.holyinfantes.backend.domain.shop.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/products/createProduct")
public class CreateProductController {

    private CreateProduct createProduct;

    @Autowired
    public CreateProductController(CreateProduct createProduct) {
        this.createProduct = createProduct;
    }

    @PostMapping
    public ResponseEntity<Products> createProduct(
            @RequestParam("productName") String productName,
            @RequestParam("description") String description,
            @RequestParam("type") String type,
            @RequestParam("price") Double price,
            @RequestParam("stock") int stock,
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "size", required = false) String size,
            @RequestParam(value = "material", required = false) String material,
            @RequestParam("image") MultipartFile image) {

        try {
            Products product = createProduct.createProduct(
                    productName, description, type, price, stock, color, size, material, image);
            return ResponseEntity.ok(product);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
