package com.amaris.usermanager.infrastructure.controller;

import com.amaris.usermanager.domain.model.User;
import com.amaris.usermanager.domain.port.input.ListUser;
import com.amaris.usermanager.infrastructure.controller.model.UserApi;
import com.amaris.usermanager.infrastructure.controller.model.UserList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ListUsersController {
    
    private final ListUser listUser;

    public ListUsersController(ListUser listUser) {
        this.listUser = listUser;
    }

    @GetMapping("/user")
    public ResponseEntity<UserList> listUsers() {
        
        UserApi usApi = new UserApi();
        usApi.setEmail("23432");
        UserList res = new UserList();
        res.setUsers(new ArrayList<>());
        res.getUsers().add(usApi);
        List<User> lts = listUser.execute();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
