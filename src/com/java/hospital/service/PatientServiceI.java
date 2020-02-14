package com.java.hospital.service;

import java.text.ParseException;

import com.java.hospital.model.Patient;


public interface PatientServiceI {

	
	int savePatient(Patient patient) throws ParseException;
	
	
}
