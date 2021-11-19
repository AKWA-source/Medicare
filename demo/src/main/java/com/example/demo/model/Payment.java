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
@Table(name="payment")
@Getter
@Setter
public class Payment {
	
	  @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long transactionID;


	    @Column(name="totalbill")
	    private Long totalbill;

}
