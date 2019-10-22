package com.mphasis.ocs.daos;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.ocs.pojos.Admin;
import com.mphasis.ocs.pojos.Appointment;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Patient;
@Repository
public class AppointmentDaoImpl implements AppointmentDao {

	@Autowired
	SessionFactory sessionFactory;
	public void updateAppointment(Appointment a) {
		// TODO Auto-generated method stub

		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(a);
		session.getTransaction().commit();
		session.close();

	}



	public void insertAppointment(Appointment a) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(a);
		session.getTransaction().commit();
		session.close();

	}
	public void deleteAppointment(String aid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(aid);

		session.getTransaction().commit();
		session.close();

	}



	public Appointment getAppointmentsById(String aid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Appointment a=session.get(Appointment.class,aid);
		return a;

	}



	public List<Appointment> getAppointmentsByStatus(String s) {
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Appointment.class);
		cr.add(Restrictions.eq("status",s));
		List<Appointment> appointments=(List<Appointment>)cr.list();
		return appointments ;
	}


	public List<Appointment> getAppointmentsByPatient(Patient patient) {
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Appointment.class);
		cr.add(Restrictions.eq("patient",patient));
		List<Appointment> appointments=(List<Appointment>)cr.list();
		return appointments ;	
	}




	public List<Appointment> getAppointmentsByDoctor(Doctor doctor,Date date) {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Appointment.class);
		Criterion c1=Restrictions.eq("doctor", doctor);
		Criterion c2=Restrictions.eq("appointmentDate", date);
		Criterion c3=Restrictions.eq("status", "approved");
		Conjunction er=Restrictions.and(c1,c2,c3);
		criteria.add(er);
		List<Appointment> appointments=(List<Appointment>)criteria.list();
		return appointments;
	}






}
