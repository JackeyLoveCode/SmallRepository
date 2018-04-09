package com.some.egov.beans;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	private Integer pageno;
	private Integer perPageTotal;
	private Integer totalSize;
	private List<T> list ;
	

	public Page(String pagenum){
		if(pagenum==null){
			this.pageno = 1;
		}else {
			this.pageno = Integer.parseInt(pagenum);
		}
		this.perPageTotal = 3;
		
		this.list = new ArrayList<T>();
	}
	
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public Integer getPageno() {
		return pageno;
	}
	public Integer getPerPageTotal() {
		return perPageTotal;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	
	public Integer getPageCount(){
		return totalSize % perPageTotal == 0 ?totalSize / perPageTotal : totalSize / perPageTotal+1;
	}
	public List<T> getList() {
		return list;
	}
	public String getSql(String sql){
		Integer endIndex = pageno*perPageTotal;
		Integer beginIndex = (pageno-1)*perPageTotal;
		return "select * from(select t.*,rownum as linenum from ("+sql+") t  where rownum<="+endIndex +") where linenum>"+beginIndex ;
	}
	
	
}
