package com.mftplus.demo.controller.exception;

public class NoPersonException extends Exception{
    public NoPersonException() {
        super("No person found");
    }
}
