package com.java.hospital.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.hospital.model.Physician;

@Repository
public class PhysicianDaoImpl implements PhysicianDaoI {

	@Autowired
	SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public int savePhysician(Physician physician) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(physician);
		session.getTransaction().commit();
		session.close();
		return 0;
	}

}
