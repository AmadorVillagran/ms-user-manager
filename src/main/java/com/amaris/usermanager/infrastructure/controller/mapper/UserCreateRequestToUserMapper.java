package com.amaris.usermanager.infrastructure.controller.mapper;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.domain.port.input.GetProfileById;
import com.amaris.usermanager.infrastructure.controller.model.UserCreateRequest;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UserCreateRequestToUserMapper {
    private final GetProfileById getProfileById;

    public UserCreateRequestToUserMapper(GetProfileById getProfileById) {
        this.getProfileById = getProfileById;
    }

    public User execute(UserCreateRequest userCreateRequest){
        User us = new User();
        us.setName(userCreateRequest.getName());
        us.setEmail(userCreateRequest.getEmail());
        us.setPassword(userCreateRequest.getPassword());
        us.setPhone(Integer.valueOf(userCreateRequest.getPhone()));
        us.setBirthday(fromStringToInstance(userCreateRequest.getBirthday()));
        us.setProfile(getProfileById.execute(userCreateRequest.getProfile().longValue()));
        return us;
    }

    private Instant fromStringToInstance(String dateMillSec){
        return Instant.ofEpochMilli(Long.parseLong(dateMillSec));
    }
}
