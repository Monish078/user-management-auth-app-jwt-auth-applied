package com.project_intermediate.UserManagement_System_App.exception;

import org.yaml.snakeyaml.emitter.Emitable;

public class EmailAlreadyExistException extends RuntimeException{

    public EmailAlreadyExistException(String getMessage){
        super(getMessage);
    }
}
