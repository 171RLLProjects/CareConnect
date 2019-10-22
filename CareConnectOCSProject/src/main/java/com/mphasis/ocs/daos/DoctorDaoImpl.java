package com.mphasis.ocs.daos;

 

import java.util.List;

 

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

 

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Appointment;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Leave;

 

@Repository
public class DoctorDaoImpl implements DoctorDao {

 

    @Autowired
    SessionFactory sessionFactory;
    public void insertDoctor(Doctor d) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(d);
        session.getTransaction().commit();
        session.close();
    }

 

    public void updatedoctor(Doctor d) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(d);
        session.getTransaction().commit();
    }

 

    public void deletedoctor(String did) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Doctor doc=(Doctor)session.get(Doctor.class,did);
        session.delete(doc);
        session.getTransaction().commit();
        session.close();
        
    }

 

    public List<Doctor> getAll() {
        Session session=sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Doctor> query = builder.createQuery(Doctor.class);
         query.from(Doctor.class);
         List<Doctor> doctor = session.createQuery(query).getResultList();
         System.out.println(doctor);
         return doctor;
    }

 

    
    public Doctor getDoctorById(String did) {
        Session session=sessionFactory.openSession();
        Doctor doctor=session.get(Doctor.class,did);
        return doctor;
    }

 

    public Doctor login(String did,String password) {
        Session session=sessionFactory.openSession();
        Criteria c=session.createCriteria(Doctor.class);
        Criterion doctorid=Restrictions.eq("did", did);
        Criterion doctorpwd=Restrictions.eq("password", password);
        LogicalExpression er=Restrictions.and(doctorid,doctorpwd);
        c.add(er);
        Doctor doctor=(Doctor)c.uniqueResult();
        return doctor;
    }

 


    
    

 

}