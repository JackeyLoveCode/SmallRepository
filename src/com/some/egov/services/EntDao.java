package com.some.egov.services;

import java.util.List;

import com.some.egov.beans.Enterprise;
import com.some.egov.beans.Page;

public interface EntDao {

	Enterprise selectByOrgcode(Enterprise ent);

	Long save(Enterprise ent);

	List<Enterprise> pageQuery(Page page);

	Enterprise selectOneById(Enterprise ent);

	Enterprise getById(Long entId);

}
