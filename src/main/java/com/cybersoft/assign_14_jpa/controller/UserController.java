package com.cybersoft.assign_14_jpa.controller;

import com.cybersoft.assign_14_jpa.request.InsertUserRequestDTO;
import com.cybersoft.assign_14_jpa.response.BaseResponse;
import com.cybersoft.assign_14_jpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> insertUser(@Validated @RequestBody InsertUserRequestDTO request) {
        BaseResponse res = BaseResponse.success(userService.insertUser(request), "Created successful", null);

        return ResponseEntity.ok(res);
    }
}
