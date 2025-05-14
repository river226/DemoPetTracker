package xyz.jriver.PetTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"xyz.jriver.PetTracker.Entity"})
public class PetTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetTrackerApplication.class, args);
	}

}
