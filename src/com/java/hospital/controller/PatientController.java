package com.java.hospital.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.hospital.model.Patient;
import com.java.hospital.service.PatientServiceI;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired(required=true)
	private PatientServiceI patientServiceI;
	
	public PatientServiceI getPatientServiceI() {
		return patientServiceI;
	}
	public void setPatientServiceI(PatientServiceI patientServiceI) {
		this.patientServiceI = patientServiceI;
	}
	@RequestMapping("/showPatient")
	public String showPatient(Model model){
		model.addAttribute("patient", new Patient());
		return "enroll_patient";
	}
	@RequestMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient patient, Model model) throws ParseException{

		patientServiceI.savePatient(patient);

		//model.addAttribute("patient", patientObj);

		return "view_patient";
	}
	@RequestMapping("/viewPatient")
	public String viewPatient(Model model) throws ParseException{

		List<Patient> patientList=patientServiceI.getAllPatients();

		model.addAttribute("patientList",patientList);

		return "view_patient";
	}

	@RequestMapping("/getPatient/{id}")
	public String getPatient(@PathVariable("id") int patientId,Model model) throws ParseException{

		System.out.println("patientId" +patientId);
		Patient patient =patientServiceI.getPatient(patientId);
		
		model.addAttribute("patient",patient);

		return "update_patient";
	}
	
	@RequestMapping("/updatePatient")
	public String updatePatient(@ModelAttribute("patient") Patient patient, Model model) throws ParseException{

		patientServiceI.updatePatient(patient);

		//model.addAttribute("patient", patientObj);

		return "redirect:/patient/viewPatient";
	}
	@RequestMapping("/deletePatient/{id}")
	public String deletePatient(@PathVariable("id") int patientId) throws ParseException{

		System.out.println("patientId" +patientId);
		patientServiceI.deletePatient(patientId);

		return "redirect:/patient/viewPatient";
	}
	
}
