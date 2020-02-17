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
		
		List<Patient> patientlist = patientDiagnosisServiceI.listOfPatients(); 
		
		PatientDiagnosis patientDiagnosis=patientDiagnosisServiceI.patientDiagnosisAutoComplete();
		
		model.addAttribute("patientDiagnosis", patientDiagnosis);
	
		model.addAttribute("patientlist",patientlist);

		patientlist=null;
		patientDiagnosis=null;
		return "patient_diagnosis";
	}
	
	@RequestMapping("/savePatientDiagnosis")
	public String savePatient(@Validated @ModelAttribute("patientDiagnosis") PatientDiagnosis patientDiagnosis, BindingResult bindingResult, Model model) throws ParseException{

		System.out.println("savePatientDiagnosis");
		if(bindingResult.hasErrors()) {
			List<Patient> patientlist = patientDiagnosisServiceI.listOfPatients();                    // All list of Book
			model.addAttribute("patientlist",patientlist);
			return "patient_diagnosis";
		}
		patientDiagnosisServiceI.savePatientDiagnosis(patientDiagnosis);

		return "redirect:/patientdiagnosis/viewPatientDiagnosis";
	}
	@RequestMapping("/viewPatientDiagnosis")
	public String viewPatientDiagnosis(Model model) throws ParseException{

		List<PatientDiagnosis> patientDiagnosisList=patientDiagnosisServiceI.getAllPatientDiagnosiss();

		model.addAttribute("patientDiagnosisList",patientDiagnosisList);

		patientDiagnosisList=null;
		
		return "view_patient_diagnosis";
	}

	@RequestMapping("/getPatientDiagnosis/{id}")
	public String getPatientDiagnosis(@PathVariable("id") int patientDiagnosisId,Model model) throws ParseException{

		PatientDiagnosis patientDiagnosis =patientDiagnosisServiceI.getPatientDiagnosis(patientDiagnosisId);
		
		List<Patient> patientlist= patientDiagnosisServiceI.listOfPatients();
		
		
		for(Patient p: patientlist){
			System.out.println("Id" +p.getPatientId());
		}
		model.addAttribute("patientList",patientlist);
		model.addAttribute("patientDiagnosis",patientDiagnosis);

		patientlist=null;
		patientDiagnosis=null;
		
		return "update_patient_diagnosis";
	}
	
	@RequestMapping("/updatePatientDiagnosis")
	public String updatePatientDiagnosis(@ModelAttribute("PatientDiagnosis") PatientDiagnosis patientDiagnosis, Model model) throws ParseException{

		patientDiagnosisServiceI.updatePatientDiagnosis(patientDiagnosis);

		return "redirect:/patientdiagnosis/viewPatientDiagnosis";		
	}
	@RequestMapping("/deletePatientDiagnosis/{id}")
	public String deletePatientDiagnosis(@PathVariable("id") int patientDiagnosisId) throws ParseException{

		patientDiagnosisServiceI.deletePatientDiagnosis(patientDiagnosisId);

		return "redirect:/patientdiagnosis/viewPatientDiagnosis";
	}

	
	
	
}



