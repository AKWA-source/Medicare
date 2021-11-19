package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="doctor")
@Getter
@Setter
public class Doctor {
	   @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long doctorID;


	    @Column(name="name")
	    private String name;


	    @Column(name="username")
	    private String username;

	    @Column(name="password")
	    private String password;

	   
	    @Column(name="age",nullable = false)
	    private Integer age;
	    
	    @Column(name="contact_no")
	    private Long contact_no;


	    @Column(name="email")
	    private String email;

	    @Column(name="address")
	    private String address;
	    
	    @Column(name="department")
	    private String department;
	    
	    @Column(name="specialization")
	    private String specialization;

	    @Column(name="active")
	    private Boolean active;

}
