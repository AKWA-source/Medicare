package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Patient;
import com.example.demo.service.AdminService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Login")
public class LoginLogoutController {
	

@Autowired
private PatientService patientservice;

@Autowired
private DoctorService doctorservice;

@Autowired
private AdminService adminservice;


	@Transactional
	@GetMapping(value="/login", params = { "username", "password","name"})
	public String findByUserName(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("name") String name) throws InterruptedException, ExecutionException {
		Long id;
		
		Map<String,Object> patientMap = patientservice.getPatients();
		ObjectMapper mapObjectpatient = new ObjectMapper();
		Object pList = patientMap.get(name);
		Map<String,Object> mpp = mapObjectpatient.convertValue(pList, Map.class);
		
		Map<String,Object> doctorMap = doctorservice.getDoctors();
		ObjectMapper mapObjectdoctor = new ObjectMapper();
		Object dList = doctorMap.get(name);
		Map<String,Object> mpd = mapObjectdoctor.convertValue(dList, Map.class);
		
		
		if(name.contains("Patient")){
			
		if(patientservice.isPatientExistsByUserName(username, password,name)) {
			id = patientservice.findByUserName(username,name);
			patientservice.updatePatientActiveStatus(mpp,true);
			return "/user/" + id + "/home";
		 }
		}
		
		else if (name.contains("Doctor")) {
		
		
		 if(doctorservice.isDoctorExistsByUserName(username, password, name)) {
			id = doctorservice.findByUserName(username, name);
			doctorservice.updateDoctorActiveStatus(mpd, true);
			return "/doctor/" + id + "/home";
		}
		}
		return "Incorrect username or password";
		/*
		if(admin_repository.isAdminExistByUsernameAndPassword(username, password) == 1) {
			id = admin_repository.findByUsername(username);
			admin_repository.updateAdminActiveStatus(true, id);
			return "/admin/" + id + "/home";
		}
		return "Incorrect username or password";
}


	@Transactional
	@PutMapping(value="/logout/user/{id}")
	public String findByUserStatus(@PathVariable long id) {
		if(user_repository.isUserExistByUserID(id) == 1) {
			user_repository.updateUserActiveStatus(false, id);
			return "Logout Successful";
		}
		return "User " + id + " not found";
}


	@Transactional
	@PutMapping(value="/logout/doctor/{id}") //Map ONLY GET Requests and means URL's start with /login/{userName}(after Application path).
	public String findByDoctorStatus(@PathVariable long id) {
		if(doctor_repository.isDoctorExistByDoctorID(id) == 1) {
			doctor_repository.updateDoctorActiveStatus(false, id);
			return "Logout Successful";
		}
		return "Doctor " + id + " not found";
	}


	@Transactional
	@PutMapping(value="/logout/admin/{id}") //Map ONLY GET Requests and means URL's start with /login/{userName}(after Application path).
	public String findByAdminStatus(@PathVariable long id) {
		if(admin_repository.isAdminExistByAdminID(id) == 1) {
			admin_repository.updateAdminActiveStatus(false, id);
			return "Logout Successful";
		}
		return "Admin " + id + " not found";
	}


	@Transactional
	@PutMapping(value="/changepassword/{role}/{id}", params = { "current_password", "new_password"})
	public String findByUserName(@PathVariable("role") String role, @PathVariable("id") long id, @RequestParam("current_password") String current_password, @RequestParam("new_password") String new_password) {
		switch (role) {
		case "admin":
			if (admin_repository.isAdminExistByAdminIDAndPassword(id, current_password) == 1) {
					admin_repository.updateAdminPassword(new_password, id);
					return "Password Updated Successfully";
			} else {
					return "Invalid Old Password";
			}
		case "doctor":
			if (doctor_repository.isDoctorExistByDoctorIDAndPassword(id, current_password) == 1) {
				doctor_repository.updateDoctorPassword(new_password, id);
				return "Password Updated Successfully";
			} else {
				return "Invalid Old Password";
			}
		case "user":
			if (user_repository.isUserExistByUserIDAndPassword(id, current_password) == 1) {
				user_repository.updateUserPassword(new_password, id);
				return "Password Updated Successfully";
			} else {
				return "Invalid Old Password";
			}
		default:
			return "Role not found";
		}
}

}*/
		

}
}
