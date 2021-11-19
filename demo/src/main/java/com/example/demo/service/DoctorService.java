package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

@Service
public class DoctorService {
	
	@Autowired
	FireBaseInitializer db;
	
	private static final String Collection_Name = "doctor_table";
	
	public String saveDoctorDetails(Doctor doctor) throws InterruptedException, ExecutionException {
		
		Firestore dbFireStore = db.getFireBase();
		
		CollectionReference doctorcr1= dbFireStore.collection(Collection_Name);
		ApiFuture<WriteResult> capi = doctorcr1.document(doctor.getName()).set(doctor);
		return capi.get().getUpdateTime().toString();
		
	}
	
	public Doctor getDoctorByName(String name) throws InterruptedException, ExecutionException {
		
		Doctor doctor = null;
		
		
      Firestore dbFireStore = db.getFireBase();
		
		CollectionReference doctorcr2= dbFireStore.collection(Collection_Name);
	
		ApiFuture<DocumentSnapshot> querysnapshot = doctorcr2.document(name).get();
		
		DocumentSnapshot ds = querysnapshot.get();
		if(ds.exists()) {
			doctor=ds.toObject(Doctor.class);
		return doctor;
		}
		else {
			System.out.println("no document found");
			return null;
		}
		
	}
	
	public String updateDoctorDetails(Doctor doctor) throws InterruptedException, ExecutionException {
		
		Firestore dbFireStore = db.getFireBase();
		
		CollectionReference doctorcr3= dbFireStore.collection(Collection_Name);
		ApiFuture<WriteResult> capi = doctorcr3.document(doctor.getName()).set(doctor);
		return capi.get().getUpdateTime().toString();
	}
	
public String deleteDoctorDetails(String name) throws InterruptedException, ExecutionException {
		
		Firestore dbFireStore = db.getFireBase();
		
		CollectionReference doctorcr4= dbFireStore.collection(Collection_Name);
		ApiFuture<WriteResult> capi = doctorcr4.document(name).delete();
		
		return "Doctor Id with name:"+ name +" deleted successfully";
	}

	public Map<String,Object> getDoctors() throws InterruptedException, ExecutionException {
	
		Map<String,Object> doctorMap = new HashMap<String,Object>();
		int i=0;
	
	
	
		Firestore dbFireStore = db.getFireBase();
	
		CollectionReference doctorcr5= dbFireStore.collection(Collection_Name);

		Iterable<DocumentReference> docref = doctorcr5.listDocuments();
		Iterator<DocumentReference>  itr = docref.iterator();
	
		while(itr.hasNext()) {
			i++;
			DocumentReference dr1 =itr.next();
			ApiFuture<DocumentSnapshot> future = dr1.get();
			DocumentSnapshot document = future.get();
		
			Doctor doctor = document.toObject(Doctor.class);
			doctorMap.put("Doctor_"+i, doctor);
	}
	
		return doctorMap;
}
	

	public boolean isDoctorExistsByUserName(String username, String password,String name) throws InterruptedException, ExecutionException {
		Firestore dbFireStore = db.getFireBase();
		Doctor doctor = null;
		boolean b = false;
		
		CollectionReference doctorcr6= dbFireStore.collection(Collection_Name);
		
	ApiFuture<DocumentSnapshot> querysnapshot = doctorcr6.document(name).get();
		
		DocumentSnapshot ds = querysnapshot.get();
		if(ds.exists()) {
			doctor=ds.toObject(Doctor.class);
		}
		else {
			System.out.println("no document found");
		}
		
		if(doctor.getUsername().equals(username)) {
			if(doctor.getPassword().equals(password))
				b=true;
		}
		else {
		   b=false;
		}
		return b;
		
	}
	
	public Long findByUserName(String username,String name) throws InterruptedException, ExecutionException {
		Firestore dbFireStore = db.getFireBase();
		Doctor doctor = null;
		Long ID=null;
		
		CollectionReference doctorcr7= dbFireStore.collection(Collection_Name);
		
	ApiFuture<DocumentSnapshot> querysnapshot = doctorcr7.document(name).get();
		
		DocumentSnapshot ds = querysnapshot.get();
		if(ds.exists()) {
			doctor=ds.toObject(Doctor.class);
		}
		else {
			System.out.println("no document found");
		}
		
		if(doctor.getUsername().equals(username)) {
				ID=doctor.getDoctorID();
		}
		
		return ID;
	}
	
	public void updateDoctorActiveStatus(Map<String,Object> doctorObj,boolean status){
		
		Firestore dbFireStore = db.getFireBase();
		
		doctorObj.put("active", status);
		String name = (String) doctorObj.get("name");
	
		
		CollectionReference doctorcr7= dbFireStore.collection(Collection_Name);
		
	ApiFuture<WriteResult> querysnapshot = doctorcr7.document(name).update(doctorObj);
		
	
		
	}


}
