package com.florist.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class V1Application {

	public static void main(String[] args) {
		SpringApplication.run(V1Application.class, args);
		System.out.println("Hello World");
		
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Codificar las contraseñas
        String passwordUser = encoder.encode("user123");
        String passwordAdmin = encoder.encode("admin123");

        // Mostrar las contraseñas codificadas
        System.out.println("Usuario USER codificado: " + passwordUser);
        System.out.println("Usuario ADMIN codificado: " + passwordAdmin);
    }


}
