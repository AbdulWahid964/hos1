package com.java.hospital.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.hospital.model.Patient;
import com.java.hospital.model.PatientDiagnosis;
import com.java.hospital.service.PatientDiagnosisServiceI;


@Controller
@RequestMapping("/patientdiagnosis")
public class PatientDiagnosisController {
	
	
	@Autowired(required=true)
	private PatientDiagnosisServiceI patientDiagnosisServiceI;

	
	public PatientDiagnosisServiceI getPatientDiagnosisServiceI() {
		return patientDiagnosisServiceI;
	}

	public void setPatientDiagnosisServiceI(PatientDiagnosisServiceI patientDiagnosisServiceI) {
		this.patientDiagnosisServiceI = patientDiagnosisServiceI;
	}

	@RequestMapping("/showPatientDiagnosis")
	public String showPatientDiagnosis(Model model){
		
		List<Patient> patientlist = patientDiagnosisServiceI.listOfPatients();                    // All list of Book
		
		System.out.println("showPatientDiagnosis");
		model.addAttribute("patientlist",patientlist);
		model.addAttribute("patientDiagnosis", new PatientDiagnosis());
		return "patient_diagnosis";
	}
	
	@RequestMapping("/savePatientDiagnosis")
	public String savePatient(@ModelAttribute("patientDiagnosis") PatientDiagnosis patientDiagnosis, Model model) throws ParseException{

		System.out.println("savePatientDiagnosis");
		int patientDiagnosisId=patientDiagnosisServiceI.savePatientDiagnosis(patientDiagnosis);

		return "home";

	}
	
}



