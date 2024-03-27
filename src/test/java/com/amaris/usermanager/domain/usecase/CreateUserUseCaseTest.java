package com.amaris.usermanager.domain.usecase;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.repository.CreateUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {

    @InjectMocks private CreateUserUseCase useCase;
    @Mock private CreateUserRepository repository;

    @Test void should_return_an_User(){
        final String expectedName = "testUser";

        User usResMock = new User();
        usResMock.setName("testUser");
        User usRqMock = new User();
        usRqMock.setName("testUser");
        usRqMock.setPassword("test");

        when(repository.execute(usRqMock)).thenReturn(usResMock);

        User res = useCase.execute(usRqMock);

        assertEquals(expectedName, res.getName());

    }
}