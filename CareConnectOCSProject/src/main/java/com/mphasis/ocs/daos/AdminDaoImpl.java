package com.mphasis.ocs.daos;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.ocs.pojos.Admin;
import com.mphasis.ocs.pojos.Reporter;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	SessionFactory sessionFactory;
	public Admin login(String aid, String password) {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Admin.class);
		Criterion rid=Restrictions.eq("aid", aid);
		Criterion reppwd=Restrictions.eq("password", password);
		LogicalExpression er=Restrictions.and(rid,reppwd);
		criteria.add(er);
		Admin admin=(Admin)criteria.uniqueResult();
		return admin;
	
	}
	public void addAdmin(Admin admin) {
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();
}
}