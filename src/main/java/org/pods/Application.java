package org.pods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Startup class for the application.
 * 
 * @author gabi
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}