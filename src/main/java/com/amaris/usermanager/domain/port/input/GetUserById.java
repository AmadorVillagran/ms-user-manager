package com.amaris.usermanager.domain.port.input;

import com.amaris.usermanager.domain.model.User;

public interface GetUserById {

    User execute(Long id);
}
