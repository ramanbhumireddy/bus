package com.coder.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api")
@RestController
@SpringBootApplication
public class BusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusApplication.class, args);
	}

	@GetMapping(value = "/")
	public String welcome(){
		return "welcome -" + System.currentTimeMillis();
	}

}
