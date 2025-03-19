package com.holyinfantes.backend.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductDto {
    private String productName;
    private String description;
    private String type;
    private Double price;
    private Integer stock;
    private String color;
    private String size;
    private String material;
    private MultipartFile image;
}
