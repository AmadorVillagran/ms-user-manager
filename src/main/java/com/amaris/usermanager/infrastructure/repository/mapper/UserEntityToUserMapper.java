package com.amaris.usermanager.infrastructure.repository.mapper;

import com.amaris.usermanager.domain.model.Profile;
import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserMapper {
    public User execute(UserEntity userEntity) {
        User us = new User();
        us.setId(userEntity.getId());
        us.setName(userEntity.getName());
        us.setEmail(userEntity.getEmail());
        us.setPhone(userEntity.getPhone());
        us.setStatus(userEntity.getStatus());
        us.setProfile(new Profile(
                userEntity.getProfile().getId(),
                userEntity.getProfile().getName(),
                userEntity.getProfile().getDescription()));
        us.setBirthday(userEntity.getBirthday());
        return us;
    }
}
