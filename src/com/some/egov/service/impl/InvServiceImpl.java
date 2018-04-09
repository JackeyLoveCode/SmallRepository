package com.some.egov.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.some.egov.beans.Investor;
import com.some.egov.beans.Page;
import com.some.egov.daos.InvDao;
import com.some.egov.services.InvService;
@Transactional
public class InvServiceImpl implements InvService {
	private InvDao dao;
	public void setDao(InvDao dao) {
		this.dao = dao;
	}
	public List<Investor> selectByMultiCondition(Investor inv, String startDate, String endDate, Page<Investor> page) {
		List<Investor> list = dao.selectByMultiCondition(inv,startDate,endDate,page);
		return list;
	}
	public void save(Investor inv) {
		dao.save(inv);
		
	}
	public Investor selectOneById(Investor inv) {
		Investor target = dao.selectOneById(inv);
		return target;
	}
	public Investor selectOneById(long investor_reg_code) {
		Investor inv = dao.selectOneById(investor_reg_code);
		return inv;
	}
	
}
