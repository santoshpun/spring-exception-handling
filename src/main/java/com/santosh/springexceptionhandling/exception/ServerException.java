package com.santosh.springexceptionhandling.exception;

public class ServerException extends RuntimeException{

    public ServerException(String message){
        super(message);
    }
}
