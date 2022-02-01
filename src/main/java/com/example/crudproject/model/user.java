package com.example.crudproject.model;


import com.sun.istack.NotNull;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Date;

@Validated
@Entity
@Builder
@Table(name="users")

public class user {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userid")
    private int id;

    @NotBlank(message = "First name is mandatory")
    @Column(name="first_name",length = 25)
    private String firstname;

    @NotBlank(message = "Last name is mandatory")
    @Column(name="last_name",length = 25)
    private String lastname;

    @NotBlank
    @Email
    @Column(name="emailid")
    private String  emailid;

    @NotNull
    @Column(name="mobilen",length = 25,unique = true)
    private  long mobileno;


    @Column(name="address1",length = 40)
    private String address1;


    @Column(name="address2",length = 40)
    private String address2;

    @UpdateTimestamp
    private Timestamp updatedate;

    @CreationTimestamp
    private Timestamp createdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public Timestamp getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Timestamp updatedate) {
        this.updatedate = updatedate;
    }

    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }


    public user(int id, String firstname, String lastname, String emailid, long mobileno, String address1, String address2, Timestamp updatedate, Timestamp createdate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailid = emailid;
        this.mobileno = mobileno;
        this.address1 = address1;
        this.address2 = address2;
        this.updatedate = updatedate;
        this.createdate = createdate;
    }

    public user() {
    }



}
