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
@Table(name="recommendation")
@Getter
@Setter
public class Recommendation extends Patient {
	
	  @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long recommendationID;


	    @Column(name="doctorSplz")
	    private String doctorSplz;
	    
	    @Column(name="ratings")
	    private Long ratings;
	    
	
	

}
