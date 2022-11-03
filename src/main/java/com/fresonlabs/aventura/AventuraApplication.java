package com.fresonlabs.aventura;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.fresonlabs.aventura.config")
public class AventuraApplication {


	public static void main(String[] args) throws IOException {
		ClassLoader classLoader = AventuraApplication.class.getClassLoader();
		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccount.json")).getFile());

		FileInputStream serviceAccount =
				new FileInputStream(file.getAbsolutePath());

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();

		FirebaseApp.initializeApp(options);
		SpringApplication.run(AventuraApplication.class, args);
	}

}
