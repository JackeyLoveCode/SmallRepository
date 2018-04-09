package com.some.egov.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.some.egov.beans.EnInv;
import com.some.egov.daos.EntInvDao;
import com.some.egov.services.EntInvService;
@Transactional
public class EntInvServiceImpl implements EntInvService {
	private EntInvDao dao;
	public void setDao(EntInvDao dao) {
		this.dao = dao;
	}
	public void saveEntInv(EnInv entInv) {
		dao.saveEntInv(entInv);
		
	}
	
	
}
