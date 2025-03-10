package com.holyinfantes.backend.application.shop.products;

import com.holyinfantes.backend.domain.shop.Products;
import com.holyinfantes.backend.infrastructure.repository.shop.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductById {

    private final ProductsRepository productsRepository;

    public GetProductById(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Optional<Products> getById(Long id) {
        return productsRepository.findById(id);
    }
}
