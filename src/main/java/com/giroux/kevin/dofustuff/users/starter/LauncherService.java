package com.giroux.kevin.dofustuff.object.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * Copyright notice
 * LauncherService.java
 * Classe principale pour le lancement du micro-service
 * @version v1
 * @author Kévin Giroux
 * 5 septembre 2017
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "com.giroux.kevin.dofustuff.object" })
public class LauncherService {

	/**
	 * Lance l'application spring boot
	 * @param args
	 * @throws Exception
	 */
	public static void main(final String[] args) {
		SpringApplication.run(LauncherService.class, args);
	}
	
}

