package com.cybersoft.assign_14_jpa.repository;

import com.cybersoft.assign_14_jpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    boolean existsByEmail(String email);

    @Query("SELECT s FROM students s LEFT JOIN s.courses WHERE s.id = :id")
    Optional<StudentEntity> findByIdWithCourses(@Param("id") int id);
}
