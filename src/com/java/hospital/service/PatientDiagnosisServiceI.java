package com.java.hospital.service;

import java.text.ParseException;
import java.util.List;

import com.java.hospital.model.Patient;
import com.java.hospital.model.PatientDiagnosis;

public interface PatientDiagnosisServiceI {

	void savePatientDiagnosis(PatientDiagnosis patientDiagnosis) throws ParseException;
	List<Patient> listOfPatients();
	List<PatientDiagnosis> getAllPatientDiagnosiss();
	PatientDiagnosis getPatientDiagnosis(int patientDiagnosisId);
	void updatePatientDiagnosis(PatientDiagnosis patientDiagnosis);
	void deletePatientDiagnosis(int patientDiagnosisId);
	PatientDiagnosis patientDiagnosisAutoComplete();
}
