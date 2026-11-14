package com.cybersoft.assign_14_jpa.response;


import com.cybersoft.assign_14_jpa.entity.ProductEntity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    private int id;
    private String name;
    private BigDecimal price;
    private String description;

    public static ProductResponseDTO mapToDTO(ProductEntity entity) {
        return ProductResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .build();
    }
}
