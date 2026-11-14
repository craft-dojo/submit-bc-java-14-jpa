package com.cybersoft.assign_14_jpa.repository;

import com.cybersoft.assign_14_jpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    boolean existsByEmail(String email);
}
