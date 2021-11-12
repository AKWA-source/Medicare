package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
	
	@GetMapping("/getDoctorDetails")
	public String getDoctorDetails() {
		return "Hello Doctor";
	}
}
