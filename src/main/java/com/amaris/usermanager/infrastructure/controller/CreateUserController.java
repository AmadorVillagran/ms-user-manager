package com.amaris.usermanager.infrastructure.controller;

import com.amaris.usermanager.domain.port.input.CreateUser;
import com.amaris.usermanager.domain.usecase.CreateUserUseCase;
import com.amaris.usermanager.infrastructure.controller.mapper.UserCreateRequestToUserMapper;
import com.amaris.usermanager.infrastructure.controller.mapper.UserToUserCreateResponse;
import com.amaris.usermanager.infrastructure.controller.model.UserCreateRequest;
import com.amaris.usermanager.infrastructure.controller.model.UserCreateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController {

    private final CreateUser useCase;

    private final UserCreateRequestToUserMapper requestMapper;

    private final UserToUserCreateResponse responseMapper;

    public CreateUserController(CreateUser useCase,
                                UserCreateRequestToUserMapper requestMapper,
                                UserToUserCreateResponse responseMapper) {
        this.useCase = useCase;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/user")
    public ResponseEntity<UserCreateResponse> createUser(@RequestBody UserCreateRequest userRequest) {
        UserCreateResponse res = responseMapper.execute(useCase.execute(requestMapper.execute(userRequest)));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
