package com.project_intermediate.UserManagement_System_App.exception;

public class UserNotFoundException extends RuntimeException{

    // jab user na mile to ye error exception throw karna hai


    public UserNotFoundException(String message){  // constructor jisme hum message dete hai
        super(message);
    }


}
