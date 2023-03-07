package com.markcode.app.empleadoscrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.markcode.app.empleadoscrud")
public class EmpleadosCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpleadosCrudApplication.class, args);
	}

}
