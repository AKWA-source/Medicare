package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

@Service
public class AdminService {
	
	@Autowired
	FireBaseInitializer db;
	
	private static final String Collection_Name = "admin_table";
	
	public String saveAdminDetails(Admin admin) throws InterruptedException, ExecutionException {
		
		Firestore dbFireStore = db.getFireBase();
		
		CollectionReference admincr1= dbFireStore.collection(Collection_Name);
		ApiFuture<WriteResult> capi = admincr1.document(admin.getName()).set(admin);
		return capi.get().getUpdateTime().toString();
		
	}
	
	public Admin getAdminByName(String name) throws InterruptedException, ExecutionException {
		
		Admin adm = null;
		
		
      Firestore dbFireStore = db.getFireBase();
		
		CollectionReference admincr2= dbFireStore.collection(Collection_Name);
	
		ApiFuture<DocumentSnapshot> querysnapshot = admincr2.document(name).get();
		
		DocumentSnapshot ds = querysnapshot.get();
		if(ds.exists()) {
			adm=ds.toObject(Admin.class);
		return adm;
		}
		else {
			System.out.println("no document found");
			return null;
		}
		
	}
	
	public String updateAdminDetails(Admin admin) throws InterruptedException, ExecutionException {
		
		Firestore dbFireStore = db.getFireBase();
		
		CollectionReference admincr1= dbFireStore.collection(Collection_Name);
		ApiFuture<WriteResult> capi = admincr1.document(admin.getName()).set(admin);
		return capi.get().getUpdateTime().toString();
		
		//admincr1.document(String.valueOf(admin.getAge())).set(admin);
		
		//return "Admin age"+ admin.getAge() +" changed";
		
	}
	
public String deleteAdminDetails(String name) throws InterruptedException, ExecutionException {
		
		Firestore dbFireStore = db.getFireBase();
		
		CollectionReference admincr1= dbFireStore.collection(Collection_Name);
		ApiFuture<WriteResult> capi = admincr1.document(name).delete();
		return "Admin Id with name:"+ name +" deleted successfully";
		
		//admincr1.document(String.valueOf(admin.getAge())).set(admin);
		
		//return "Admin age"+ admin.getAge() +" changed";
		
	}

public List<Admin> getAdmin() throws InterruptedException, ExecutionException {
	
	List<Admin> admList = new ArrayList<>();
	
	
	
Firestore dbFireStore = db.getFireBase();
	
CollectionReference admincr2= dbFireStore.collection(Collection_Name);
	
	
//	CollectionReference admincr2= dbFireStore.collection(Collection_Name).ge
	Iterable<DocumentReference> docref = admincr2.listDocuments();
	Iterator<DocumentReference>  itr = docref.iterator();
	
	while(itr.hasNext()) {
		DocumentReference dr1 =itr.next();
		ApiFuture<DocumentSnapshot> future = dr1.get();
		DocumentSnapshot document = future.get();
		
		Admin admin = document.toObject(Admin.class);
				admList.add(admin);
	}
	
	return admList;
}
	

}
