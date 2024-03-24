package com.amaris.usermanager.domain.usecase;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.domain.port.input.DeleteUser;
import com.amaris.usermanager.infrastructure.repository.DeleteRepository;

public class DeleteUserUseCase implements DeleteUser {

    private final DeleteRepository repository;

    public DeleteUserUseCase(DeleteRepository repository) {
        this.repository = repository;
    }


    @Override
    public User execute(Long id) {
        return null;
    }
}
