package com.amaris.usermanager.infrastructure.controller;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.domain.port.input.UpdateUser;
import com.amaris.usermanager.infrastructure.controller.mapper.UserUpdateRequestToUserMapper;
import com.amaris.usermanager.infrastructure.controller.model.UserUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UpdateUserController {
    private final UpdateUser updateUser;

    private final UserUpdateRequestToUserMapper toUserMapper;
    public UpdateUserController(UpdateUser updateUser, UserUpdateRequestToUserMapper toUserMapper) {
        this.updateUser = updateUser;
        this.toUserMapper = toUserMapper;
    }

    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(@RequestBody UserUpdateRequest userRequest) {
        User user = toUserMapper.execute(userRequest);
        user.setDateModified(new Date());
        updateUser.execute(user);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
