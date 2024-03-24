package com.amaris.usermanager.infrastructure.repository;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.repository.jpa.UserRepository;
import com.amaris.usermanager.infrastructure.repository.mapper.UserEntityToUserMapper;
import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class GetByIdUserRepository {

    private final UserRepository repository;

    private final UserEntityToUserMapper toUserMapper;

    public GetByIdUserRepository(UserRepository repository, UserEntityToUserMapper toUserMapper) {
        this.repository = repository;
        this.toUserMapper = toUserMapper;
    }

    public User execute(Long id){
        Optional<UserEntity> opUser = repository.findById(id);
        return toUserMapper.execute(opUser.get());
    }
}
