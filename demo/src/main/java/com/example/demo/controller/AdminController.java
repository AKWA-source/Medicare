package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.service.FireBaseInitializer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@RestController
public class AdminController {
	
	@Autowired
	FireBaseInitializer db;
	
	Admin ad;
	

	@GetMapping("/getAdminDetails")
	public List<Admin> getAdminDetails() throws InterruptedException, ExecutionException {
		List<Admin> adlist= new ArrayList<Admin>();
		
		CollectionReference admin = db.getFireBase().collection("admin_table");
		ApiFuture<QuerySnapshot> querysnapshot = admin.get();
		System.out.println(querysnapshot.get().getDocuments());
		
		for(QueryDocumentSnapshot doc :querysnapshot.get().getDocuments()) {
			Admin adm = doc.toObject(Admin.class);
			adlist.add(adm);
			
		}
		
		return adlist;
	}

}
