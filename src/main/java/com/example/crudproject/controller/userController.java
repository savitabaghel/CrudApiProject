package com.example.crudproject.controller;


//import com.example.crudproject.exeption.UserException;
import com.example.crudproject.Responces.BaseResponce;
import com.example.crudproject.model.user;
import com.example.crudproject.repository.userRepository;
import com.example.crudproject.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/u")
public class userController
{

    @Autowired
    private UserService userService;

    //method for read all data
    @GetMapping("/api")
    public ResponseEntity<Object> getAllusers()
    {   try {
        List<user>result=userService.getAlluser();
        return BaseResponce.generateResponse("Successfull",HttpStatus.OK,result);
            }
         catch (Exception e)
         {
             return BaseResponce.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
         }
    }



    //method for read data of particular user
    @GetMapping("/api/{id}")
     public ResponseEntity<Object> getbyid(@PathVariable("id")int id)
     {
         try {
             user result=userService.getoneuser(id);
             return BaseResponce.generateResponse("Successfull",HttpStatus.OK,result);
         }
         catch (Exception e)
         {
             return BaseResponce.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST,null);
         }


     }



    //method for create operation
    @PostMapping("/api")
    public ResponseEntity<Object> createuser(@RequestBody user user1)
    {
          try {
              user result=userService.adduser(user1);
              return BaseResponce.generateResponse("Successfully added",HttpStatus.CREATED,result);
          }
          catch (Exception e)
          {
              return BaseResponce.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS,null);
          }

    }

    //method for delete
    @DeleteMapping("/api/{id}")
    public ResponseEntity<Object> deleteuser(@PathVariable("id") int id)
    {
        try {
            boolean result=userService.deluser(id);
            return BaseResponce.generateResponse("Deleted",HttpStatus.OK,result);
        }
        catch (Exception e)
        {
            return BaseResponce.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST,null);
        }




    }

    //method for update
    @PutMapping("/api/{id}")
    public ResponseEntity<Object> update(@RequestBody user u,@PathVariable("id") int id)
    {
       try {
           user result=userService.updateuser(u,id);
           return BaseResponce.generateResponse("Updated successfully",HttpStatus.OK,result);
       }
       catch (Exception e)
       {
           return BaseResponce.generateResponse(e.getMessage(),HttpStatus.BAD_REQUEST,null);
       }

    }



}
