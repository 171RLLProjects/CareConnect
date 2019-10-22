package com.mphasis.ocs.daos;




import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.mphasis.ocs.pojos.Patient;



@Repository
public class PatientDaoImpl implements PatientDao {



	@Autowired
	SessionFactory sessionFactory;
	public Patient login(String pid, String password) {
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Patient.class);
		Criterion patientid=Restrictions.eq("pid",pid);
		Criterion patientpwd=Restrictions.eq("password", password);
		LogicalExpression andExpression=Restrictions.and(patientid,patientpwd);
		cr.add(andExpression);
		Patient patient=(Patient) cr.uniqueResult();
		return patient;
	}



	public String addPatient(Patient p) {



		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String s=(String) session.save(p);
		session.getTransaction().commit();
		session.close();
		return s;
	}



	public void updatePatient(Patient p) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		session.close();



	}



	public void deletePatient(String pid)  {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Patient p=session.get(Patient.class,pid);
		session.delete(p);
		session.getTransaction().commit();
		session.close();
	}



	public void addSymptom(String symptom,String pid) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Patient p=session.get(Patient.class,pid);
		p.setSymptom(symptom);
		session.save(p);
		session.getTransaction().commit();
		session.close();



	}



	/*    public Patient viewProfile(String pid) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Patient p=session.get(Patient.class,pid);
        session.getTransaction().commit();
        session.close();
        return p;
    }*/




	public Patient getPatientById(String pid) {



		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Patient p=session.get(Patient.class,pid);
		session.getTransaction().commit();
		session.close();
		return p;
	}

}