package com.example.jpabookarental.jpademo.Exceptions;

public class UserNotFound extends RuntimeException
{
    public UserNotFound(String message)
    {
       super(message);
    }

}
