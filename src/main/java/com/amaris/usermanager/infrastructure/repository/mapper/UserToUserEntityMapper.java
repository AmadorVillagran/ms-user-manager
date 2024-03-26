package com.amaris.usermanager.infrastructure.repository.mapper;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.repository.model.ProfileEntity;
import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserToUserEntityMapper {
    public UserEntity execute(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setBirthday(user.getBirthday());
        entity.setPhone(user.getPhone());
        ProfileEntity pr = new ProfileEntity();
        pr.setId(user.getProfile().getId());
        pr.setName(user.getProfile().getName());
        pr.setDescription(user.getProfile().getDescription());
        entity.setProfile(pr);
        entity.setStatus(user.getStatus());
        entity.setDateCreate(user.getDateCreate());
        entity.setDateModified(user.getDateModified());
        entity.setLastLogin(user.getLastLogin());
        return entity;
    }
}
