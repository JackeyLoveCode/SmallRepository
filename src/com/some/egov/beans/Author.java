package com.some.egov.beans;

public class Author {

	private Long a_no             ; 
	/*private String orgcode          ; */  
	private String note             ;   
	private String contact          ;   
	private String contact_pho_num  ;   
	private String cap_veri_file    ;   
	private String file_remark      ;   
	private String state_feedback   ;
	private String regdate			;
	private String reg_curr			;
	private String reg_capital		;
	private User user;
	private Enterprise enterprise;
	
	/**
	 * 
	 */
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param note
	 * @param contact
	 * @param contact_pho_num
	 * @param cap_veri_file
	 * @param file_remark
	 * @param state_feedback
	 * @param regdate
	 * @param reg_curr
	 * @param reg_capital
	 * @param user
	 * @param enterprise
	 */
	public Author(String note, String contact, String contact_pho_num, String cap_veri_file, String file_remark,
			String state_feedback, String regdate, String reg_curr, String reg_capital, User user,
			Enterprise enterprise) {
		super();
		this.note = note;
		this.contact = contact;
		this.contact_pho_num = contact_pho_num;
		this.cap_veri_file = cap_veri_file;
		this.file_remark = file_remark;
		this.state_feedback = state_feedback;
		this.regdate = regdate;
		this.reg_curr = reg_curr;
		this.reg_capital = reg_capital;
		this.user = user;
		this.enterprise = enterprise;
	}
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getReg_curr() {
		return reg_curr;
	}
	public void setReg_curr(String reg_curr) {
		this.reg_curr = reg_curr;
	}
	public String getReg_capital() {
		return reg_capital;
	}
	public void setReg_capital(String reg_capital) {
		this.reg_capital = reg_capital;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContact_pho_num() {
		return contact_pho_num;
	}
	public void setContact_pho_num(String contact_pho_num) {
		this.contact_pho_num = contact_pho_num;
	}
	public String getCap_veri_file() {
		return cap_veri_file;
	}
	public void setCap_veri_file(String cap_veri_file) {
		this.cap_veri_file = cap_veri_file;
	}
	public String getFile_remark() {
		return file_remark;
	}
	public void setFile_remark(String file_remark) {
		this.file_remark = file_remark;
	}
	public Long getA_no() {
		return a_no;
	}
	public void setA_no(Long a_no) {
		this.a_no = a_no;
	}
	public String getState_feedback() {
		return state_feedback;
	}
	public void setState_feedback(String state_feedback) {
		this.state_feedback = state_feedback;
	}  
	
}                       
