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
@Table(name="prescription")
@Getter
@Setter
public class Prescription {
	
	  @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long prescriptionID;


	    @Column(name="prescriptionType")
	    private String prescriptionType;
	    
	    @Column(name="severity")
	    private String severity;
	    
	    

}
