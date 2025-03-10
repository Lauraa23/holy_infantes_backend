package com.holyinfantes.backend.application.shop.products;

import com.holyinfantes.backend.application.cloudinary.CloudinaryService;
import com.holyinfantes.backend.domain.shop.Products;
import com.holyinfantes.backend.infrastructure.repository.shop.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CreateProduct {

    private ProductsRepository productsRepository;
    private CloudinaryService cloudinaryService;

    @Autowired
    public CreateProduct(ProductsRepository productsRepository, CloudinaryService cloudinaryService) {
        this.productsRepository = productsRepository;
        this.cloudinaryService = cloudinaryService;
    }

    public Products createProduct(
            String productName, String description, String type, Double price, int stock,
            String color, String size, String material, MultipartFile image) throws IOException {

        String imageUrl = cloudinaryService.uploadImage(image);

        Products product = new Products();
        product.setProductName(productName);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        product.setColor(color);
        product.setSize(size);
        product.setMaterial(material);
        product.setImageUrl(imageUrl);

        return productsRepository.save(product);
    }

}
