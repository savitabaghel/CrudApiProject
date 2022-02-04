package com.example.crudproject.model;


import com.sun.istack.NotNull;
import lombok.*;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")

public class user {



    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "UpdateDate")
    private Date Udate;

    @Column(name="createDate")
    private Date Cdate;







}
