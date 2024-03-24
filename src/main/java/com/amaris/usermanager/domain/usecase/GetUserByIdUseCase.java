package com.amaris.usermanager.domain.usecase;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.domain.port.input.GetUserById;
import com.amaris.usermanager.infrastructure.repository.GetByIdUserRepository;

public class GetUserByIdUseCase implements GetUserById {
    private final GetByIdUserRepository repository;

    public GetUserByIdUseCase(GetByIdUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User execute(Long id) {
        return repository.execute(id);
    }
}
