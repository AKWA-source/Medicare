package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Doctor;

import com.example.demo.service.DoctorService;
import com.example.demo.service.FireBaseInitializer;


@RestController
@RequestMapping("/Doctor")
public class DoctorController {
	
	@Autowired
	FireBaseInitializer db;
	
	@Autowired
	private DoctorService doctorservice;
	
	@GetMapping("/getDoctorDetails/{name}")
	public Doctor getDoctor(@PathVariable String name) throws InterruptedException, ExecutionException {
		return doctorservice.getDoctorByName(name);
	}
	
	@GetMapping("/getDoctors")
	public Map<String,Object> getAllDoctors() throws InterruptedException, ExecutionException {
		
		return doctorservice.getDoctors();
	}
	
	@PostMapping("/saveDoctorDetails")
	public String saveDoctor(@RequestBody Doctor doctor1) throws InterruptedException, Exception {
		return doctorservice.saveDoctorDetails(doctor1);
	}
	
	@PutMapping("/updateDoctor")
	public String updateDoctor(@RequestBody Doctor doctor2) throws InterruptedException, Exception {
		return doctorservice.updateDoctorDetails(doctor2);
	}
	
	@DeleteMapping("/deleteDoctor/{name}")
	public String deleteDoctor(@PathVariable String name) throws InterruptedException, Exception {
		return doctorservice.deleteDoctorDetails(name);
	}

}
