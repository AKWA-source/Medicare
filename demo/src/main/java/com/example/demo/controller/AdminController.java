package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import com.example.demo.service.FireBaseInitializer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	FireBaseInitializer db;
	
	@Autowired
	private AdminService adminservice;
	
	Admin ad;
	
	

	@GetMapping("/getAdminDetails/{name}")
	public Admin getAdmin(@PathVariable String name) throws InterruptedException, ExecutionException {
		
		
		//CollectionReference admin = db.getFireBase().collection("admin_table");
		//ApiFuture<QuerySnapshot> querysnapshot = admin.get();
		//System.out.println(querysnapshot.get().getDocuments());
		
		//for(QueryDocumentSnapshot doc :querysnapshot.get().getDocuments()) {
		//	Admin adm = doc.toObject(Admin.class);
		//	adlist.add(adm);
			
		//}
		
		//return adlist;
		
		return adminservice.getAdminByName(name);
		
	}
	@GetMapping("/getAdmins")
	public List<Admin> getAllAdmins() throws InterruptedException, ExecutionException {
		
		return adminservice.getAdmin();
	}
	
	@PostMapping("/saveAdminDetails")
	public String saveAdmin(@RequestBody Admin admin1) throws Exception, ExecutionException {
		
	return adminservice.saveAdminDetails(admin1);
	}
	
	@PutMapping("/updateAdminDetails")
	public String updateAdmin(@RequestBody Admin admin2) throws InterruptedException, Exception {
		
		/*
		 * CollectionReference admincrr = db.getFireBase().collection("admin_table");
		 * admincrr.document(String.valueOf(admin2.getAdminID())).set(admin2);
		 * admincrr.document(String.valueOf(admin2.getName())).set(admin2);
		 * admincrr.document(String.valueOf(admin2.getUsername())).set(admin2);
		 * admincrr.document(String.valueOf(admin2.getPassword())).set(admin2);
		 * admincrr.document(String.valueOf(admin2.getAge())).set(admin2);
		 * admincrr.document(String.valueOf(admin2.getContact_no())).set(admin2);
		 * admincrr.document(String.valueOf(admin2.getEmail())).set(admin2);
		 * admincrr.document(String.valueOf(admin2.getAddress())).set(admin2);
		 * admincrr.document(String.valueOf(admin2.getActive())).set(admin2); return
		 * "Admin details"+ admin2.getAdminID() +" updated";
		 */
		
		return adminservice.updateAdminDetails(admin2);
	}
	
	@DeleteMapping("/deleteAdmin/{name}")
	public String deleteAdmin(@PathVariable String name) throws InterruptedException, Exception {
	
		return adminservice.deleteAdminDetails(name);
	}	
	
}
