package com.java.hospital.dao;

import java.text.ParseException;
import java.util.List;

import com.java.hospital.model.Patient;


public interface PatientDaoI {

	void savePatient(Patient patient) throws ParseException;
	List<Patient> getAllPatients();
	Patient getPatient(int patientId);
	void updatePatient(Patient patient);
	void deletePatient(int patientId);
	Patient patientAutoComplete();
	List<Patient> viewPatientHistory();
} 
