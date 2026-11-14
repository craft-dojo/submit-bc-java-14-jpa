package com.cybersoft.assign_14_jpa.response;

import com.cybersoft.assign_14_jpa.entity.BookEntity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDTO {
    private int id;
    private String title;
    private String author;
    private BigDecimal price;

    public static BookResponseDTO mapToDTO(BookEntity entity) {
        return BookResponseDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .price(entity.getPrice())
                .build();
    }
}
