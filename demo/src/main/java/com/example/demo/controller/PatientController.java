package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Project")
public class PatientController {

	@GetMapping("/getPatientDetails")
	public String getPatientDetails() {
		return "Hello Waseem";
	}
	
	@PostMapping("/addPatient")
	public String addPatient() {
		return "Hello Waseem";
	}
	
	@PutMapping("/updatePatient")
	public String updatePatient() {
		return "Hello Waseem";
	}
	
	@DeleteMapping(value="/deleteuser")
	public String deleteuser() {
		return "Hello Waseem";
	}
}
