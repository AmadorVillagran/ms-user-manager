package com.amaris.usermanager.infrastructure.repository;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.repository.jpa.UserRepository;
import com.amaris.usermanager.infrastructure.repository.mapper.UserEntityToUserMapper;
import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetByIdUserRepositoryTest {

    @InjectMocks private GetByIdUserRepository getByIdUserRepository;
    @Mock private UserRepository userRepository;

    @Mock private UserEntityToUserMapper userEntityToUserMapper;

    @Test
    void should_return_an_user_with_1_as_a_id(){
        final long expectedId = (long) 1;

        //mocking data
        long id = (long) 1;
        UserEntity usEntity = new UserEntity();
        usEntity.setId(id);
        Optional<UserEntity> opUserMock = Optional.of(usEntity);
        User usResMock = new User();
        usResMock.setId(id);

        when(userRepository.findById(id)).thenReturn(opUserMock);
        when(userEntityToUserMapper.execute(usEntity)).thenReturn(usResMock);

        User res = getByIdUserRepository.execute(id);

        assertEquals(expectedId, res.getId());
    }

}