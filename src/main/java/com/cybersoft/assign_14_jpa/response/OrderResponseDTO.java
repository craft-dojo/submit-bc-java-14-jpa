package com.cybersoft.assign_14_jpa.response;

import com.cybersoft.assign_14_jpa.entity.OrderEntity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {

    private int id;
    private String customerName;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;

    public static OrderResponseDTO mapToDTO(OrderEntity entity) {
        return OrderResponseDTO.builder()
                .id(entity.getId())
                .customerName(entity.getCustomerName())
                .totalAmount(entity.getTotalAmount())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
