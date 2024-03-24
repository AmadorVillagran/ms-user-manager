package com.amaris.usermanager.infrastructure.repository.mapper;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserToUserEntityMapper {
    public UserEntity execute(User user) {
        UserEntity entity = new UserEntity();
        entity.setEmail(user.getEmail());
        return entity;
    }
}
