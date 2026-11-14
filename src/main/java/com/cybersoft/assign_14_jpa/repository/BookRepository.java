package com.cybersoft.assign_14_jpa.repository;

import com.cybersoft.assign_14_jpa.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    @Query("""
            SELECT b FROM books b
            WHERE (:author IS NOT NULL AND :author != '' AND LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%')))
                OR (
                    (:minPrice IS NOT NULL OR :maxPrice IS NOT NULL)
                    AND (:minPrice IS NULL OR b.price >= :minPrice)
                    AND (:maxPrice IS NULL OR b.price <= :maxPrice)
                )
            """)
    List<BookEntity> searchBook(@Param("author") String author,
                                @Param("minPrice") BigDecimal minPrice,
                                @Param("maxPrice") BigDecimal maxPrice);
}
