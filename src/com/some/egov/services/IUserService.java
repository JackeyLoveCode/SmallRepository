package com.some.egov.services;

import java.util.List;

import com.some.egov.beans.Page;
import com.some.egov.beans.User;

public interface IUserService {

	int save(User user);

	List<User> pageQueryUser(Page<User> page);

	List<User> findAll();

	User findOne(User user);

	User getByUsercode(String usercode);

	void delete(User user);

	void update(User user);

}
