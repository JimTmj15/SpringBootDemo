package com.jimmy.demorest;

import com.jimmy.demorest.jpa.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulApiApplication {

	@Autowired
	private WeatherRepository weatherRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestfulApiApplication.class, args);
	}
}
