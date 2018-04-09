package com.some.egov.beans;

import java.util.Set;

public class User {
	/*usercode             VARCHAR(12)          not null,
	   username             VARCHAR(12),
	   userpawd             VARCHAR(12),
	   orgtype              CHAR(1 BYTE),
	   userdate             CHAR(20 BYTE),*/
	private Integer userId;
	private String usercode ;
	private String username;
	private String userpawd;
	private String orgtype;
	private String userdate;
	//Investor的Set集合
	private Set<Investor> set;
	//Enterprise的Set集合
	private Set<Enterprise> enterSet;
	//Author 的Set集合
	private Set<Author> autSet;
	public Set<Author> getAutSet() {
		return autSet;
	}
	public void setAutSet(Set<Author> autSet) {
		this.autSet = autSet;
	}
	public Set<Enterprise> getEnterSet() {
		return enterSet;
	}
	public void setEnterSet(Set<Enterprise> enterSet) {
		this.enterSet = enterSet;
	}
	public Set<Investor> getSet() {
		return set;
	}
	public void setSet(Set<Investor> set) {
		this.set = set;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpawd() {
		return userpawd;
	}
	public void setUserpawd(String userpawd) {
		this.userpawd = userpawd;
	}
	public String getOrgtype() {
		return orgtype;
	}
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}
	public String getUserdate() {
		return userdate;
	}
	public void setUserdate(String userdate) {
		this.userdate = userdate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", usercode=" + usercode + ", username=" + username + ", userpawd=" + userpawd
				+ ", orgtype=" + orgtype + ", userdate=" + userdate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
