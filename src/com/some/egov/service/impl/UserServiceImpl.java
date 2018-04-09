package com.some.egov.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.some.egov.beans.Page;
import com.some.egov.beans.User;
import com.some.egov.services.IUserService;
import com.some.egov.daos.IUserDao;
@Transactional
public class UserServiceImpl implements IUserService {

	private IUserDao dao;
	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	public int save(User user) {
		int result = dao.insertUser(user);
		if(result==1){
			return 1;
		}
		return 0;
	}

	

	public List<User> pageQueryUser(Page<User> page) {
		List<User> list = dao.pageQuery(page);
		return list;
	}

	public List<User> findAll() {
		List<User> list = dao.findAll();
		return list;
	}

	public User findOne(User user) {
		User target = dao.findOne(user);
		
		return target;
	}

	public User getByUsercode(String usercode) {
		User user = dao.findOneByCode(usercode);
		return user;
	}

	public void delete(User user) {
		dao.delete(user);
		
	}

	public void update(User user) {
		dao.update(user);
		
	}

		

}
