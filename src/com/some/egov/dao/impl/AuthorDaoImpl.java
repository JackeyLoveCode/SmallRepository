package com.some.egov.dao.impl;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.some.egov.beans.Author;
import com.some.egov.services.AuthorDao;
import com.some.egov.utils.DateUtil;

public class AuthorDaoImpl implements AuthorDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void save(Author author) {
		author.setState_feedback("0");
		Date d = new Date();
		String dateString = DateUtil.getDateFormat(d, "yyyy-MM-dd");
		
		author.setRegdate(dateString);
		sessionFactory.getCurrentSession().save(author);
	}
	public Author selectOneById(long a_no) {
		Author author = sessionFactory.getCurrentSession().get(Author.class, a_no);
		return author;
	}
	public int updateAuthor(Author author) {
		String hql = "update Author set state_feedback='1' where a_no =?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, author.getA_no());
		return query.executeUpdate();
		
	}
	
}
