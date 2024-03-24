package com.amaris.usermanager.infrastructure.controller.mapper;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.controller.model.UserUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateRequestToUserMapper {

    public User execute(UserUpdateRequest userUpdateRequest){
        User us = new User();
        us.setEmail(userUpdateRequest.getEmail());
        return us;
    }
}
