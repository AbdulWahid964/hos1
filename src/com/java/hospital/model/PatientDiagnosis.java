package com.java.hospital.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PatientDiagnosis {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int diagnosisId;
	
//	private int patiene
	
	
	
	
}
