package com.cybersoft.assign_14_jpa.repository;

import com.cybersoft.assign_14_jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    boolean existsByName(String name);
}
