package com.amaris.usermanager.infrastructure.controller.mapper;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.controller.model.UserApi;
import org.springframework.stereotype.Component;

@Component
public class UserToUserApiMapper {

    public UserApi execute(User user){
        UserApi usApi = new UserApi();
        usApi.setEmail(user.getEmail());
        return usApi;
    }
}
