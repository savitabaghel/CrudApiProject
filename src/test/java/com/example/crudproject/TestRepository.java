package com.example.crudproject;


import com.example.crudproject.model.user;
import com.example.crudproject.repository.userRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestRepository
{
    @Autowired
    private userRepository userrepository;
    private user user1;

    @BeforeEach
    public void setUp()
    {
        user1=new user(5,"poni","sac","pony@1234",434522,"usa","NA",new Date(),new Date());

    }
    @AfterEach
    public void setOut()
    {
        userrepository.deleteAll();
        user1=null;
    }

    @Test
    public void saveUserTest()
    {
        userrepository.save(user1);
        user fetchedUser=userrepository.findById(user1.getId());

        assertEquals(5,fetchedUser.getId());
    }
    @Test
    public void findAllUserTest()
    {
        user user1=new user(1,"savi","bagh","savi@123",4352,"bhind","mp",new Date(),new Date());
        user user2=new user(2,"mani","sah","mani@123",23421,"bhind","mp",new Date(),new Date());
        userrepository.save(user1);
        userrepository.save(user2);
        List<user>userList= (List<user>) userrepository.findAll();
        System.out.println(userList);
        assertEquals("savi",userList.get(0).getFirstname());
    }

    @Test
    public void deleteUserTest()
    {
        user user1=new user(4,"savi","bagh","savi@123",43523,"bhind","mp",new Date(),new Date());
        userrepository.save(user1);
        userrepository.deleteById(user1.getId());
        user user2=userrepository.findById(user1.getId());
        assertEquals(null,user2);
    }

}
