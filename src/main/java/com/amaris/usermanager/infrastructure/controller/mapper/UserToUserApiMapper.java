package com.amaris.usermanager.infrastructure.controller.mapper;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.controller.model.UserApi;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UserToUserApiMapper {

    public UserApi execute(User user){
        UserApi usApi = new UserApi();
        usApi.setId(user.getId());
        usApi.setName(user.getName());
        usApi.setEmail(user.getEmail());
        usApi.setPhone((user.getPhone()!=null)?user.getPhone().toString():null);
        usApi.setBirthday(fromInstantToString(user.getBirthday()));
        return usApi;
    }

    private String fromInstantToString(Instant instant){
        if(instant!=null){
            return String.valueOf(instant.toEpochMilli());
        }else{
            return null;
        }
    }
}
