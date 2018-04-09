package com.some.egov.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.some.egov.beans.Enterprise;
import com.some.egov.beans.Page;
import com.some.egov.services.EntDao;
import com.some.egov.services.EntService;
@Transactional
public class EntServiceImpl implements EntService {
	private EntDao entDao;
	public void setEntDao(EntDao entDao) {
		this.entDao = entDao;
	}
	public Enterprise findOneByOrgcode(Enterprise ent) {
		Enterprise enterprise = entDao.selectByOrgcode(ent);
		return enterprise;
	}
	public Long save(Enterprise ent) {
		return entDao.save(ent);
		
	}
	public List<Enterprise> pageQuery(Page page) {
		List<Enterprise> list = entDao.pageQuery(page);
		return list;
	}
	public Enterprise findById(Enterprise ent) {
		Enterprise enterprise = entDao.selectOneById(ent);
		
		return enterprise;
	}
	public Enterprise findById(Long entId) {
		Enterprise enterprise = entDao.getById(entId);
		return enterprise;
	}
	
}
