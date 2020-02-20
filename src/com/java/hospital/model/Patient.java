package com.java.hospital.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int patientId;
//	@NotEmpty(message = "First name can't be empty")
	@Pattern(regexp = "[a-zA-Z]{2,}", message = "should not empty and must conatins alphabets only")
	private String firstName;
//	@NotEmpty(message = "Last name can't be empty")
	@Pattern(regexp = "[a-zA-Z]{2,}", message = "should not empty and must conatins alphabets only")
	private String lastName;
	@NotEmpty(message = "Password can't be empty")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Minimum eight characters, only letter and number: at least one from each")
	private String password;
	@Transient
	@Pattern(regexp = "^\\d{4}\\/(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])$", message = "must be yyyy/mm/dd")
	private String dateOfBirthString;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	//@Temporal(TemporalType.DATE)
	private String dateOfBirth;
	
	@NotEmpty(message = "email can't be empty")
	@Email(message = "Enter valid email address. e.g hello@domain")
	private String emailAddress;
	@NotEmpty(message = "email can't be empty")
	@Pattern(regexp = "[0-9]{10}", message = "must conatins 10 digits only")
	private String contactNumber;
//	@Pattern(regexp = "[a-zA-Z]{2,}", message = "should not empty and must conatins alphabets only")
	private String state;
	@NotEmpty(message = "insuarance plan can't be empty")
	private String insurancePlan;
	
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateOfBirthString() {
		return dateOfBirthString;
	}
	public void setDateOfBirthString(String dateOfBirthString) {
		this.dateOfBirthString = dateOfBirthString;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getInsurancePlan() {
		return insurancePlan;
	}
	public void setInsurancePlan(String insurancePlan) {
		this.insurancePlan = insurancePlan;
	}
	/*public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}*/
	/*public java.time.LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(java.time.LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}*/
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	}
