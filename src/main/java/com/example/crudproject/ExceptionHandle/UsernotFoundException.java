package com.example.crudproject.ExceptionHandle;

import net.bytebuddy.implementation.bind.annotation.Super;

public class UsernotFoundException extends RuntimeException{

    public UsernotFoundException(int id)
    {
        super("User not found with id:"+id);
    }
}
