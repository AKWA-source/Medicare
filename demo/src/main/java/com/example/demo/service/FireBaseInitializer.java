package com.example.demo.service;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FireBaseInitializer {
	
	@PostConstruct
	private void initialize() {

		   try {
	            FileInputStream serviceAccount =
	                    new FileInputStream("./serviceAccountKey.json");

	            FirebaseOptions options = new FirebaseOptions.Builder()
	            		  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
	            		  .setDatabaseUrl("https://fir-medicare-default-rtdb.firebaseio.com")
	            		  .build();
                if(FirebaseApp.getApps().isEmpty())
	            FirebaseApp.initializeApp(options);
	        } catch (Exception e) {
	            e.printStackTrace();

                   }
	         }
	
	public Firestore getFireBase() {
		return FirestoreClient.getFirestore();
	}
}
	
