package com.example.demo.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {
    @Bean
    public FirebaseApp firebaseApp() throws IOException{
        FileInputStream serviceAccount = new FileInputStream("C:\\Users\\boran\\OneDrive\\Masaüstü\\demo\\serviceAccountKey.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://feat-a0cdd-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);

        return FirebaseApp.initializeApp(options);
    }

    @Bean
    public Firestore firestore() {
        return FirestoreClient.getFirestore();
    }
}
