package com.java.hospital.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.java.hospital.model.Physician;

@Repository
@Component
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
	public void savePhysician(Physician physician) {

		Session session = sessionFactory.openSession();
		try{
			session.beginTransaction();
			physician.setYearOfExperience(Integer.parseInt(physician.getYearOfExperienceString()));
			session.save(physician);
			session.getTransaction().commit();
		}catch (Exception e) {
			System.out.println("Exception Caught " +e.getMessage());
		}
		finally{
			session.close();
		}

	}
	@Override
	public List<Physician> getAllPhysicians() {

		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<Physician> physicianList = session.createQuery("from Physician").list();

		session.close();
		return physicianList;
	}

	@Override
	public Physician getPhysician(int physicianId) {

		Session session = sessionFactory.openSession();

		Physician physician= new Physician();

		try{
			Query query =session.createSQLQuery("SELECT physicianId,physicianFirstName,physicianlastName,department,yearOfExperience,state"
					+ ",insurancePlan from Physician where physicianId=:physicianId").addEntity(Physician.class)
					.setParameter("physicianId", physicianId);

			@SuppressWarnings("unchecked")
			List<Physician> result = query.list();

			for (Physician obj : result) {

				physician.setPhysicianId(obj.getPhysicianId());
				physician.setPhysicianFirstName(obj.getPhysicianFirstName());
				physician.setPhysicianLastName(obj.getPhysicianLastName());
				physician.setDepartment(obj.getDepartment());
				physician.setYearOfExperience(obj.getYearOfExperience());
				physician.setState(obj.getState());
				physician.setInsurancePlan(obj.getInsurancePlan());
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
		return physician;
	}

	@Override
	public void updatePhysician(Physician physician) {

		Session session = sessionFactory.openSession();

		try{
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(physician);
			transaction.commit();
		}
		catch (Exception e) {
			System.out.println("Execption Caught " +e.getMessage());
		}
		finally {
			session.close();	
		}
		/*		Date date = patient.getDateOfBirth();
		System.out.println("patient.getDateOfBirth()" +patient.getDateOfBirth());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dob = sdf.format(date);
		Date date1 = sdf.parse(dob);
		patient.setDateOfBirth(date1);
		 */		

	}

	@Override
	public void deletePhysician(int physicianId) {

		Session session = sessionFactory.openSession();

		try{
			session.createQuery("delete from Physician where physicianId="+physicianId).executeUpdate();	
		}
		catch (Exception e) {
			System.out.println("Exception Caught " +e.getMessage());
		}
		finally {
			session.close();	
		}
	}
	@Override
	public Physician physicianAutoComplete() {


		Session session = sessionFactory.openSession();
		Physician physicianObj = new Physician();
		try{
			//			int firstTime=0;
			//			if(firstTime>0){
			Query query =session.createQuery("select max(physicianId) from Physician ");
			int  result = (int) query.uniqueResult();

			//				firstTime++;
			physicianObj.setPhysicianId(result+1);
			query=null;
			//			}
		}
		catch (Exception e) {
			System.out.println("Exception Caught "+ e.getMessage());
		}
		finally {
			session.close();
		}
		return physicianObj;
	}

	@Override
	public List<Physician> searchPhysician(Physician physician) {

		Session session = sessionFactory.openSession();
		Query query =session.createSQLQuery("SELECT physicianId,physicianFirstName,physicianlastName,department,yearOfExperience,state"
				+ ",insurancePlan from Physician where state=:state and insurancePlan=:insurancePlan and  department=:department").addEntity(Physician.class)
				.setParameter("state", physician.getState())
				.setParameter("insurancePlan", physician.getInsurancePlan())
				.setParameter("department", physician.getDepartment());


		@SuppressWarnings("unchecked")
		List<Physician> searchPhysician = query.list();
		session.close();
		return searchPhysician;
	}
}
