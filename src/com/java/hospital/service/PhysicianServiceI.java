package com.java.hospital.service;

import java.util.List;

import com.java.hospital.model.Physician;

public interface PhysicianServiceI {
	
	void savePhysician(Physician physician);
	List<Physician> getAllPhysician();
	Physician getPhysician(int physicianId);
	void updatePhysician(Physician physician);
	void deletePhysician(int physicianId);
	Physician physicianAutoComplete();
	List<Physician> searchPhysician(Physician physician);
}
