package com.holyinfantes.backend.infrastructure.controllers.shop.products;

import com.holyinfantes.backend.application.shop.products.DeleteProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/deleteProduct")
public class DeleteProductController {

    @Autowired
    private DeleteProduct deleteProduct;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        deleteProduct.deleteProductById(id);
        return ResponseEntity.ok("Producto elimnado correctamente");
    }
}
