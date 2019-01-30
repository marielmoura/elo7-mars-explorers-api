package com.elo7.marsexplorerapi;

import com.elo7.marsexplorerapi.repository.PlanetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarsExplorerApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(MarsExplorerApiApplication.class, args);
		PlanetRepository.mars.draw();

	}

}

