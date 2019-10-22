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

 

import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Reporter;

 


@Repository
public class ReporterDaoImpl implements ReporterDao {
    @Autowired
    SessionFactory sessionFactory;

 

    public void insertReporter(Reporter r) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(r);
        session.getTransaction().commit();
        
        
    }

 

    public void updateReporter(Reporter r) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(r);
        session.getTransaction().commit();
        session.close();
        
    }

 

    public void deleteReporter(String rid) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Reporter reporter=(Reporter)session.get(Reporter.class,rid);
        session.delete(reporter);
        session.getTransaction().commit();
        session.close();
        
        
    }

 

 

    public Reporter login(String repid,String password) {
Session session=sessionFactory.openSession();
Criteria criteria=session.createCriteria(Reporter.class);
Criterion repid1=Restrictions.eq("rid", repid);
Criterion reppwd=Restrictions.eq("password", password);
LogicalExpression er=Restrictions.and(repid1,reppwd);
criteria.add(er);
Reporter reporter=(Reporter)criteria.uniqueResult();
return reporter;

 

        
    }

 

    public Reporter getReporterById(String rid) {
        Session session=sessionFactory.openSession();
        Reporter reporter=session.get(Reporter.class,rid);
        return reporter;
    }
}