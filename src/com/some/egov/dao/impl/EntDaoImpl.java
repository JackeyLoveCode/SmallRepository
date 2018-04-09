package com.some.egov.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

import com.some.egov.beans.Enterprise;
import com.some.egov.beans.Page;
import com.some.egov.services.EntDao;

public class EntDaoImpl implements EntDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Enterprise selectByOrgcode(Enterprise ent) {
		Enterprise enterprise = sessionFactory.getCurrentSession().get(Enterprise.class, ent.getOrgcode());
		return enterprise;
	}
	public Long save(Enterprise ent) {
		Long entId = (Long) sessionFactory.getCurrentSession().save(ent);
		return entId;
	}
	@SuppressWarnings("all")
	public List<Enterprise> pageQuery(Page page) {
		int begin = (page.getPageno()-1)*page.getPerPageTotal();
		String hql = "select distinct e from Enterprise e left outer join fetch e.user";
		List<Enterprise> list = sessionFactory.getCurrentSession().createQuery(hql).
				setFirstResult(begin).
				setMaxResults(page.getPerPageTotal()).
				list();
		for (Enterprise enterprise : list) {
			page.getList().add(enterprise);
		}
		page.setTotalSize(list.size());
		return page.getList();
	}
	public Enterprise selectOneById(Enterprise ent) {
		Enterprise enterprise = sessionFactory.getCurrentSession().get(Enterprise.class, ent.getOrgcode());
		return enterprise;
	}
	public Enterprise getById(Long entId) {
		Enterprise enterprise = sessionFactory.getCurrentSession().get(Enterprise.class, entId);
		return enterprise;
	}
	
}
