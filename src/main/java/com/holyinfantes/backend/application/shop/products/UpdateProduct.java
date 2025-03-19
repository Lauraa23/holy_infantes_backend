package com.holyinfantes.backend.application.shop.products;

import com.holyinfantes.backend.application.cloudinary.CloudinaryService;
import com.holyinfantes.backend.domain.shop.Products;
import com.holyinfantes.backend.domain.shop.UpdateProductDto;
import com.holyinfantes.backend.infrastructure.repository.shop.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UpdateProduct {
    private final ProductsRepository productsRepository;
    private final CloudinaryService cloudinaryService;

    @Autowired
    public UpdateProduct(ProductsRepository productsRepository, CloudinaryService cloudinaryService) {
        this.productsRepository = productsRepository;
        this.cloudinaryService = cloudinaryService;
    }

    public Products updateProduct(Long id, UpdateProductDto updateProductDto) throws IOException {
        Products product = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if (updateProductDto.getProductName() != null) product.setProductName(updateProductDto.getProductName());
        if (updateProductDto.getDescription() != null) product.setDescription(updateProductDto.getDescription());
        if (updateProductDto.getType() != null) product.setType(updateProductDto.getType());
        if (updateProductDto.getPrice() != null) product.setPrice(updateProductDto.getPrice());
        if (updateProductDto.getStock() != null) product.setStock(updateProductDto.getStock());
        if (updateProductDto.getColor() != null) product.setColor(updateProductDto.getColor());
        if (updateProductDto.getSize() != null) product.setSize(updateProductDto.getSize());
        if (updateProductDto.getMaterial() != null) product.setMaterial(updateProductDto.getMaterial());

        if (updateProductDto.getImage() != null && !updateProductDto.getImage().isEmpty()) {
            String imageUrl = cloudinaryService.uploadImage(updateProductDto.getImage());
            product.setImageUrl(imageUrl);
        }

        return productsRepository.save(product);
    }
}
