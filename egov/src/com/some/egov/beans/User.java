package com.some.egov.beans;

public class User {
	/*usercode             VARCHAR(12)          not null,
	   username             VARCHAR(12),
	   userpawd             VARCHAR(12),
	   orgtype              CHAR(1 BYTE),
	   userdate             CHAR(20 BYTE),*/
	String usercode ;
	String username;
	String userpawd;
	String orgtype;
	String userdate;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String usercode, String username, String userpawd, String orgtype, String userdate) {
		super();
		this.usercode = usercode;
		this.username = username;
		this.userpawd = userpawd;
		this.orgtype = orgtype;
		this.userdate = userdate;
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
		return "User [usercode=" + usercode + ", username=" + username + ", userpawd=" + userpawd + ", orgtype="
				+ orgtype + ", userdate=" + userdate + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
