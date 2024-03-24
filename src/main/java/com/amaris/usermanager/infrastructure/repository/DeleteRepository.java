package com.amaris.usermanager.infrastructure.repository;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.repository.jpa.UserRepository;
import com.amaris.usermanager.infrastructure.repository.mapper.UserToUserEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteRepository {
    private final UserRepository repository;
    private final UserToUserEntityMapper toUserEntityMapper;

    public DeleteRepository(UserRepository repository, UserToUserEntityMapper toUserEntityMapper) {
        this.repository = repository;
        this.toUserEntityMapper = toUserEntityMapper;
    }

    public void execute(User user){
        repository.save(toUserEntityMapper.execute(user));
    }
}
