package com.amaris.usermanager.infrastructure.controller.model;

import java.util.List;

public class UserList {
    private List<UserApi> users;

    public List<UserApi> getUsers() {
        return users;
    }

    public void setUsers(List<UserApi> users) {
        this.users = users;
    }
}
