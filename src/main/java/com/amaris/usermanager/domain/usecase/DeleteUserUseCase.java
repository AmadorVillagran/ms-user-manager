package com.amaris.usermanager.domain.usecase;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.domain.port.input.DeleteUser;
import com.amaris.usermanager.domain.port.input.GetUserById;
import com.amaris.usermanager.infrastructure.repository.DeleteRepository;

public class DeleteUserUseCase implements DeleteUser {

    private final DeleteRepository repository;

    private final GetUserById getUserById;
    public DeleteUserUseCase(DeleteRepository repository, GetUserById getUserById) {
        this.repository = repository;
        this.getUserById = getUserById;
    }


    @Override
    public User execute(Long id) {
        User user = getUserById.execute(id);
        user.setStatus("DEACTIVATE");
        repository.execute(user);
        return null;
    }
}
