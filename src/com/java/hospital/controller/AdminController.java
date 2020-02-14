package com.java.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AdminController {
	

	@RequestMapping("/showHome")
	public String showHome(){
		System.out.println("Admin");
		return "home";
	}
	
}
