package com.amaris.usermanager.infrastructure.controller.mapper;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.infrastructure.controller.model.UserApi;
import com.amaris.usermanager.infrastructure.utils.FromInstantToMillisecondString;
import org.springframework.stereotype.Component;

@Component
public class UserToUserApiMapper {

    private final FromInstantToMillisecondString toMillisecondString;

    public UserToUserApiMapper(FromInstantToMillisecondString toMillisecondString) {
        this.toMillisecondString = toMillisecondString;
    }

    public UserApi execute(User user){
        UserApi usApi = new UserApi();
        usApi.setId(user.getId());
        usApi.setName(user.getName());
        usApi.setEmail(user.getEmail());
        usApi.setPhone((user.getPhone()!=null)?user.getPhone().toString():null);
        usApi.setBirthday(toMillisecondString.execute(user.getBirthday()));
        return usApi;
    }

}
