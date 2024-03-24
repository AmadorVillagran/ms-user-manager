package com.amaris.usermanager.infrastructure.controller;

import com.amaris.usermanager.infrastructure.controller.model.UserCreateRequest;
import com.amaris.usermanager.infrastructure.controller.model.UserCreateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController {
    @PostMapping("/user")
    public ResponseEntity<UserCreateResponse> createUser(@RequestBody UserCreateRequest userRequest) {
        UserCreateResponse res = new UserCreateResponse();
        res.setEmail(userRequest.getEmail());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
