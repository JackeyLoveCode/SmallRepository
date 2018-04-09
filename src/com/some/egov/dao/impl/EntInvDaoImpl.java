package com.some.egov.dao.impl;

import org.hibernate.SessionFactory;

import com.some.egov.beans.EnInv;
import com.some.egov.daos.EntInvDao;

public class EntInvDaoImpl implements EntInvDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void saveEntInv(EnInv entInv) {
		sessionFactory.getCurrentSession().save(entInv);
		
	}
	
}
