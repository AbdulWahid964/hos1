package com.java.hospital.dao;

import java.text.ParseException;

import com.java.hospital.model.Patient;


public interface PatientDaoI {

	int savePatient(Patient patient) throws ParseException;
	
}
