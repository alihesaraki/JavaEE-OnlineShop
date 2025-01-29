package com.mftplus.demo.controller.exception;

public class NoUserException extends Exception{
    public NoUserException() {
        super("No user found");
    }
}
