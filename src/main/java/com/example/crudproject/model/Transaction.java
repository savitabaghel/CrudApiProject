package com.example.crudproject.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "wallet_transaction")
public class Transaction {

    @Id
    @Column(name = "Transaction_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transaction_id;

    @NotNull
    @Column(name = "amount")
    private double amount;

    @UpdateTimestamp
    private Timestamp last_update;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @NotNull
    @Column(name = "MobileNo",unique = true)
    private long mobileno;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Type type;

    public Transaction( double amount, Wallet wallet, long mobileno, Type type) {
       // this.transaction_id = transaction_id;
        this.amount = amount;
       // this.last_update = last_update;
        this.wallet = wallet;
        this.mobileno = mobileno;
        this.type = type;
    }

    public Transaction() {
    }
}
