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

import com.example.demo.model.Admin;
import com.example.demo.model.Patient;
import com.example.demo.service.AdminService;
import com.example.demo.service.FireBaseInitializer;
import com.example.demo.service.PatientService;

@RestController
@RequestMapping("/Patient")
public class PatientController {
	
	@Autowired
	FireBaseInitializer db;
	
	@Autowired
	private PatientService patientservice;
	

	@GetMapping("/getPatientDetails/{name}")
	public Patient getPatient(@PathVariable String name) throws InterruptedException, ExecutionException {
		return patientservice.getPatientByName(name);
	}
	
	@GetMapping("/getPatients")
	public Map<String,Object> getAllPatients() throws InterruptedException, ExecutionException {
		
		return patientservice.getPatients();
	}
	
	@PostMapping("/savePatientDetails")
	public String savePatient(@RequestBody Patient patient1) throws InterruptedException, Exception {
		return patientservice.savePatientDetails(patient1);
	}
	
	@PutMapping("/updatePatient")
	public String updatePatient(@RequestBody Patient patient2) throws InterruptedException, Exception {
		return patientservice.updatePatientDetails(patient2);
	}
	
	@DeleteMapping("/deletePatient/{name}")
	public String deletePatient(@PathVariable String name) throws InterruptedException, Exception {
		return patientservice.deletePatientDetails(name);
	}
}
