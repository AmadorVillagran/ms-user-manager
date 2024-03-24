package com.amaris.usermanager.infrastructure.controller.model;

public class UserApi {
    private Long id;
    private String name;
    private String email;
    private String birthday;
    private String phone;

    public UserApi() {
    }

    public UserApi(Long id, String name, String email, String birthday, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
