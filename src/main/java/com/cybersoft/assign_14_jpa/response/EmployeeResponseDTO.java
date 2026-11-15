package com.cybersoft.assign_14_jpa.response;

import com.cybersoft.assign_14_jpa.entity.EmployeeEntity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {

    private int id;
    private String name;
    private BigDecimal salary;
    private String department;

    public static EmployeeResponseDTO mapToDTO(EmployeeEntity entity) {
        return EmployeeResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .salary(entity.getSalary())
                .department(entity.getDepartment())
                .build();
    }
}
