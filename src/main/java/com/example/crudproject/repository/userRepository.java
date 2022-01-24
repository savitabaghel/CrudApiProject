package com.example.crudproject.repository;


import com.example.crudproject.model.user;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<user,Integer> {
public user findById(int id);

    //all crud database method*/
}
