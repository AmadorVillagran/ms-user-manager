package com.amaris.usermanager.infrastructure.controller.mapper;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.domain.port.input.GetProfileById;
import com.amaris.usermanager.infrastructure.controller.model.UserUpdateRequest;
import com.amaris.usermanager.infrastructure.utils.FromMillisecondStringToInstant;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UserUpdateRequestToUserMapper {
    private final GetProfileById getProfileById;

    private final FromMillisecondStringToInstant toInstant;
    public UserUpdateRequestToUserMapper(GetProfileById getProfileById, FromMillisecondStringToInstant toInstant) {
        this.getProfileById = getProfileById;
        this.toInstant = toInstant;
    }

    public User execute(UserUpdateRequest userUpdateRequest){
        User us = new User();
        us.setId(userUpdateRequest.getId());
        us.setName(userUpdateRequest.getName());
        us.setEmail(userUpdateRequest.getEmail());
        us.setPassword(userUpdateRequest.getPassword());
        us.setBirthday(toInstant.execute(userUpdateRequest.getBirthday()));
        us.setPhone(Integer.valueOf(userUpdateRequest.getPhone()));
        us.setProfile(getProfileById.execute(userUpdateRequest.getProfile().longValue()));
        return us;
    }

}
