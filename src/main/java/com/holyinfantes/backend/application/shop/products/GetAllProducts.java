package com.holyinfantes.backend.application.shop.products;

import com.holyinfantes.backend.domain.shop.Products;
import com.holyinfantes.backend.infrastructure.repository.shop.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProducts {

    private final ProductsRepository productsRepository;

    public GetAllProducts(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Products> getAll() {
        return productsRepository.findAll();
    }
}
