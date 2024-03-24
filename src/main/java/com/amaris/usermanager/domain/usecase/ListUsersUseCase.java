package com.amaris.usermanager.domain.usecase;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.domain.port.input.ListUser;
import com.amaris.usermanager.infrastructure.repository.ListUsersRepository;

import java.util.List;

public class ListUsersUseCase implements ListUser {
    private final ListUsersRepository repository;

    public ListUsersUseCase(ListUsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> execute() {
        return repository.execute();
    }
}
