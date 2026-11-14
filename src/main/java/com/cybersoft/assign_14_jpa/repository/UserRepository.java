package com.cybersoft.assign_14_jpa.repository;

import com.cybersoft.assign_14_jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
