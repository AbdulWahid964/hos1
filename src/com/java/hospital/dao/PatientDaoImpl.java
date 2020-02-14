package com.java.hospital.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.hospital.model.Patient;

@Repository
public class PatientDaoImpl implements PatientDaoI {

	@Autowired
	SessionFactory sessionFactory;
	// @Autowired
	// TransactionManager manager;

	// public TransactionManager getManager() {
	// return manager;
	// }
	//
	// public void setManager(TransactionManager manager) {
	// this.manager = manager;
	// }

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int savePatient(Patient patient) throws ParseException {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Date date = patient.getDateOfBirth();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dob = sdf.format(date);
		Date date1 = sdf.parse(dob);
		patient.setDateOfBirth(date1);
		session.saveOrUpdate(patient);
		System.out.println("First Name ");
		transaction.commit();
		session.close();

		return 0;
	}

}
