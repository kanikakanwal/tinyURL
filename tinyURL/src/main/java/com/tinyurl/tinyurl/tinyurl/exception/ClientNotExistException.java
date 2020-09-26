package com.tinyurl.tinyurl.tinyurl.exception;

public class ClientNotExistException extends Exception{
    String message = "";
    public ClientNotExistException(String message) {
        this.message = message;
    }
}
