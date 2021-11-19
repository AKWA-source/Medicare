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
@Table(name="diagonosis")
@Getter
@Setter
public class Diagnosis {

	
	  @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long diagonosisID;


	    @Column(name="collectDoctorFeedback")
	    private String collectDoctorFeedback;
	    
	    @Column(name="collectPatientFeedback")
	    private String collectPatientFeedback;
	    
	    @Column(name="reportAnalysis")
	    private String reportAnalysis;
}
