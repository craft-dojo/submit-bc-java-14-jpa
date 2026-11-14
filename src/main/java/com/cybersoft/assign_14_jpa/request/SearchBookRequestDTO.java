package com.cybersoft.assign_14_jpa.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchBookRequestDTO {
    private String author;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
}
