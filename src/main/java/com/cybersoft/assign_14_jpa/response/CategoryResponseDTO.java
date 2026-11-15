package com.cybersoft.assign_14_jpa.response;

import com.cybersoft.assign_14_jpa.entity.CategoryEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDTO {

    private int id;
    private String name;

    public static CategoryResponseDTO mapToDTO(CategoryEntity categoryEntity) {
        return CategoryResponseDTO.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .build();
    }
}
