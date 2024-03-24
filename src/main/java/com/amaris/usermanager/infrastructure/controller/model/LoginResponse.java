package com.amaris.usermanager.infrastructure.controller.model;

public class LoginResponse {
    private UserApi user;
    private String access_token;
    private ProfileApi profile;
    private String lastLogin;

    public UserApi getUser() {
        return user;
    }

    public void setUser(UserApi user) {
        this.user = user;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public ProfileApi getProfile() {
        return profile;
    }

    public void setProfile(ProfileApi profile) {
        this.profile = profile;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
}
