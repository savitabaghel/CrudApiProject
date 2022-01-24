package com.example.crudproject.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@Entity
@Table(name = "process_type")
public class Type {
    @Id
    @NotNull
    @Column(name="id",unique = true)
    @GeneratedValue()
    private int id;


    @Column(name="descriptioon")
    private String description;

    public Type(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Type() {
    }
}
