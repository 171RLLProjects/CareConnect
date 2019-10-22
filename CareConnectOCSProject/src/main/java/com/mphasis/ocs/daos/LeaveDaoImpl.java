package com.mphasis.ocs.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.ocs.pojos.Appointment;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Leave;
import com.mphasis.ocs.pojos.Patient;
@Repository
public class LeaveDaoImpl implements LeaveDao {

	@Autowired
	SessionFactory sessionFactory;
	public String insertLeave(Leave l) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
        session.beginTransaction();
       String s= (String) session.save(l);
        session.getTransaction().commit();
        return s;

	}

	public void updateLeave(Leave l) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(l);
        session.getTransaction().commit();
        session.close();

	}

	public void deleteLeave(Leave l) {
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.delete(l);
        session.getTransaction().commit();
        session.close();
	}
	public List<Leave> getLeavesByStatus(String status) {
		Session session=sessionFactory.openSession();
        Criteria cr=session.createCriteria(Leave.class);
       cr.add(Restrictions.eq("leaveStatus",status));
       List<Leave> leaves=(List<Leave>)cr.list();
        return leaves ;
    
	}

	public List<Leave> getLeavesByDoctor(Doctor doctor) {
		
		Session session=sessionFactory.openSession();
        Criteria cr=session.createCriteria(Leave.class);
       cr.add(Restrictions.eq("doctor",doctor));
       List<Leave> leaves=(List<Leave>)cr.list();
        return leaves ;	}

	public Leave getLeaveById(String lid) {
		Session session=sessionFactory.openSession();
        Leave l=session.get(Leave.class,lid);
        return l;
	}

	

}
