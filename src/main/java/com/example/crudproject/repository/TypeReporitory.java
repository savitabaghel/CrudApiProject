package com.example.crudproject.repository;


import com.example.crudproject.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional()
public interface TypeReporitory extends JpaRepository<Type,Integer> {
}
