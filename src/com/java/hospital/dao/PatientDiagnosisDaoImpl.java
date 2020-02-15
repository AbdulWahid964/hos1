package com.java.hospital.dao;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.java.hospital.model.Patient;
import com.java.hospital.model.PatientDiagnosis;

@Repository
@Component
public class PatientDiagnosisDaoImpl implements PatientDiagnosisDaoI {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int savePatientDiagnosis(PatientDiagnosis patientDiagnosis) throws ParseException {

		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(patientDiagnosis);
		
		session.getTransaction().commit();
		
		return 0;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Patient> listOfPatients() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Patient> patientlist=session.createQuery("from Patient").list();
		return patientlist;
	}

}
