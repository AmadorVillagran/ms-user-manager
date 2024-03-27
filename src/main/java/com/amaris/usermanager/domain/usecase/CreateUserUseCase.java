package com.amaris.usermanager.domain.usecase;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.domain.port.input.CreateUser;
import com.amaris.usermanager.domain.port.input.GetProfileById;
import com.amaris.usermanager.infrastructure.repository.CreateUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

public class CreateUserUseCase implements CreateUser {

    private final CreateUserRepository repository;

    public CreateUserUseCase(CreateUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User execute(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass = user.getPassword();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus("ACTIVE");
        user.setDateCreate(new Date());
        user.setDateModified(new Date());
        user.setLastLogin(new Date());
        User usSaved = repository.execute(user);
        usSaved.setPassword(pass);
        return usSaved;
    }
}
