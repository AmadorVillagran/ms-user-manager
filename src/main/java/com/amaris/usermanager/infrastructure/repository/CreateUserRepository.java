package com.amaris.usermanager.infrastructure.repository;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.repository.jpa.UserRepository;
import com.amaris.usermanager.infrastructure.repository.mapper.UserEntityToUserMapper;
import com.amaris.usermanager.infrastructure.repository.mapper.UserToUserEntityMapper;
import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CreateUserRepository {

    private final UserRepository repository;

    private final UserToUserEntityMapper toUserEntityMapper;

    private final UserEntityToUserMapper toUserMapper;

    public CreateUserRepository(UserRepository repository, UserToUserEntityMapper mapper, UserEntityToUserMapper userEntityToUserMapper) {
        this.repository = repository;
        this.toUserEntityMapper = mapper;
        this.toUserMapper = userEntityToUserMapper;
    }

    public User execute(User user){
        return toUserMapper.execute(repository.save(toUserEntityMapper.execute(user)));
    }

}
