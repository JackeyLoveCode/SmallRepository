package com.some.egov.beans;

import java.util.HashSet;
import java.util.Set;

public class Investor {
	/*
	 * investor_reg_code    VARCHAR(32)          not null,
	   investor_name        VARCHAR(32),
	   country              VARCHAR(3),
	   org_code             VARCHAR(32),
	   contact              VARCHAR(32),
	   contact_pho_num      VARCHAR(32),
	   email                VARCHAR(32),
	   note                 VARCHAR(128),
	   agent                VARCHAR(32),
	   regdate              CHAR(10 BYTE),
				 */     
	  /* private Integer  iid;*/
	   private Long   investor_reg_code  ;                           
	   private String   investor_name      ;   
	   private String   country            ;
	   private String   org_code           ;
	   private String   contact            ;
	   private String   contact_pho_num    ;
	   private String   email              ;
	   private String   note               ;
	   /*private String   agent              ;*/
	   private String   regdate            ;
	   /*private String   username           ;*/
	   private User user;
	   public User getUser() {
		return user;
	    }
	    public void setUser(User user) {
		this.user = user;
	    }
	   private Set<EnInv> set = new HashSet<EnInv>();
	   public Set<EnInv> getSet() {
		return set;
	  }
	  public void setSet(Set<EnInv> set) {
		this.set = set;
	  }
	public Long getInvestor_reg_code() {
		return investor_reg_code;
	}
	public void setInvestor_reg_code(Long investor_reg_code) {
		this.investor_reg_code = investor_reg_code;
	}
	/*public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}*/
	public String getInvestor_name() {
		return investor_name;
	}
	public String getCountry() {
		return country;
	}
	public String getOrg_code() {
		return org_code;
	}
	public String getContact() {
		return contact;
	}
	public String getContact_pho_num() {
		return contact_pho_num;
	}
	public String getEmail() {
		return email;
	}
	public String getNote() {
		return note;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setInvestor_name(String investor_name) {
		this.investor_name = investor_name;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void setContact_pho_num(String contact_pho_num) {
		this.contact_pho_num = contact_pho_num;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	   
	   
	   
	   
	   
	   
	   
}                      		          
    		      