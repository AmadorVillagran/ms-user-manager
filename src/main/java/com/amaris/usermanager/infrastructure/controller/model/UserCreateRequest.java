package com.amaris.usermanager.infrastructure.controller.model;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserCreateRequest {
    private String name;
//    @Email(message = "Correo electrónico no válido")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Formato de correo electrónico inválido")
    private String email;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d.*\\d)[A-Za-z\\d]{6,}$\n", message = "Formato de clave inválido")

    private String password;
    @Size(max = 13, message = "La longitud de telefono no puede ser mayor a 13 caracteres")
    private Integer phone;

    private String birthday;
    private Integer profile;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }
}
