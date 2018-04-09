package com.some.egov.daos;

import java.util.List;

import com.some.egov.beans.Page;
import com.some.egov.beans.User;

public interface IUserDao {

	User selectByUsercode(String usercode);

	int insertUser(User user);

	List<User> pageQuery(Page<User> page);

	List<User> findAll();

	User findOne(User user);

	User findOneByCode(String usercode);

	void delete(User user);

	void update(User user);

}
