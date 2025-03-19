package com.holyinfantes.backend.infrastructure.controllers.shop.products;

import com.holyinfantes.backend.application.shop.products.UpdateProduct;
import com.holyinfantes.backend.domain.shop.Products;
import com.holyinfantes.backend.domain.shop.UpdateProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/products/updateProduct")
public class UpdateProductController {

    private final UpdateProduct updateProduct;

    @Autowired
    public UpdateProductController(UpdateProduct updateProduct) {
        this.updateProduct = updateProduct;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(
            @PathVariable Long id,
            @RequestParam(value = "productName", required = false) String productName,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "price", required = false) Double price,
            @RequestParam(value = "stock", required = false) Integer stock,
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "size", required = false) String size,
            @RequestParam(value = "material", required = false) String material,
            @RequestParam(value = "image", required = false) MultipartFile image
    ) {
        try {
            UpdateProductDto updateProductDto = new UpdateProductDto(productName, description, type, price, stock, color, size, material, image);

            Products updatedProduct = updateProduct.updateProduct(id, updateProductDto);
            return ResponseEntity.ok(updatedProduct);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

}
