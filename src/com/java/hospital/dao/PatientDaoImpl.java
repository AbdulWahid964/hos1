package com.java.hospital.dao;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.java.hospital.model.Patient;

@Repository
@Component
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
	public void savePatient(Patient patient) throws ParseException {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		/*		Date date = patient.getDateOfBirth();
		System.out.println("patient.getDateOfBirth()" +patient.getDateOfBirth());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dob = sdf.format(date);
		Date date1 = sdf.parse(dob);
		patient.setDateOfBirth(date1);
		 */		
		session.save(patient);

		transaction.commit();

		session.close();
	}

	@Override
	public List<Patient> getAllPatients() {

		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<Patient> patientList = session.createQuery("from Patient").list();

		/*
		Query query = session.createSQLQuery("SELECT id, candidate_name,gender,candidate_email,previous_employer,"
				+ "phone_number,DATE_FORMAT(date_of_interview, '%Y-%m-%d') as date_of_interview from Candidate where id=:candidateId").addEntity(Candidate.class)
				.setParameter("candidateId", candidateId);*/
		/*
		for(Patient patient: patientList) {

			Date date = patient.getDateOfBirth();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String dob = sdf.format(date);
			Date date1 = sdf.format(dob);
			patient.setDateOfBirth(date1);



		}*/

		return patientList;
	}

	@Override
	public Patient getPatient(int patientId) {

		Session session = sessionFactory.openSession();

		Patient patient= new Patient();

		Query query =session.createSQLQuery("SELECT patientId,firstName,lastName,password,emailAddress,contactNumber,state"
				+ ",insurancePlan from Patient where patientId=:patientId").addEntity(Patient.class)
				.setParameter("patientId", patientId);

		List<Patient> result = query.list();

		for (Patient obj : result) {
			patient.setPatientId(obj.getPatientId());
			patient.setFirstName(obj.getFirstName());
			patient.setLastName(obj.getLastName());
			patient.setPassword(obj.getPassword());

			patient.setEmailAddress(obj.getEmailAddress());
			patient.setContactNumber(obj.getContactNumber());
			patient.setState(obj.getState());
			patient.setInsurancePlan(obj.getInsurancePlan());
		}
		session.close();
		query=null;
		result=null;
		return patient;
	}

	@Override
	public void updatePatient(Patient patient) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		/*		Date date = patient.getDateOfBirth();
		System.out.println("patient.getDateOfBirth()" +patient.getDateOfBirth());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dob = sdf.format(date);
		Date date1 = sdf.parse(dob);
		patient.setDateOfBirth(date1);
		 */		
		session.saveOrUpdate(patient);
		transaction.commit();
		session.close();
	}

	@Override
	public void deletePatient(int patientId) {
		Session session = sessionFactory.openSession();
		session.createQuery("delete from Patient where patientId="+patientId).executeUpdate();		
		session.close();
	}


}
