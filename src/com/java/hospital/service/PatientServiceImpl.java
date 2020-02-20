package com.java.hospital.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.java.hospital.dao.PatientDaoI;
import com.java.hospital.model.Patient;

@Service
@Component
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
	public void savePatient(Patient patient) throws ParseException {
		patientDaoI.savePatient(patient);
	}
	@Override
	public List<Patient> getAllPatients() throws ParseException {

		List<Patient> patientList=patientDaoI.getAllPatients();
		return patientList;
	}
	@Override
	public Patient getPatient(int patientId) {
		Patient patient= patientDaoI.getPatient(patientId);
		return patient;
	}
	@Override
	public void updatePatient(Patient patient) {
		patientDaoI.updatePatient(patient);		
	}
	@Override
	public void deletePatient(int patientId) {

		patientDaoI.deletePatient(patientId);
		
	}
	@Override
	public Patient patientIdAutoComplete() {
		
		Patient patient =patientDaoI.patientAutoComplete();
		return patient;
	}

	@Override
	public List<Patient> viewPatientHistory() {
		List<Patient> viewPatientHistoryList=patientDaoI.viewPatientHistory();
		return viewPatientHistoryList;
	}

}
