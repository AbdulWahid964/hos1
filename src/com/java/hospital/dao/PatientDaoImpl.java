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
//			String date = patient.getDateOfBirthString();
//			System.out.println("patient.getDateOfBirth()" +patient.getDateOfBirthString());
//			2020-02-20
		/*	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateString=sdf.format(patient.getDateOfBirth());
			
			System.out.println("dateString"+ dateString);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
			LocalDate date = LocalDate.parse(dateString, formatter);
			
			System.out.println("date After parse "  +date);
			patient.setDateOfBirth(date);*/
			
			System.out.println("contactNumber " +patient.getContactNumber());
			System.out.println("dateOfBirth  " +patient.getDateOfBirth());
			System.out.println("emailAddress " +patient.getEmailAddress());
			System.out.println("firstName " +patient.getFirstName());
			System.out.println("LastName " +patient.getLastName());
			System.out.println("contactNumber " +patient.getPassword());

			System.out.println("state " +patient.getState());
			System.out.println("insu " +patient.getInsurancePlan());
			session.save(patient);
			transaction.commit();	
		} catch (Exception e) {
			System.out.println("Exception Caught" +e.getMessage());
		}finally {
			session.close();
		}
	}
	@Override
	public List<Patient> getAllPatients() throws ParseException {


		Session session = sessionFactory.openSession();

		
		System.out.println("getAllPatients");
		
	//	04-02-2020
		
		
		//List<Patient> patientList1 = new ArrayList<>();
		Query query = session.createSQLQuery("SELECT patientId, contactNumber,emailAddress,firstName,insurancePlan,"
				+ "lastName,password,state,dateOfBirth from Patient ").addEntity(Patient.class);
		
		@SuppressWarnings("unchecked")
		List<Patient> patientList = query.list();
		/*for(Patient p:patientList) {
			
			//04-02-2020
			System.out.println("p.getDateOfBirth() before setting " +p.getDateOfBirth());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			String s= sdf.format(p.getDateOfBirth());
			p.setDateOfBirthString(s);
			
			System.out.println("p.getDateOfBirth() after setting " +p.getDateOfBirth());
			patientList1.add(p);
		}*/
		return patientList;
	}

	@Override
	public Patient getPatient(int patientId) {

		Session session = sessionFactory.openSession();

		Patient patient= new Patient();

		try{

			Query query =session.createSQLQuery("SELECT patientId,firstName,lastName,password,emailAddress,contactNumber,state"
					+ ",insurancePlan,dateOfBirth from Patient where patientId=:patientId").addEntity(Patient.class)
					.setParameter("patientId", patientId);

			@SuppressWarnings("unchecked")
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
				System.out.println("obj date-> "+obj.getDateOfBirth());
				patient.setDateOfBirth(obj.getDateOfBirth());
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
			if(patient.getPassword().isEmpty()) {
			Patient pat=updatePassword(patient);
			patient.setPassword(pat.getPassword());
			}
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
	public Patient updatePassword(Patient patient){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Patient patientObj= new Patient();
		try{
			patientObj=(Patient) session.get(Patient.class, patient.getPatientId());
			patient.setPassword(patientObj.getPassword());
			System.out.println("patientObj.getPassword()"+patientObj.getPassword());
		}
		catch (Exception e) {
			System.out.println("Exception Caught" +e.getMessage());
		}
		finally{
			session.close();
		}
		return patient;
	}
}
