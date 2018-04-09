package com.some.egov.actions;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.some.egov.beans.Investor;
import com.some.egov.beans.Page;
import com.some.egov.beans.User;
import com.some.egov.services.InvService;
import com.some.egov.utils.DateUtil;

public class InvAction extends ActionSupport implements ModelDriven<Investor>{
	private InvService invService;
	public void setInvService(InvService invService) {
		this.invService = invService;
	}
	private Investor inv;
	public Investor getModel() {
		if(inv == null){
			inv = new Investor();
		}
		return inv;
	}
	private String startDate;
	private String endDate;
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	//当前页码
	private Integer pageno;
	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}
	//多条件查询投资人
	public String pageQuery(){
		Page<Investor> page = new Page<Investor>(pageno); 
		String url = ServletActionContext.getRequest().getParameter("url");
		List<Investor> list =  invService.selectByMultiCondition(inv,startDate,endDate,page);
		ServletActionContext.getRequest().setAttribute("page", page);
		if("/foreignExchange/EntList.jsp".equals(url)){
			return "foreign";
		}
		
		return "pageQuery";
	}
	//新增投资人
	public String save(){
		User user = (User) ServletActionContext.getRequest().getSession(false).getAttribute("user");
		Date d = new Date();
		String dateString = DateUtil.getDateFormat(d,"yyyy-MM-dd");
		inv.setRegdate(dateString);
		inv.setUser(user);
		invService.save(inv);
		return "OrgAdd";
	}
	//查看投资人明细
	public String viewInv(){
		Investor target =  invService.selectOneById(inv);
		if(target != null){
			ServletActionContext.getRequest().setAttribute("inv", target);
		}else{
			
		}
		return "viewInv";
	}
	
}
