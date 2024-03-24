package com.amaris.usermanager.infrastructure.repository.mapper;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserMapper {
    public User execute(UserEntity userEntity) {
        User us = new User();
        us.setEmail(userEntity.getEmail());
        return us;
    }
}
