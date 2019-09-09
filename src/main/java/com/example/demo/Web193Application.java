package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class Web193Application {

	@RequestMapping("/")
	public String getUtama() {
		String page = "utama";
		return page;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Web193Application.class, args);
	}

}
