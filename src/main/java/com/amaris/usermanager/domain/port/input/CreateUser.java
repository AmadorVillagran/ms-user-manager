package com.amaris.usermanager.domain.port.input;

import com.amaris.usermanager.domain.model.User;

public interface CreateUser {

    User execute(User user);
}
