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
@Table(name="medicinal")
@Getter
@Setter
public class Medicinal {
	  @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long medicineID;


	    @Column(name="medicineName")
	    private String medicineName;
	    
	    @Column(name="issueDate")
	    private Date issueDate;
	    
	    @Column(name="dosage")
	    private String dosage;
	    
	    @Column(name="instructions")
	    private String instructions;
	    
	    @Column(name="description")
	    private String description;
}
