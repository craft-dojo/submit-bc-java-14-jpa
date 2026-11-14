package com.cybersoft.assign_14_jpa.services.imp;

import com.cybersoft.assign_14_jpa.entity.UserEntity;
import com.cybersoft.assign_14_jpa.repository.UserRepository;
import com.cybersoft.assign_14_jpa.request.InsertUserRequestDTO;
import com.cybersoft.assign_14_jpa.response.UserResponseDTO;
import com.cybersoft.assign_14_jpa.services.UserService;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO insertUser(InsertUserRequestDTO request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EntityExistsException("User with email " + request.getEmail() + " already exists");
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new EntityExistsException("User with username " + request.getUsername() + " already exists");
        }

        UserEntity newUser = UserEntity.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(request.getPassword())
                .build();
        UserEntity createdUser = userRepository.save(newUser);
        return UserResponseDTO.mapToDTO(createdUser);
    }
}
