package com.java.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hospital.dao.PhysicianDaoI;
import com.java.hospital.model.Physician;

@Service
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
	public int savePhysician(Physician physician) {

		physicianDaoI.savePhysician(physician);
		return 0;
	}

}
