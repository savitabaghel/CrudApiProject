package com.example.crudproject.service;

import com.example.crudproject.ExceptionHandle.UsernotFoundException;
import com.example.crudproject.model.user;
import com.example.crudproject.repository.userRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component

public class UserService
{
    @Autowired
    private userRepository userrepository;

    public List<user>getAlluser()
    {
        return (List<user>) this.userrepository.findAll();
    }


    public user getoneuser(int id)
    {
         return userrepository.findById(id);

    }


    public boolean checkForUser(int id)
    {
        return userrepository.existsById(id);
    }


    public user adduser(user user1)
    {
       return userrepository.save(user1);
    }


    public boolean deluser(int id)
    {
        if(!userrepository.existsById(id))  {
            userrepository.deleteById(id);
            return true;
        }
        else
            return false;

    }


    public user updateuser(user u,int id)
    {
        user uu=userrepository.findById(id);
       // uu.setId(u.getId());
        uu.setAddress2(u.getAddress2());
       // uu.setMobileno(u.getMobileno());
        uu.setEmailid(u.getEmailid());
        uu.setLastname(u.getLastname());
        uu.setFirstname(u.getFirstname());
        uu.setUpdatedate(u.getUpdatedate());

        userrepository.save(uu);
        return uu;

    }

}
