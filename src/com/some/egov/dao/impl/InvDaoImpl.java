package com.some.egov.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.some.egov.beans.Investor;
import com.some.egov.beans.Page;
import com.some.egov.daos.InvDao;

public class InvDaoImpl implements InvDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Investor> selectByMultiCondition(Investor inv, String startDate, String endDate, Page<Investor> page) {
		String hql = "select distinct i from Investor i left outer join fetch i.user where 1=1";
		String hql2 = "select count(*) from Investor i,User u  where 1=1 and i.user.userId=u.userId or i.user.userId=null";
		int begin = (page.getPageno()-1)*page.getPerPageTotal();
		Map<String,Object> valueMap = new HashMap<String,Object>();
		if(inv.getInvestor_reg_code() != null){
			hql += " and investor_reg_code =:investor_reg_code";
			hql2 += " and investor_reg_code =:investor_reg_code";
			valueMap.put("investor_reg_code", inv.getInvestor_reg_code());
		}
		if(inv.getInvestor_name() != null && inv.getInvestor_name().trim().length() > 0){
			hql += " and investor_name like '%"+inv.getInvestor_name()+"%'";
			hql2 += " and investor_name like '%"+inv.getInvestor_name()+"%'";
		}
		if(startDate != null && startDate.trim().length() > 0){
			hql += " and regdate >=:startDate";
			hql2 += " and regdate >=:startDate ";
			valueMap.put("startDate", startDate);
		}
		if(endDate != null && endDate.trim().length() > 0){
			hql += " and regdate <=:endDate";
			hql2 += " and regdate <=:endDate";
			valueMap.put("endDate", endDate);
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Query query2 = sessionFactory.getCurrentSession().createQuery(hql2);
		Set<String> keys = valueMap.keySet();
		if(keys != null){
		for (String string : keys) {
			query.setParameter(string, valueMap.get(string));
			query2.setParameter(string, valueMap.get(string));
			
		}
		}
		Long total = (Long) query2.uniqueResult();
		page.setTotalSize(total.intValue());
		query.setFirstResult(begin).setMaxResults(page.getPerPageTotal());
		List<Investor> list2 = query.list();
		for (Investor investor : list2) {
			page.getList().add(investor);
		}
		return page.getList(); 
	}
	
	public void save(Investor inv) {
		sessionFactory.getCurrentSession().merge(inv);
		
	}
	public Investor selectOneById(Investor inv) {
		Investor investor = sessionFactory.getCurrentSession().get(Investor.class, inv.getInvestor_reg_code());
		return investor;
	}
	public Investor selectOneById(long investor_reg_code) {
		Investor inv = sessionFactory.getCurrentSession().get(Investor.class, investor_reg_code);
		return inv;
	}
	
}
