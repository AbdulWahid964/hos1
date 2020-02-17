package com.java.hospital.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
		
		Patient patient=patientServiceI.patientIdAutoComplete();
		
		model.addAttribute("patient", patient);
		
		return "enroll_patient";
	}
	@RequestMapping("/savePatient")
	public String savePatient(@Validated @ModelAttribute("patient") Patient patient,BindingResult bindingResult,Model model) throws ParseException{

		if(bindingResult.hasErrors()) {
			System.out.println("Errors");
			return "enroll_patient";
		}
			patientServiceI.savePatient(patient);
		return "redirect:/patient/viewPatient";
	}
	@RequestMapping("/viewPatient")
	public String viewPatient(Model model) throws ParseException{

		List<Patient> patientList=patientServiceI.getAllPatients();

		model.addAttribute("patientList",patientList);

		patientList=null;
		return "view_patient";
	}

	@RequestMapping("/getPatient/{id}")
	public String getPatient(@PathVariable("id") int patientId,Model model) throws ParseException{

		Patient patient =patientServiceI.getPatient(patientId);
		
		model.addAttribute("patient",patient);

		patient=null;
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
	@RequestMapping("/viewPatientHistory")
	public String viewPatientHistory(Model model) throws ParseException{

		List<Patient> viewPatientHistoryList= patientServiceI.viewPatientHistory();

		
		for(Patient p:viewPatientHistoryList){
			System.out.println(p.getPatientId());
		}
		model.addAttribute("viewPatientHistoryList", viewPatientHistoryList);
		return "view_patient_history";
	}
	
}
