package com.amaris.usermanager.infrastructure.controller.mapper;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.controller.model.UserCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class UserCreateRequestToUserMapper {

    public User execute(UserCreateRequest userCreateRequest){
        User us = new User();
        us.setName(userCreateRequest.getName());
        us.setEmail(userCreateRequest.getEmail());
        us.setPhone(Integer.valueOf(userCreateRequest.getPhone()));
        return us;
    }
}
