package com.amaris.usermanager.infrastructure.controller.mapper;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.controller.model.UserCreateResponse;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCreateResponse {

    public UserCreateResponse execute(User user){
        UserCreateResponse usRes = new UserCreateResponse();
        usRes.setId(user.getId());
        usRes.setName(user.getName());
        usRes.setPassword(user.getPassword());
        usRes.setEmail(user.getEmail());
        usRes.setPhone(user.getPhone().toString());
        usRes.setProfile(user.getProfile().getId().intValue());
        usRes.setCreated(user.getDateCreate().toString());
        usRes.setModified(user.getDateModified().toString());
        return usRes;
    }
}
