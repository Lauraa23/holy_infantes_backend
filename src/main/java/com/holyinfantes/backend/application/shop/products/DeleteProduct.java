package com.holyinfantes.backend.application.shop.products;

import com.holyinfantes.backend.infrastructure.repository.shop.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProduct {

    @Autowired
    private ProductsRepository productsRepository;

    public void deleteProductById(Long id) {
        if (productsRepository.existsById(id)) {
            productsRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se ha podido encontrar ese producto");
        }
    }
}
