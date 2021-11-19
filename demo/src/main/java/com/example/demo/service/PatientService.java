package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Patient;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;


@Service
public class PatientService {
	
	@Autowired
	FireBaseInitializer db;
	
	private static final String Collection_Name = "patient_table";
	
	public String savePatientDetails(Patient patient) throws InterruptedException, ExecutionException {
		
		Firestore dbFireStore = db.getFireBase();
		
		CollectionReference patientcr1= dbFireStore.collection(Collection_Name);
		ApiFuture<WriteResult> capi = patientcr1.document(patient.getName()).set(patient);
		return capi.get().getUpdateTime().toString();
		
	}
	
	public Patient getPatientByName(String name) throws InterruptedException, ExecutionException {
		
		Patient patient = null;
		
		
      Firestore dbFireStore = db.getFireBase();
		
		CollectionReference patientcr2= dbFireStore.collection(Collection_Name);
	
		ApiFuture<DocumentSnapshot> querysnapshot = patientcr2.document(name).get();
		
		DocumentSnapshot ds = querysnapshot.get();
		if(ds.exists()) {
			patient=ds.toObject(Patient.class);
		return patient;
		}
		else {
			System.out.println("no document found");
			return null;
		}
		
		
		
	}
	
	public String updatePatientDetails(Patient patient) throws InterruptedException, ExecutionException {
		
		Firestore dbFireStore = db.getFireBase();
		
		CollectionReference patientcr3= dbFireStore.collection(Collection_Name);
		ApiFuture<WriteResult> capi = patientcr3.document(patient.getName()).set(patient);
		return capi.get().getUpdateTime().toString();
	}
	
public String deletePatientDetails(String name) throws InterruptedException, ExecutionException {
		
		Firestore dbFireStore = db.getFireBase();
		
		CollectionReference patientcr4= dbFireStore.collection(Collection_Name);
		ApiFuture<WriteResult> capi = patientcr4.document(name).delete();
		return "Patient Id with name:"+ name +" deleted successfully";
	}

public Map<String,Object> getPatients() throws InterruptedException, ExecutionException {
	
	Map<String,Object> patientMap = new HashMap<String,Object>();
	int i=0;
	
	
Firestore dbFireStore = db.getFireBase();
	
CollectionReference patientcr5= dbFireStore.collection(Collection_Name);
	
	
//	CollectionReference admincr2= dbFireStore.collection(Collection_Name).ge
	Iterable<DocumentReference> docref = patientcr5.listDocuments();
	Iterator<DocumentReference>  itr = docref.iterator();
	
	while(itr.hasNext()) {
		i++;
		DocumentReference dr1 =itr.next();
		ApiFuture<DocumentSnapshot> future = dr1.get();
		DocumentSnapshot document = future.get();
		
		Patient patient = document.toObject(Patient.class);
		patientMap.put("Patient"+i, patient);
		//patientList.add(patient);
	}
	
	
	return patientMap;
}

	public boolean isPatientExistsByUserName(String username, String password,String name) throws InterruptedException, ExecutionException {
		Firestore dbFireStore = db.getFireBase();
		Patient patient = null;
		boolean b = false;
		
		CollectionReference patientcr6= dbFireStore.collection(Collection_Name);
		
	ApiFuture<DocumentSnapshot> querysnapshot = patientcr6.document(name).get();
		
		DocumentSnapshot ds = querysnapshot.get();
		if(ds.exists()) {
			patient=ds.toObject(Patient.class);
		}
		else {
			System.out.println("no document found");
		}
		
		if(patient.getUsername().equals(username)) {
			if(patient.getPassword().equals(password))
				b=true;
		}
		else {
		   b=false;
		}
		return b;
		
	}
	
	public Long findByUserName(String username,String name) throws InterruptedException, ExecutionException {
		Firestore dbFireStore = db.getFireBase();
		Patient patient = null;
		Long ID=null;
		
		CollectionReference patientcr6= dbFireStore.collection(Collection_Name);
		
	ApiFuture<DocumentSnapshot> querysnapshot = patientcr6.document(name).get();
		
		DocumentSnapshot ds = querysnapshot.get();
		if(ds.exists()) {
			patient=ds.toObject(Patient.class);
		}
		else {
			System.out.println("no document found");
		}
		
		if(patient.getUsername().equals(username)) {
				ID=patient.getPatientID();
		}
		
		return ID;
	}
	
	public void updatePatientActiveStatus(Map<String,Object> patientObj,boolean status){
		
		Firestore dbFireStore = db.getFireBase();
		Patient patient = null;
		patientObj.put("active", status);
		String name = (String) patientObj.get("name");
	
		
		CollectionReference patientcr6= dbFireStore.collection(Collection_Name);
		
	ApiFuture<WriteResult> querysnapshot = patientcr6.document(name).update(patientObj);
		
	
		
	}

}
