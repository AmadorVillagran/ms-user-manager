package com.amaris.usermanager.infrastructure.repository.mapper;

import com.amaris.usermanager.domain.model.Profile;
import com.amaris.usermanager.infrastructure.repository.model.ProfileEntity;
import org.springframework.stereotype.Component;

@Component
public class ProfileToProfileEntityMapper {
    public ProfileEntity execute(Profile profile){
        ProfileEntity entity = new ProfileEntity();
        entity.setId(profile.getId());
        return entity;
    }
}
