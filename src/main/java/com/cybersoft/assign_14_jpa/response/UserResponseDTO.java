package com.cybersoft.assign_14_jpa.response;

import com.cybersoft.assign_14_jpa.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private int id;
    private String username;
    private String email;

    public static UserResponseDTO mapToDTO(UserEntity entity) {
        return UserResponseDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .build();
    }
}
