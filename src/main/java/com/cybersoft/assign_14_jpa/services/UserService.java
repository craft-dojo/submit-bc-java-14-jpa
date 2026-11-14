package com.cybersoft.assign_14_jpa.services;

import com.cybersoft.assign_14_jpa.request.InsertUserRequestDTO;
import com.cybersoft.assign_14_jpa.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO insertUser(InsertUserRequestDTO request);
}
