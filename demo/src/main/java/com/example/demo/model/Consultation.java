package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="consultation")
@Getter
@Setter
public class Consultation {
	
	  @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long sessionID;

	  @Column(name="noofsessions")
	    private int noofsessions;

	    @Column(name="doctorSelected")
	    private String doctorSelected;
	    
	    @Column(name="consultationDate")
	    private Date consultationDate;
	    
	    @Column(name="healthissue")
	    private String healthissue;
	    
	    @Column(name="testsuggested")
	    private String testsuggested;

}
