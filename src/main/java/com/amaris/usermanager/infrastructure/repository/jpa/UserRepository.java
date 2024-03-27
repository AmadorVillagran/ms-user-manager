package com.amaris.usermanager.infrastructure.repository.jpa;

import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByName(String name);
    UserEntity findByEmail(String email);
}
