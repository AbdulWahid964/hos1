package com.java.hospital.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;


@Entity
public class PatientDiagnosis {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int diagnosisId;
	
	
	@OneToOne
	@JoinColumn(name="patientId")
	private Patient patient;
	@Pattern(regexp = "[a-zA-Z]{2,}", message = "should not empty and must conatins alphabets only")
	private String symptoms;
	@Pattern(regexp = "[a-zA-Z]{2,}", message = "should not empty and must conatins alphabets only")
	private String diagnosisProvided;
	@Pattern(regexp = "[a-zA-Z]{2,}", message = "should not empty and must conatins alphabets only")
	private String administeredBy;
	
	private Date dateOfDiagnosis;
	@Transient
	@Pattern(regexp = "^\\d{4}\\/(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])$", message = "must be yyyy/mm/dd")
	private String dateOfDiagnosisString;
	@Pattern(regexp = "[a-zA-Z]{2,}", message = "should not empty and must conatins alphabets only")
	private String followUpRequired;
	
	private Date dateOfFollowUp;
	@Transient
	@Pattern(regexp = "^\\d{4}\\/(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])$", message = "must be yyyy/mm/dd")
	private String dateOfFollowUpString;
	@Pattern(regexp = "[+-]?([0-9]*[.])?[0-9]+", message = "please enter correct format 0.0")
//	^\\d{4}\\/(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])$
	private String billAmount;
	
	
//	@CreditCardNumber(message = "Please Enter valid credit card number")
	@Pattern(regexp = "[0-9]{16}", message = "must conatins 16 digits only")
	private String cardNumber;
	
	private String modeOfPayment;

	public int getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosisProvided() {
		return diagnosisProvided;
	}

	public void setDiagnosisProvided(String diagnosisProvided) {
		this.diagnosisProvided = diagnosisProvided;
	}

	public String getAdministeredBy() {
		return administeredBy;
	}

	public void setAdministeredBy(String administeredBy) {
		this.administeredBy = administeredBy;
	}

	public Date getDateOfDiagnosis() {
		return dateOfDiagnosis;
	}

	public void setDateOfDiagnosis(Date dateOfDiagnosis) {
		this.dateOfDiagnosis = dateOfDiagnosis;
	}

	public String getFollowUpRequired() {
		return followUpRequired;
	}

	public void setFollowUpRequired(String followUpRequired) {
		this.followUpRequired = followUpRequired;
	}

	public Date getDateOfFollowUp() {
		return dateOfFollowUp;
	}

	public void setDateOfFollowUp(Date dateOfFollowUp) {
		this.dateOfFollowUp = dateOfFollowUp;
	}

	public String getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getDateOfDiagnosisString() {
		return dateOfDiagnosisString;
	}

	public void setDateOfDiagnosisString(String dateOfDiagnosisString) {
		this.dateOfDiagnosisString = dateOfDiagnosisString;
	}

	public String getDateOfFollowUpString() {
		return dateOfFollowUpString;
	}

	public void setDateOfFollowUpString(String dateOfFollowUpString) {
		this.dateOfFollowUpString = dateOfFollowUpString;
	}
	
	
	
	
}
