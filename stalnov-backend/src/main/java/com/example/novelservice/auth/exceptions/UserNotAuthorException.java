package com.example.novelservice.auth.exceptions;

public class UserNotAuthorException extends Exception{
    public UserNotAuthorException(){
        super("User must be author to perform this operation");
    }
}
