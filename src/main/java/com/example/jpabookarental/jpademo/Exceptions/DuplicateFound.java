package com.example.jpabookarental.jpademo.Exceptions;

public class DuplicateFound extends RuntimeException
{
    public DuplicateFound(String message){
        super(message);
    }

}
