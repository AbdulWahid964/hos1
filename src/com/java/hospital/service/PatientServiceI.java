package com.java.hospital.service;

import java.text.ParseException;
import java.util.List;

import com.java.hospital.model.Patient;


public interface PatientServiceI {

	
	void savePatient(Patient patient) throws ParseException;
	List<Patient> getAllPatients() throws ParseException;
	Patient getPatient(int patientId);
	void updatePatient(Patient patient);
	void deletePatient(int patientId);
	Patient patientIdAutoComplete();
	List<Patient> viewPatientHistory();
}
