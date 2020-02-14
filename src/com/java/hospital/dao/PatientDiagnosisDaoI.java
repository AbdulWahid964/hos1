package com.java.hospital.dao;

import java.text.ParseException;
import java.util.List;

import com.java.hospital.model.Patient;
import com.java.hospital.model.PatientDiagnosis;

public interface PatientDiagnosisDaoI {

	
	int savePatientDiagnosis(PatientDiagnosis patientDiagnosis) throws ParseException;
	List<Patient> listOfPatients();
}
