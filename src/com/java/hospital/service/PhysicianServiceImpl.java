package com.java.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.java.hospital.dao.PhysicianDaoI;
import com.java.hospital.model.Physician;

@Service
@Component
public class PhysicianServiceImpl implements PhysicianServiceI {

	@Autowired 
	private PhysicianDaoI physicianDaoI;

	public PhysicianDaoI getPhysicianDaoI() {
		return physicianDaoI;
	}
	public void setPhysicianDaoI(PhysicianDaoI physicianDaoI) {
		this.physicianDaoI = physicianDaoI;
	}
	@Override
	public void savePhysician(Physician physician) {

		physicianDaoI.savePhysician(physician);
	}
	@Override
	public List<Physician> getAllPhysician() {

		List<Physician> physicianList=physicianDaoI.getAllPhysicians();
		return physicianList;
	}
	@Override
	public Physician getPhysician(int physicianId) {
		Physician physician= physicianDaoI.getPhysician(physicianId);
		return physician;
	}
	@Override
	public void updatePhysician(Physician physician) {
		physicianDaoI.updatePhysician(physician);		
	}
	@Override
	public void deletePhysician(int physicianId) {

		physicianDaoI.deletePhysician(physicianId);
		
	}
	@Override
	public Physician physicianAutoComplete() {
		
		Physician physician =physicianDaoI.physicianAutoComplete();
		return physician;
	}
	@Override
	public List<Physician> searchPhysician(Physician physician) {
		List<Physician> physicianList=physicianDaoI.searchPhysician(physician);
		return physicianList;
	}
}
