package com.example.crudproject.repository;

import com.example.crudproject.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface WalletRepository extends JpaRepository<Wallet,Long> {

    List<Wallet>findAllByOrderByIdAsc();
    public Wallet findById(long id);
    public Wallet findByMobile(long mobileno);



}
