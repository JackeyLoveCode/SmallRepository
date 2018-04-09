package com.some.egov.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.some.egov.beans.Page;
import com.some.egov.beans.User;
import com.some.egov.daos.IUserDao;
/**
 * 完成对用户的CRUD
 * @author Administrator
 *
 */
 
public class UserDaoImpl implements IUserDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public int insertUser(User user) {
		 sessionFactory.getCurrentSession().save(user);
		 return 1;
	}

	public User selectByUsercode(String usercode) {
		String hql = "from User where usercode=:usercode";
		User user = (User) sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, usercode).uniqueResult();
		return user;
	}
	//分页查询用户信息
	public List<User> pageQuery(Page<User> page) {
		String hql = "from User";
		int begin  = (page.getPageno()-1)*page.getPerPageTotal();
		List<User> list = sessionFactory.getCurrentSession().createQuery(hql).
				setFirstResult(begin).
				setMaxResults(page.getPerPageTotal()).
				list();
		
		return list;
	}
	public List<User> findAll() {
		String hql = "from User";
		List<User> list = sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}
	public User findOne(User user) {
		String hql ="from User where orgtype=:orgtype and usercode=:usercode and userpawd=:userpawd";
		List<User> list  = (List) sessionFactory.getCurrentSession().createQuery(hql).
				setParameter("orgtype", user.getOrgtype()).setParameter("usercode", user.getUsercode()).setParameter("userpawd", user.getUserpawd()).
				list();
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
		
	}
	public User findOneByCode(String usercode) {
		String hql = "from User where usercode=:usercode";
		List<User> list = (List)sessionFactory.getCurrentSession().createQuery(hql).setParameter("usercode", usercode).list();
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
		
	}
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
		
	}
	public void update(User user) {
		sessionFactory.getCurrentSession().merge(user);
		
	}

}
