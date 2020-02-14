package com.java.hospital.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.hospital.model.Patient;
import com.java.hospital.service.PatientServiceI;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired(required=true)
	private PatientServiceI patientServiceI;
	
	@RequestMapping("/showPatient.html")
	public String showPatient(Model model){
		model.addAttribute("patient", new Patient());
		return "enroll_patient";
	}
	@RequestMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient patient, Model model) throws ParseException{
		
		int patientId=patientServiceI.savePatient(patient);
		
		return "home";
	}
	
}
