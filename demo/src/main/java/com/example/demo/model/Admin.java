package com.example.demo.model;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="admin")
@Getter
@Setter
public class Admin {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long adminID;


    @Column(name="name")
    private String name;


    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    //    @Column(nullable = false)
    @Column(name="age")
    private Integer age;
    
    @Column(name="contact_no")
    private Integer contact_no;


    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="active")
    private Boolean active;

}
