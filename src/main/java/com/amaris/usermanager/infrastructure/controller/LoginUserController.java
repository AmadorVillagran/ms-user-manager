package com.amaris.usermanager.infrastructure.controller;

import com.amaris.usermanager.infrastructure.controller.model.LoginRequest;
import com.amaris.usermanager.infrastructure.controller.model.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginUserController {
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        LoginResponse res = new LoginResponse();
        res.setAccess_token("res");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
