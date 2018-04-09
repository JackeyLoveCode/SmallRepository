package com.some.egov.actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.some.egov.beans.EnInv;
import com.some.egov.beans.Enterprise;
import com.some.egov.beans.Investor;
import com.some.egov.services.EntInvService;
import com.some.egov.services.EntService;
import com.some.egov.services.InvService;

public class EntInvAction extends ActionSupport{
	
	//getter and setter
	private EntInvService service;
	
	//setter
	public void setService(EntInvService service) {
		this.service = service;
	}
	private EntService entService;
	//setter
	public void setEntService(EntService entService) {
		this.entService = entService;
	}
	private InvService invService;
	//setter
	public void setInvService(InvService invService) {
		this.invService = invService;
	}
	
	//保存EntInv信息
	public String saveEntInv(){
		
			 String[] parameterValues = ServletActionContext.getRequest().getParameterValues("investor_reg_code");
			 Long entId = (Long) ServletActionContext.getRequest().getAttribute("entId");
			 Enterprise  enterprise = entService.findById(entId);
			 
			for (int i=0;i<parameterValues.length;i++) {
				//接收请求参数
				Investor investor = invService.selectOneById(Long.parseLong(parameterValues[i]));
				String reg_cap_con = ServletActionContext.getRequest().getParameter("reg_cap_con");
				String pro_dis = ServletActionContext.getRequest().getParameter("pro_dis");
				EnInv enInv = new EnInv();
				enInv.setReg_cap_con(reg_cap_con);
				enInv.setPro_dis(pro_dis);
				enInv.setInvestor(investor);
				enInv.setEnterprise(enterprise);
				service.saveEntInv(enInv);
			}
		
		ServletActionContext.getRequest().setAttribute("msg", "保存成功！");
		return "saveEntInv";
	}
	
	
}
