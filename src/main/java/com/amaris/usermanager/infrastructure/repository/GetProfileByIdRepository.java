package com.amaris.usermanager.infrastructure.repository;

import com.amaris.usermanager.domain.model.Profile;
import com.amaris.usermanager.infrastructure.repository.jpa.ProfileRepository;
import com.amaris.usermanager.infrastructure.repository.mapper.ProfileEntityToProfileMapper;
import com.amaris.usermanager.infrastructure.repository.model.ProfileEntity;
import org.springframework.stereotype.Repository;

@Repository
public class GetProfileByIdRepository {

    private final ProfileRepository repository;
    private final ProfileEntityToProfileMapper toProfileMapper;
    public GetProfileByIdRepository(ProfileRepository repository,
                                    ProfileEntityToProfileMapper toProfileMapper) {
        this.repository = repository;
        this.toProfileMapper = toProfileMapper;
    }

    public Profile execute(Long id){
        ProfileEntity profileOp = repository.getById(id);
        return toProfileMapper.execute(profileOp);
    }
}
