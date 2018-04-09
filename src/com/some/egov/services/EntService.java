package com.some.egov.services;

import java.util.List;

import com.some.egov.beans.Enterprise;
import com.some.egov.beans.Page;

public interface EntService {

	Enterprise findOneByOrgcode(Enterprise ent);

	Long save(Enterprise ent);

	List<Enterprise> pageQuery(Page page);

	Enterprise findById(Long entId);

	
}
