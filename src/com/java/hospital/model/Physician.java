package com.java.hospital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Physician {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int physicianId;
//	@NotEmpty(message = "First name can't be empty")
	@Pattern(regexp = "[a-zA-Z]{2,}", message = "should not empty and must conatins alphabets only")
	private String physicianFirstName;
//	@NotEmpty(message = "Last name can't be empty")
	@Pattern(regexp = "[a-zA-Z]{2,}", message = "should not empty and must conatins alphabets only")
	private String physicianLastName;
	@NotEmpty(message = "Dept can't be empty")
	private String department;
	@Transient
	@Pattern(regexp = "[0-9]{1,}", message = "must conatins 1 digits")
	private String yearOfExperienceString;
	
	private int yearOfExperience;
	@Pattern(regexp = "[a-zA-Z]{2,}", message = "should not empty and must conatins alphabets only")
	private String state;
	@NotEmpty(message = "insuarance plan can't be empty")
	private String insurancePlan;
	public int getPhysicianId() {
		return physicianId;
	}
	public void setPhysicianId(int physicianId) {
		this.physicianId = physicianId;
	}
	public String getPhysicianFirstName() {
		return physicianFirstName;
	}
	public void setPhysicianFirstName(String physicianFirstName) {
		this.physicianFirstName = physicianFirstName;
	}
	public String getPhysicianLastName() {
		return physicianLastName;
	}
	public void setPhysicianLastName(String physicianLastName) {
		this.physicianLastName = physicianLastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getYearOfExperience() {
		return yearOfExperience;
	}
	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
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
	public Physician() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getYearOfExperienceString() {
		return yearOfExperienceString;
	}
	public void setYearOfExperienceString(String yearOfExperienceString) {
		this.yearOfExperienceString = yearOfExperienceString;
	}
	

	
}
