package com.amaris.usermanager.infrastructure.controller.mapper;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.domain.port.input.GetProfileById;
import com.amaris.usermanager.infrastructure.controller.model.UserCreateRequest;
import com.amaris.usermanager.infrastructure.utils.FromMillisecondStringToInstant;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UserCreateRequestToUserMapper {
    private final GetProfileById getProfileById;

    private final FromMillisecondStringToInstant toInstant;
    public UserCreateRequestToUserMapper(GetProfileById getProfileById, FromMillisecondStringToInstant toInstant) {
        this.getProfileById = getProfileById;
        this.toInstant = toInstant;
    }

    public User execute(UserCreateRequest userCreateRequest){
        User us = new User();
        us.setName(userCreateRequest.getName());
        us.setEmail(userCreateRequest.getEmail());
        us.setPassword(userCreateRequest.getPassword());
        us.setPhone(userCreateRequest.getPhone());
        us.setBirthday(toInstant.execute(userCreateRequest.getBirthday()));
        us.setProfile(getProfileById.execute(userCreateRequest.getProfile().longValue()));
        return us;
    }
}
