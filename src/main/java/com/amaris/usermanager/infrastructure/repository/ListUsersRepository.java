package com.amaris.usermanager.infrastructure.repository;

import com.amaris.usermanager.domain.model.Profile;
import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.repository.jpa.UserRepository;
import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ListUsersRepository {
    private final UserRepository repository;

    public ListUsersRepository(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> execute(){
        List<UserEntity> usersEntity = repository.findAll();
        return usersEntity.stream()
                .map(u -> new User(u.getId(),
                                    u.getName(),
                                    u.getEmail(),
                                    u.getPassword(),
                                    u.getBirthday(),
                                    u.getPhone(),
                                    new Profile(
                                            u.getProfile().getId(),
                                            u.getProfile().getName(),
                                            u.getProfile().getDescription()),
                                    u.getStatus()))
                .collect(Collectors.toList());
    }
}
