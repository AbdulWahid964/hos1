package com.java.hospital.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.java.hospital.dao.PatientDiagnosisDaoI;
import com.java.hospital.model.Patient;
import com.java.hospital.model.PatientDiagnosis;

@Service
@Component
public class PatientDiagnosisServiceImpl implements PatientDiagnosisServiceI{

	
	@Autowired
	private PatientDiagnosisDaoI  patientDiagnosisDaoI;
	
	public PatientDiagnosisDaoI getPatientDiagnosisDaoI() {
		return patientDiagnosisDaoI;
	}
	public void setPatientDiagnosisDaoI(PatientDiagnosisDaoI patientDiagnosisDaoI) {
		this.patientDiagnosisDaoI = patientDiagnosisDaoI;
	}
	@Override
	public int savePatientDiagnosis(PatientDiagnosis patientDiagnosis) throws ParseException {
		
		patientDiagnosisDaoI.savePatientDiagnosis(patientDiagnosis);
	
		return 0;
	}
	@Override
	public List<Patient> listOfPatients() {
		
		List<Patient> patientlist=patientDiagnosisDaoI.listOfPatients();
		
		return patientlist;
	}
}
