package com.java.hospital.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hospital.dao.PatientDaoI;
import com.java.hospital.model.Patient;

@Service
public class PatientServiceImpl implements PatientServiceI {

	
	@Autowired
	private PatientDaoI  patientDaoI;
	
	
	public PatientDaoI getPatientDaoI() {
		return patientDaoI;
	}


	public void setPatientDaoI(PatientDaoI patientDaoI) {
		this.patientDaoI = patientDaoI;
	}


	@Override
	public int savePatient(Patient patient) throws ParseException {

		patientDaoI.savePatient(patient);
		
		return 0;
	}

}
