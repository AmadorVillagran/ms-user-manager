package com.amaris.usermanager.infrastructure.controller;

import com.amaris.usermanager.domain.port.input.DeleteUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteUserByIdController {
    private final DeleteUser usecase;

    public DeleteUserByIdController(DeleteUser usecase) {
        this.usecase = usecase;
    }


    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        usecase.execute(userId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
