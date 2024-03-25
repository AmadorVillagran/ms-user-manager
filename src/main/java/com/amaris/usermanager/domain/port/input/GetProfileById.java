package com.amaris.usermanager.domain.port.input;

import com.amaris.usermanager.domain.model.Profile;

public interface GetProfileById {

    Profile execute(Long id);
}
