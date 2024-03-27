package com.amaris.usermanager.domain.usecase;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.domain.port.input.CreateUser;
import com.amaris.usermanager.infrastructure.repository.CreateUserRepository;
import com.amaris.usermanager.infrastructure.repository.jpa.UserRepository;
import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import com.amaris.usermanager.infrastructure.utils.EmailAlreadyExistException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

public class CreateUserUseCase implements CreateUser {

    private final CreateUserRepository repository;

    private final UserRepository userRepository;

    public CreateUserUseCase(CreateUserRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public User execute(User user) {
        UserEntity usEntity = userRepository.findByEmail(user.getEmail());
        if(usEntity == null){
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
        }else{
            throw new EmailAlreadyExistException();
        }
    }
}
