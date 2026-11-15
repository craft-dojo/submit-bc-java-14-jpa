package com.cybersoft.assign_14_jpa.response;

import com.cybersoft.assign_14_jpa.entity.CourseEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDTO {
    private int id;
    private String title;

    public static CourseResponseDTO mapToDTO(CourseEntity entity) {
        return CourseResponseDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }
}
