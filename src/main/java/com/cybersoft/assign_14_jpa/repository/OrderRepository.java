package com.cybersoft.assign_14_jpa.repository;

import com.cybersoft.assign_14_jpa.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    @Query("SELECT o FROM orders o WHERE o.createdAt >= :createdAt")
    List<OrderEntity> findOrdersFromCreatedAt(@Param("createdAt") LocalDateTime createdAt);

    @Query("""
            SELECT o FROM orders o
            ORDER BY
            CASE WHEN :sorted = 'ASC' THEN o.totalAmount END ASC,
            CASE WHEN :sorted = 'DESC' THEN o.totalAmount END DESC
            LIMIT :limit
            """)
    List<OrderEntity> findOrdersSortByTotalAmount(@Param("sorted") String sorted, @Param("limit") int limit);
}
