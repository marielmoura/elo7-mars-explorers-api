package com.elo7.marsexplorerapi;

import com.elo7.marsexplorerapi.model.Planet;
import com.elo7.marsexplorerapi.model.Probe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses={Planet.class, Probe.class})
@EntityScan("com.elo7.marsexplorerapi.model")
@EnableJpaRepositories("com.elo7.marsexplorerapi.repository")
public class MarsExplorerApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(MarsExplorerApiApplication.class, args);
		Planet.mars.drawConsoleSurface();

	}

}

