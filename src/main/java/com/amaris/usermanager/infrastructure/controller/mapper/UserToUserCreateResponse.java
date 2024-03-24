package com.amaris.usermanager.infrastructure.controller.mapper;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.controller.model.UserCreateResponse;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCreateResponse {

    public UserCreateResponse execute(User user){
        UserCreateResponse usRes = new UserCreateResponse();
        usRes.setEmail(user.getEmail());
        return usRes;
    }
}
