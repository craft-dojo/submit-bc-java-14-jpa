package com.cybersoft.assign_14_jpa.response;

import com.cybersoft.assign_14_jpa.entity.CustomerEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDTO {

    private int id;
    private String name;
    private String phone;

    public static CustomerResponseDTO mapToDTO(CustomerEntity entity) {
        return CustomerResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .build();
    }
}
