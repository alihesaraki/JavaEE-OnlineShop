package com.mftplus.demo.controller.exception;

public class NoRoleException extends Exception{
    public NoRoleException() {
        super("No role found");
    }
}
