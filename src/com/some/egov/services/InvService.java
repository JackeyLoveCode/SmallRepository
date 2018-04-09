package com.some.egov.services;

import java.util.List;

import com.some.egov.beans.Investor;
import com.some.egov.beans.Page;

public interface InvService {

	List<Investor> selectByMultiCondition(Investor inv, String startDate, String endDate, Page<Investor> page);

	void save(Investor inv);

	Investor selectOneById(Investor inv);

	Investor selectOneById(long investor_reg_code);
	
}
