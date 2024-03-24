package com.amaris.usermanager.infrastructure.controller;

import com.amaris.usermanager.infrastructure.controller.model.UserApi;
import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import com.amaris.usermanager.domain.usecase.GetUserByIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUserByIdController {

    private final GetUserByIdService getUserByIdService;

    public GetUserByIdController(GetUserByIdService getUserByIdService) {
        this.getUserByIdService = getUserByIdService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserApi> getUserById(@PathVariable Long userId) {

        UserEntity user = getUserByIdService.execute(userId);

        UserApi res = new UserApi();
        res.setEmail(userId.toString());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
