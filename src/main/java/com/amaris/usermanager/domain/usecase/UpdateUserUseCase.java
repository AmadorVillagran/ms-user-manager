package com.amaris.usermanager.domain.usecase;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.domain.port.input.UpdateUser;
import com.amaris.usermanager.infrastructure.repository.UpdateRepository;

public class UpdateUserUseCase implements UpdateUser {
    private final UpdateRepository repository;

    public UpdateUserUseCase(UpdateRepository repository) {
        this.repository = repository;
    }

    @Override
    public User execute(User user) {
        repository.execute(user);
        return null;
    }
}
