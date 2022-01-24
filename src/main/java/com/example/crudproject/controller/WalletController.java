package com.example.crudproject.controller;


import com.example.crudproject.ExceptionHandle.WalletException;
import com.example.crudproject.model.Wallet;
import com.example.crudproject.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/w")
@RestController
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping("/wallet")
    public ResponseEntity<?>getWallet(){

        List<Wallet> wallets=walletService.findAll();
        if(!wallets.isEmpty() && wallets.size()>0)
            return ResponseEntity.ok().body(wallets);
        else
            throw new WalletException("Wallet not found",404);
    }
    @GetMapping("/wallet/{mobileno}")
    public ResponseEntity<?>getwalletbymobile(@PathVariable("mobileno")long mobileno)
    {
        Wallet wallet=walletService.findOneWallet(mobileno);
        if(wallet!=null)
            return ResponseEntity.ok().body(wallet);
        else
            throw new WalletException("wallet not found",404);
    }

    @PostMapping("/wallet")
    public ResponseEntity<?>create(@RequestBody Wallet wallet)
    {
        if(wallet.getBalance()<0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try{
            Wallet createWallet=walletService.createWallet(wallet);
            return ResponseEntity.ok().body(wallet);
        }
        catch (WalletException e){
            throw new WalletException("Cannot created",404);}

    }

}
