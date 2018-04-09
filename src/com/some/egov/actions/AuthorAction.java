package com.some.egov.actions;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.some.egov.beans.Author;
import com.some.egov.beans.Enterprise;
import com.some.egov.beans.User;
import com.some.egov.services.AuthorService;

/**
 * @author Administrator
 *
 */
public class AuthorAction extends ActionSupport implements ModelDriven<Author>{
	private AuthorService authorService;
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	private Author author;
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Author getModel() {
		if(author == null){
			author = new Author();
		}
		return author;
	}
	

	//跳转到添加核准件页面
	public String toEnDetail(){
		
		return "toEnDetail";
	}
	//文件上传
	private File upload;
	private String uploadFileName;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	//保存核准件
	public String saveAuthor(){
		if(upload != null){
			String path = ServletActionContext.getServletContext().getRealPath("/uploadFile");
			File file = new File(path,uploadFileName);
			try {
				FileUtils.copyFile(upload, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		author.setCap_veri_file(uploadFileName);
		//创建Enterprise 对象，放到author对象里面
		Enterprise enterprise = new Enterprise();
		String orgcode = ServletActionContext.getRequest().getParameter("orgcode");
		enterprise.setOrgcode(Long.parseLong(orgcode));
		author.setEnterprise(enterprise);
		//创建User对象，放到author对象里面
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		author.setUser(user);
		//调用service层的方法
		authorService.saveAuthor(author);
		ServletActionContext.getRequest().setAttribute("msg", "保存成功！");
		return "saveAuthor";
	}
	public String queryAuthor(){
		String a_no = ServletActionContext.getRequest().getParameter("a_no");
		Author author = authorService.findOneById(Long.parseLong(a_no));
		
		if(author != null){
			ServletActionContext.getRequest().setAttribute("author", author);
			return "queryAuthor";
		}
		ServletActionContext.getRequest().setAttribute("msg", "您要找的核准件不存在！");
		return "error";
	}
	//修改核准件
	public String updateAuthor(){
	    int result = authorService.updateAuthor(author);
	    if(result == 1){
	    ServletActionContext.getRequest().setAttribute("msg", "保存成功！");
		return "updateAuthor";
	    }else {
	    	ServletActionContext.getRequest().setAttribute("msg", "修改失败！");
	    	return "updateError";
	    }
	}
	
}
