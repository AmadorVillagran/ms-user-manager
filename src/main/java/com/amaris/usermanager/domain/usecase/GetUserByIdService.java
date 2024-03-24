package com.amaris.usermanager.domain.usecase;

import com.amaris.usermanager.infrastructure.repository.jpa.UserRepository;
import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserByIdService {
    private final UserRepository userRepository;

    public GetUserByIdService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity execute(Long id){
        Optional<UserEntity> opUser = userRepository.findById(id);
        if(opUser.isPresent()){
            return opUser.get();
        }
        else{
            return null;
        }
    }
}
