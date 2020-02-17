package com.java.hospital.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void savePatient(Patient patient) throws ParseException {


		Session session = sessionFactory.openSession();
		try {

			Transaction transaction = session.beginTransaction();
			String date = patient.getDateOfBirthString();
			System.out.println("patient.getDateOfBirth()" +patient.getDateOfBirthString());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			patient.setDateOfBirth(sdf.parse(date));
			session.save(patient);
			transaction.commit();	
		} catch (Exception e) {
			System.out.println("Exception Caught" +e.getMessage());
		}finally {
			session.close();
		}
	}
	@Override
	public List<Patient> getAllPatients() {

		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<Patient> patientList = session.createQuery("from Patient").list();

		return patientList;
	}

	@Override
	public Patient getPatient(int patientId) {

		Session session = sessionFactory.openSession();

		Patient patient= new Patient();

		try{

			Query query =session.createSQLQuery("SELECT patientId,firstName,lastName,password,dateOfBirth,emailAddress,contactNumber,state"
					+ ",insurancePlan from Patient where patientId=:patientId").addEntity(Patient.class)
					.setParameter("patientId", patientId);

			@SuppressWarnings("unchecked")
			List<Patient> result = query.list();

			for (Patient obj : result) {
				patient.setPatientId(obj.getPatientId());
				patient.setFirstName(obj.getFirstName());
				patient.setLastName(obj.getLastName());
				patient.setPassword(obj.getPassword());
				patient.setDateOfBirth(obj.getDateOfBirth());
				patient.setEmailAddress(obj.getEmailAddress());
				patient.setContactNumber(obj.getContactNumber());
				patient.setState(obj.getState());
				patient.setInsurancePlan(obj.getInsurancePlan());
			}
			query=null;
			result=null;
		}
		catch (Exception e) {
			System.out.println("Exception Caught " +e.getMessage());
		}
		finally {
			session.close();	
		}
		return patient;
	}

	@Override
	public void updatePatient(Patient patient) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try{
			session.saveOrUpdate(patient);
			transaction.commit();

		}
		catch (Exception e) {
			System.out.println("Exception Caught " +e.getMessage());
		}
		finally {
			session.close();
			patient=null;
		}
	}

	@Override
	public void deletePatient(int patientId) {

		Session session = sessionFactory.openSession();

		try{
			session.createQuery("delete from Patient where patientId="+patientId).executeUpdate();		
		}
		catch (Exception e) {
			System.out.println("Exception Caught" +e.getMessage());
		}
		finally {
			session.close();

		}
	}
	@Override
	public Patient patientAutoComplete() {

		Session session = sessionFactory.openSession();

		Patient patientObj = new Patient();
		try{
			//			int firstTime=0;
			//			if(firstTime>0){
			Query query =session.createQuery("select max(patientId) from Patient ");

			int  result = (int) query.uniqueResult();

			//				firstTime++;
			patientObj.setPatientId(result+1);
			query=null;
			//			}
		}
		catch (Exception e) {
			System.out.println("Exception Caught" +e.getMessage());
		}
		finally {
			session.close();
		}
		return patientObj;
	}

	@Override
	public List<Patient> viewPatientHistory() {

		Session session = sessionFactory.openSession();

		Query query =session.createSQLQuery("SELECT patientId,firstName,lastName,password,emailAddress,contactNumber,state"
				+ ",insurancePlan,dateOfBirth from Patient").addEntity(Patient.class);

		@SuppressWarnings("unchecked")
		List<Patient> viewPatientHistoryList = query.list();

		
		return viewPatientHistoryList;

	}
}
