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
@Table(name="treatment")
@Getter
@Setter
public class Treatment {
	
	  @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long treatmentID;


	    @Column(name="referredDoctorName")
	    private String referredDoctorName;
	    
	    @Column(name="referredDetails")
	    private String referredDetails;
	    
	    @Column(name="doctorApproval")
	    private Boolean doctorApproval;
	    
	    @Column(name="assessment")
	    private String assessment;
	    
		

}
