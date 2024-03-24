package com.amaris.usermanager.domain.port.input;

import com.amaris.usermanager.domain.model.User;

public interface DeleteUser {
    User execute(Long id);
}
