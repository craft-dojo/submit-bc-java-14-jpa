package com.cybersoft.assign_14_jpa.services;

import com.cybersoft.assign_14_jpa.response.OrderResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    List<OrderResponseDTO> getOrdersByFromCreatedAt(LocalDateTime fromCreatedAt);

    List<OrderResponseDTO> getOrdersWithTotalAmountSortAsc(String sorted, int limit);
}
