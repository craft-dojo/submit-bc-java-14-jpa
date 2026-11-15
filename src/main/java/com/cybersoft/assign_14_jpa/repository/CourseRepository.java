package com.cybersoft.assign_14_jpa.repository;

import com.cybersoft.assign_14_jpa.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    boolean existsByTitle(String title);
}
