package com.cybersoft.assign_14_jpa.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequestDTO {

    private String name;
    private BigDecimal price;
    private String description;
    private int categoryId;
}
