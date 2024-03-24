package com.amaris.usermanager.infrastructure.controller;

import com.amaris.usermanager.infrastructure.controller.model.UserUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateUserController {
    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(@RequestBody UserUpdateRequest userRequest) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
