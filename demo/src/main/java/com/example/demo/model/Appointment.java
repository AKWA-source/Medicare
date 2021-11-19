package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="appointment")
@Getter
@Setter
public class Appointment extends Patient {
	
	Appointment(){
	
	}
	
	  @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long appointmentID;


	    @Column(name="doctorSelected")
	    private String doctorSelected;
	    
	    @Column(name="appointmentDate")
	    private Date appointmentDate;
	    
	    @Column(name="department")
	    private String department;
	    
	    @Column(name="time")
	    private Time time;
	    
	    @Column(name="contact_no")
	    private Long contact_no;


	    @Column(name="email")
	    private String email;
	    
	    public Appointment(String doctorSelected,Date appointmentDate,String department,Time time,Long contact_no,String email) {
	    	
	    	this.appointmentDate=appointmentDate;
	    	this.doctorSelected=doctorSelected;
	    	this.department=department;
	    	this.contact_no=contact_no;
	    	this.email=email;
	    	this.time=time;
	    	
	    }
	    
	    
	
	

}
