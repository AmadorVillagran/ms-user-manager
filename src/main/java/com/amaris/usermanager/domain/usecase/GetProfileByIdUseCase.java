package com.amaris.usermanager.domain.usecase;

import com.amaris.usermanager.domain.model.Profile;
import com.amaris.usermanager.domain.port.input.GetProfileById;
import com.amaris.usermanager.infrastructure.repository.GetProfileByIdRepository;

public class GetProfileByIdUseCase implements GetProfileById {
    private final GetProfileByIdRepository repository;

    public GetProfileByIdUseCase(GetProfileByIdRepository repository) {
        this.repository = repository;
    }

    @Override
    public Profile execute(Long id) {
        return repository.execute(id);
    }
}
