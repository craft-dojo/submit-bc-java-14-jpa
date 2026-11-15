package com.cybersoft.assign_14_jpa.response;

import com.cybersoft.assign_14_jpa.entity.StudentEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {
    private int id;
    private String name;
    private String email;
    private List<CourseResponseDTO> courses;

    public static StudentResponseDTO mapToDTO(StudentEntity entity) {
        return StudentResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .courses(entity.getCourses().stream()
                        .map(CourseResponseDTO::mapToDTO)
                        .toList())
                .build();
    }
}
