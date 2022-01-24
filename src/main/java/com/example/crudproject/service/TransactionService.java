package com.example.crudproject.service;


import com.example.crudproject.ExceptionHandle.WalletException;
import com.example.crudproject.model.Transaction;
import com.example.crudproject.model.Wallet;
import com.example.crudproject.repository.TransactionRepository;
import com.example.crudproject.repository.TypeReporitory;
import com.example.crudproject.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired WalletService walletService;
    @Autowired
    private TypeReporitory typeReporitory;

    public List<Transaction>getTransactionByWalletMobileno(long mobileno) throws WalletException
    {
        try{
            return transactionRepository.findByWalletMobile(mobileno);
        }
        catch (Exception e)
        {
            throw new WalletException("walletId does not exists",400);
        }
    }
    public Transaction createTransactionByMobile(int typeId,double amount,long walletId,long mobileNo)
    {
        try
        {
            if (typeId==2)
            {
                walletService.addAmount(mobileNo,amount);
            }
            else if(typeId==1)
            {
                walletService.deleteAmount(mobileNo,amount);
            }
            Wallet addWallet=walletService.findOneWallet(mobileNo);
            if(addWallet!=null)
            {
                Transaction addTransaction=new Transaction(amount,addWallet,mobileNo,typeReporitory.getOne(typeId));
                Transaction createdTransaction=transactionRepository.save(addTransaction);
                if(createdTransaction!=null)
                {
                    return createdTransaction;
                }
                else
                {
                    throw new WalletException("Transaction could not completed",400);
                }
            }
            else
            {
                throw new WalletException("Transaction could not perform,valid wallet doesnt exists",400);
            }
        }
        catch (NumberFormatException e)
        {
            throw new WalletException("Format Exception",400);
        }
    }
}
