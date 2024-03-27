package com.amaris.usermanager.infrastructure.configuration;

import com.amaris.usermanager.domain.port.input.*;
import com.amaris.usermanager.domain.usecase.*;
import com.amaris.usermanager.infrastructure.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

@Configuration
public class BeanConfig {

    @Bean
    public CreateUser createUser(CreateUserRepository repository){
        return new CreateUserUseCase(repository);
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
