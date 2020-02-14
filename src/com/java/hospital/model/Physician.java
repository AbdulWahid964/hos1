package com.java.hospital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Physician {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int physicianId;
	private String physicianFirstName;
	private String physicianLastName;
	private String department;
	private int yearOfExperience;
	private String state;
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
	

	
}
