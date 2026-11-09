package com.rodri.dev.workshopmongo.service.exception;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
