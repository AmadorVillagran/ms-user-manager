package com.amaris.usermanager.infrastructure.repository.mapper;

import com.amaris.usermanager.domain.model.Profile;
import com.amaris.usermanager.infrastructure.repository.model.ProfileEntity;
import org.springframework.stereotype.Component;

@Component
public class ProfileEntityToProfileMapper {
    public Profile execute(ProfileEntity profile){
        Profile pr = new Profile();
        pr.setId(pr.getId());
        return pr;
    }
}
