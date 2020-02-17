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
	public void savePatientDiagnosis(PatientDiagnosis patientDiagnosis) throws ParseException {
		
		patientDiagnosisDaoI.savePatientDiagnosis(patientDiagnosis);
	
	}
	@Override
	public List<Patient> listOfPatients() {
		
		List<Patient> patientlist=patientDiagnosisDaoI.listOfPatients();
		
		return patientlist;
	}
	@Override
	public List<PatientDiagnosis> getAllPatientDiagnosiss() {

		List<PatientDiagnosis> patientDiagnosisList=patientDiagnosisDaoI.getAllPatientDiagnosiss();
		return patientDiagnosisList;
	}
	@Override
	public PatientDiagnosis getPatientDiagnosis(int patientDiagnosisId) {
		PatientDiagnosis patientDiagnosis= patientDiagnosisDaoI.getPatientDiagnosis(patientDiagnosisId);
		return patientDiagnosis;
	}
	@Override
	public void updatePatientDiagnosis(PatientDiagnosis patientDiagnosis) {
		patientDiagnosisDaoI.updatePatientDiagnosis(patientDiagnosis);		
	}
	@Override
	public void deletePatientDiagnosis(int patientDiagnosisId) {

		patientDiagnosisDaoI.deletePatientDiagnosis(patientDiagnosisId);
		
	}
	@Override
	public PatientDiagnosis patientDiagnosisAutoComplete() {
		
		PatientDiagnosis patientDiagnosis =patientDiagnosisDaoI.patientDiagnosisAutoComplete();
		return patientDiagnosis;
	}
}
