package com.java.hospital.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void savePatientDiagnosis(PatientDiagnosis patientDiagnosis) throws ParseException {

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			String dateOfDiagnosis = patientDiagnosis.getDateOfDiagnosisString();
			String dateOfFollowUp = patientDiagnosis.getDateOfFollowUpString();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			patientDiagnosis.setDateOfDiagnosis(sdf.parse(dateOfDiagnosis));
			patientDiagnosis.setDateOfFollowUp(sdf.parse(dateOfFollowUp));
			session.save(patientDiagnosis);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			System.out.println("Exception Caught  " +e.getMessage());
		} 
		finally {
			session.close();
		}
	}
	@Override
	public List<Patient> listOfPatients() {
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Patient> patientlist=session.createQuery("from Patient").list();

		session.close();
		return patientlist;

	}

	@Override
	public List<PatientDiagnosis> getAllPatientDiagnosiss() {

		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<PatientDiagnosis> patientDiagonisList = session.createQuery("from PatientDiagnosis").list();
		List<PatientDiagnosis> patientDiagonisList1 = new ArrayList<>();
		for(PatientDiagnosis p:patientDiagonisList) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String s= sdf.format(p.getDateOfDiagnosis());
			String s1= sdf.format(p.getDateOfFollowUp());
			p.setDateOfDiagnosisString(s);
			p.setDateOfFollowUpString(s1);
			patientDiagonisList1.add(p);
		}
		return patientDiagonisList1;
	}

	@Override
	public PatientDiagnosis getPatientDiagnosis(int patientDiagnosisId) {

		Session session = sessionFactory.openSession();

		PatientDiagnosis patientDiagnosis= new PatientDiagnosis();

		try {
			Query query =session.createSQLQuery("SELECT DiagnosisId,patientId,symptoms,administeredBy,diagnosisProvided,dateOfDiagnosis,followUpRequired"
					+ ",dateOfFollowUp,billAmount,cardNumber,modeOfPayment from PatientDiagnosis where DiagnosisId=:patientDiagnosisId").addEntity(PatientDiagnosis.class)
					.setParameter("patientDiagnosisId", patientDiagnosisId);

			@SuppressWarnings("unchecked")
			List<PatientDiagnosis> result = query.list();

			for (PatientDiagnosis obj : result) {
				patientDiagnosis.setDiagnosisId(obj.getDiagnosisId());

				System.out.println("obj.getPatient()" +obj.getPatient().getPatientId());
				Patient patient= (Patient) session.get(Patient.class, obj.getPatient().getPatientId());

				patientDiagnosis.setPatient(patient);
				patientDiagnosis.setSymptoms(obj.getSymptoms());
				patientDiagnosis.setAdministeredBy(obj.getAdministeredBy());
				patientDiagnosis.setDiagnosisProvided(obj.getDiagnosisProvided());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				patientDiagnosis.setDateOfDiagnosisString(sdf.format(obj.getDateOfDiagnosis()));
				patientDiagnosis.setFollowUpRequired(obj.getFollowUpRequired());
				patientDiagnosis.setDateOfFollowUpString(sdf.format(obj.getDateOfFollowUp()));
				patientDiagnosis.setBillAmount(obj.getBillAmount());
				patientDiagnosis.setCardNumber(obj.getCardNumber());
				patientDiagnosis.setModeOfPayment(obj.getModeOfPayment());
				
				
			}
			query=null;
			result=null;
		} catch (Exception e) {
			System.out.println("Exception Caught  " +e.getMessage());
		}
		finally {
			session.close();
		}
		return patientDiagnosis;
	}
	@Override
	public void updatePatientDiagnosis(PatientDiagnosis patientDiagnosis) {

		Session session = sessionFactory.openSession();
		try{
			Transaction transaction = session.beginTransaction();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			patientDiagnosis.setDateOfDiagnosis(sdf.parse(patientDiagnosis.getDateOfDiagnosisString()));
			patientDiagnosis.setDateOfFollowUp(sdf.parse(patientDiagnosis.getDateOfFollowUpString()));
			session.saveOrUpdate(patientDiagnosis);
			transaction.commit();
		}
		catch (Exception e) {
			System.out.println("Execption Caught " +e.getMessage());
		}
		finally {
			session.close();
		}
	}
	@Override
	public void deletePatientDiagnosis(int patientDiagnosisId) {
		Session session = sessionFactory.openSession();
		try {
			session.createQuery("delete from PatientDiagnosis where DiagnosisId="+patientDiagnosisId).executeUpdate();		
		} catch (Exception e) {
			System.out.println("Excpetion Caught  "+e.getMessage());
		}
		finally {
			session.close();	
		}
	}
	@Override
	public PatientDiagnosis patientDiagnosisAutoComplete() {

		Session session = sessionFactory.openSession();
		PatientDiagnosis patientDiagnosisObj = new PatientDiagnosis();
		try {
//			int firstTime=0;
//			if(firstTime>0){

				Query query =session.createQuery("select max(diagnosisId) from PatientDiagnosis ");

				int  result = (int) query.uniqueResult();

//				firstTime++;
				
				patientDiagnosisObj.setDiagnosisId(result+1);
				
				query=null;
//			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			session.close();

		}
		return patientDiagnosisObj;
	}




}
