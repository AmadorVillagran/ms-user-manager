package com.amaris.usermanager.infrastructure.utils;

public class EmailAlreadyExistException extends RuntimeException{

    public EmailAlreadyExistException() {
        super("El correo ya registrado");
    }
}
