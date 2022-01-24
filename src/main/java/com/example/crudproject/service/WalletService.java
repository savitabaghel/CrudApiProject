package com.example.crudproject.service;


import com.example.crudproject.ExceptionHandle.WalletException;
import com.example.crudproject.model.Wallet;
import com.example.crudproject.repository.TransactionRepository;
import com.example.crudproject.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@Service

public class WalletService {

    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private TransactionRepository transactionRepository;


    public List<Wallet> findAll()
    {
       return  walletRepository.findAllByOrderByIdAsc();
    }
    public Wallet findOneWallet(long mobileno)
    {   try {
               Wallet exists = walletRepository.findByMobile(mobileno);
               if(exists!=null)
                   return exists;
               else
                   throw new WalletException("wallet not found",400);
          }
          catch(Exception e){
              throw new WalletException("could not fetch ",404);}
    }
    public Wallet createWallet(Wallet wallet)
    {
        Wallet exists=walletRepository.findByMobile(wallet.getMobileno());
        if(exists!=null) throw new WalletException("wallet already exists",409);

        return walletRepository.save(wallet);
    }
    public Wallet addAmount(long mobileno,double amount)
    {
        Wallet exists=walletRepository.findByMobile(mobileno);
        if(exists!=null)
        {
           Double currentBalance=exists.balance;
           Double finalBalance=currentBalance+amount;
           exists.setBalance(finalBalance);
           return walletRepository.save(exists);

        }
        else
            throw new WalletException("Amount cannot added",404);
    }
    public Wallet deleteAmount(long mobileno,double amount)
    {
        Wallet exists=walletRepository.findByMobile(mobileno);
        if(exists!=null)
        {
            Double currentBalance=exists.getBalance();
            Double updateBalance=currentBalance-amount;
            if(updateBalance>=0)
            {
                exists.setBalance(updateBalance);
                return walletRepository.save(exists);
            }
            else
                throw new WalletException("not sufficient balance",404);
        }
        else
            throw new WalletException("DeleteAmount could not perform",400);
    }
}
