package com.amaris.usermanager.domain.port.input;

import com.amaris.usermanager.domain.model.User;

import java.util.List;

public interface ListUser {

    public List<User> execute();
}
