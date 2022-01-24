package com.example.crudproject.repository;


import com.example.crudproject.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
  List<Transaction> findByWalletMobile(Long mobileno);

}
