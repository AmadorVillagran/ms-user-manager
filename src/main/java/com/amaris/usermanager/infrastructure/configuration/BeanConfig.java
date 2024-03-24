package com.amaris.usermanager.infrastructure.configuration;

import com.amaris.usermanager.domain.port.input.ListUser;
import com.amaris.usermanager.domain.usecase.ListUsersUseCase;
import com.amaris.usermanager.infrastructure.repository.ListUsersRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ListUser listUser(ListUsersRepository repository){
        return new ListUsersUseCase(repository);
    }
}
