package com.java.hospital.dao;

import java.util.List;

import com.java.hospital.model.Physician;

public interface PhysicianDaoI {
	
	void savePhysician(Physician physician);
	List<Physician> getAllPhysicians();
	Physician getPhysician(int physicianId);
	void updatePhysician(Physician physician);
	void deletePhysician(int physicianId);
	Physician physicianAutoComplete();
	List<Physician> searchPhysician(Physician physician);
}
