package com.example.java_server;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

public class FirebaseInitializer {
    private static final Logger logger = Logger.getLogger(FirebaseInitializer.class.getName());

    public static void init() {
        try {
            // Check if Firebase is already initialized
            List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
            if (!firebaseApps.isEmpty()) {
                logger.info("Firebase already initialized");
                return;
            }

            // Try to load from classpath first (more reliable in different environments)
            InputStream serviceAccount = FirebaseInitializer.class.getClassLoader()
                .getResourceAsStream("service-account.json");
            
            // Fall back to file system if not found in classpath
            if (serviceAccount == null) {
                logger.info("Loading service account from file system");
                serviceAccount = new FileInputStream("src/main/resources/service-account.json");
            }

            FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

            FirebaseApp.initializeApp(options);
            logger.info("Firebase initialized successfully");
        } catch (IOException e) {
            logger.severe("Error initializing Firebase: " + e.getMessage());
            throw new RuntimeException("Failed to initialize Firebase", e);
        }
    }
}