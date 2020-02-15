package com.java.hospital.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.hospital.model.Physician;
import com.java.hospital.service.PhysicianServiceI;

@Controller
@RequestMapping("/physician")
public class PhysicianController {
	
	@Autowired
	PhysicianServiceI physicianServiceI;
	
	public PhysicianServiceI getPhysicianServiceI() {
		return physicianServiceI;
	}
	public void setPhysicianServiceI(PhysicianServiceI physicianServiceI) {
		this.physicianServiceI = physicianServiceI;
	}
	@RequestMapping("/showPhysician")
	public String addPhysician(Model model){
		model.addAttribute("physician", new Physician());
		return "enroll_physician";
	}
	@RequestMapping("/savePhysician")
	public String savePatient(@ModelAttribute("physician") Physician physician, Model model) throws ParseException{
		
		physicianServiceI.savePhysician(physician);
		return "home";
	}
	
}
