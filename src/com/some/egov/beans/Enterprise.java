package com.some.egov.beans;

import java.util.HashSet;
import java.util.Set;

public class Enterprise {
	  
	  private long orgcode            ;      
	  private String foreign_reg_number ;  
	  private String company_name_cn    ;  
	  private String bus_english_name   ;  
	  private String contact            ;  
	  private String contact_pho_num    ;  
	  private String reg_capital        ;  
	  private String fore_reg_capital   ;  
	  private String reg_curr           ;  
	  private String regdate            ;
	  private User user;
	  private Author author;
	  private Set<EnInv> set = new HashSet<EnInv>();
	  
		public Set<EnInv> getSet() {
			return set;
		}
		public void setSet(Set<EnInv> set) {
			this.set = set;
		}
	   public Author getAuthor() {
		return author;
	   }
	public void setAuthor(Author author) {
		this.author = author;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public long getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(long orgcode) {
		this.orgcode = orgcode;
	}
	public String getForeign_reg_number() {
		return foreign_reg_number;
	}
	public void setForeign_reg_number(String foreign_reg_number) {
		this.foreign_reg_number = foreign_reg_number;
	}
	public String getCompany_name_cn() {
		return company_name_cn;
	}
	public void setCompany_name_cn(String company_name_cn) {
		this.company_name_cn = company_name_cn;
	}
	public String getBus_english_name() {
		return bus_english_name;
	}
	public void setBus_english_name(String bus_english_name) {
		this.bus_english_name = bus_english_name;
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
	public String getReg_capital() {
		return reg_capital;
	}
	public void setReg_capital(String reg_capital) {
		this.reg_capital = reg_capital;
	}
	public String getFore_reg_capital() {
		return fore_reg_capital;
	}
	public void setFore_reg_capital(String fore_reg_capital) {
		this.fore_reg_capital = fore_reg_capital;
	}
	public String getReg_curr() {
		return reg_curr;
	}
	public void setReg_curr(String reg_curr) {
		this.reg_curr = reg_curr;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	  

}
