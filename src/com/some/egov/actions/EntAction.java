package com.some.egov.actions;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.some.egov.beans.Enterprise;
import com.some.egov.beans.Page;
import com.some.egov.beans.User;
import com.some.egov.services.EntService;
import com.some.egov.utils.DateUtil;

public class EntAction extends ActionSupport implements ModelDriven<Enterprise>{
	private EntService entService;
	private Enterprise ent;
	public void setEnt(Enterprise ent) {
		this.ent = ent;
	}
	public Enterprise getModel() {
		if(ent == null){
			ent = new Enterprise();
		}
		return ent;
	}
	public void setEntService(EntService entService) {
		this.entService = entService;
	}
	//核查组织机构代码是否存在
	public String checkOrgcode(){
		Enterprise enterprise = entService.findOneByOrgcode(ent);
		if(enterprise != null){
			ServletActionContext.getRequest().setAttribute("errorMsg", "组织机构已经存在，请重新填写");
			return "error";
		}else{
			ServletActionContext.getRequest().setAttribute("ent", ent);
		}
		return "checkOrgcode";
	}
	//保存企业信息
	public String saveEnt(){
		if(ent != null){
		Date d = new Date();
		String dateString = DateUtil.getDateFormat(d, "yyyy-MM-dd");
		ent.setRegdate(dateString);
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		ent.setUser(user);
		Long result = entService.save(ent);
		ServletActionContext.getRequest().setAttribute("entId", result);
		}
		return "saveEnt";
	}
	private Integer pageno;
	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}
	//分页查询企业信息
	public String pageQuery(){
		Page page = new Page(pageno);
		List<Enterprise> list = entService.pageQuery(page);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "pageQuery";
	}
	//查询单个企业信息
	public String getEntByOrgcode(){
		Enterprise enterprise = entService.findById(ent.getOrgcode());
		if(enterprise != null){
		ServletActionContext.getRequest().setAttribute("en", enterprise);
		}
		return "getEntByOrgcode";
	}
	
	
}
