package com.cybersoft.assign_14_jpa.controller;

import com.cybersoft.assign_14_jpa.response.BaseResponse;
import com.cybersoft.assign_14_jpa.response.OrderResponseDTO;
import com.cybersoft.assign_14_jpa.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/top")
    public ResponseEntity<BaseResponse> getTopOrders() {
        List<OrderResponseDTO> orders = orderService.getOrdersWithTotalAmountSortAsc("DESC", 5);
        BaseResponse res = BaseResponse.success(orders, null, null);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/search")
    public ResponseEntity<BaseResponse> getOrdersFromCreatedAt(@RequestParam @DateTimeFormat(iso =
            DateTimeFormat.ISO.DATE) LocalDate createdAt) {
        LocalDateTime startOfDay = createdAt.atStartOfDay();

        List<OrderResponseDTO> orders = orderService.getOrdersByFromCreatedAt(startOfDay);
        BaseResponse res = BaseResponse.success(orders, null, null);
        return ResponseEntity.ok(res);
    }
}
