package com.cybersoft.assign_14_jpa.services.imp;

import com.cybersoft.assign_14_jpa.repository.OrderRepository;
import com.cybersoft.assign_14_jpa.response.OrderResponseDTO;
import com.cybersoft.assign_14_jpa.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderResponseDTO> getOrdersByFromCreatedAt(LocalDateTime fromCreatedAt) {
        return orderRepository.findOrdersFromCreatedAt(fromCreatedAt)
                .stream()
                .map(OrderResponseDTO::mapToDTO)
                .toList();
    }

    @Override
    public List<OrderResponseDTO> getOrdersWithTotalAmountSortAsc(String sorted, int limit) {
        return orderRepository.findOrdersSortByTotalAmount(sorted, limit)
                .stream()
                .map(OrderResponseDTO::mapToDTO)
                .toList();
    }
}
