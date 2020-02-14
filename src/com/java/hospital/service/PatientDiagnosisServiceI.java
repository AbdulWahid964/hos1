package com.java.hospital.service;

import java.text.ParseException;
import java.util.List;

import com.java.hospital.model.Patient;
import com.java.hospital.model.PatientDiagnosis;

public interface PatientDiagnosisServiceI {

	int savePatientDiagnosis(PatientDiagnosis patientDiagnosis) throws ParseException;
	List<Patient> listOfPatients();
}
