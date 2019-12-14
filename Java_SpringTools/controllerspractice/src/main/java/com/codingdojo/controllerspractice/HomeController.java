package com.codingdojo.controllerspractice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
 public class HomeController {
	public static void main(String[] args) {
		SpringApplication.run(HomeController.class, args);
	}
	@RequestMapping("/")
	public String yello() {
		return "YERRRRR, hello!";
	}
}