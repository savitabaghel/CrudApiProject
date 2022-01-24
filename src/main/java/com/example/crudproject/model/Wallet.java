package com.example.crudproject.model;


import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="wallet")
public class Wallet {

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @NotNull
    @Column(name="Balance",nullable = false)
    public double balance;

    @UpdateTimestamp
    private Timestamp Last_update;

    @OneToMany(mappedBy = "wallet",cascade =CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Transaction>transaction;

   @NotNull
    @Column(name = "MobileNumber",unique = true)
    private long mobileno;


}
