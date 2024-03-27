package com.amaris.usermanager.infrastructure.configuration;

import com.amaris.usermanager.domain.port.input.*;
import com.amaris.usermanager.domain.usecase.*;
import com.amaris.usermanager.infrastructure.repository.*;
import com.amaris.usermanager.infrastructure.repository.jpa.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateUser createUser(CreateUserRepository repository, UserRepository userRepository){
        return new CreateUserUseCase(repository, userRepository);
    }
    @Bean
    public DeleteUser deleteUser(DeleteRepository repository, GetUserById getUserById){
        return new DeleteUserUseCase(repository, getUserById);
    }
    @Bean
    public GetUserById getUserById(GetByIdUserRepository repository){
        return new GetUserByIdUseCase(repository);
    }
    @Bean
    public ListUser listUser(ListUsersRepository repository){
        return new ListUsersUseCase(repository);
    }
    @Bean
    public UpdateUser updateUser(UpdateRepository repository){
        return new UpdateUserUseCase(repository);
    }

    @Bean
    public GetProfileById getProfileById(GetProfileByIdRepository repository){
        return new GetProfileByIdUseCase(repository);
    }
}
