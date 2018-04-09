package com.some.egov.beans;

public class EnInv {

	private Integer enInvId;
	private String reg_cap_con;
	private String pro_dis;
	private Enterprise enterprise;
	private Investor investor;
	public Investor getInvestor() {
		return investor;
	}
	public void setInvestor(Investor investor) {
		this.investor = investor;
	}
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public Integer getEnInvId() {
		return enInvId;
	}
	public void setEnInvId(Integer enInvId) {
		this.enInvId = enInvId;
	}
	public String getReg_cap_con() {
		return reg_cap_con;
	}
	public void setReg_cap_con(String reg_cap_con) {
		this.reg_cap_con = reg_cap_con;
	}
	public String getPro_dis() {
		return pro_dis;
	}
	public void setPro_dis(String pro_dis) {
		this.pro_dis = pro_dis;
	}
	
}
