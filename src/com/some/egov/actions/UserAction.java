package com.some.egov.actions;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.some.egov.beans.Page;
import com.some.egov.beans.User;
import com.some.egov.services.IUserService;
import com.some.egov.utils.DateUtil;
import com.some.egov.utils.StringUtil;
import com.some.egov.utils.ValidateCode;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private IUserService userService;
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	private User user;
	public User getModel() {
		if(user == null )
		{
			user = new User();
		}
		return user;
	}
	//生成验证码
	public void validateCode() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		// 设置响应的类型格式为图片格式  
	    response.setContentType("image/jpeg");  
	    //禁止图像缓存。  
	    response.setHeader("Pragma", "no-cache");  
	    response.setHeader("Cache-Control", "no-cache");  
	    response.setDateHeader("Expires", 0);  
	  
	    HttpSession session = request.getSession();  
	    ValidateCode vCode = new ValidateCode(120,40,5,100);  
	    session.setAttribute("code", vCode.getCode());
	    vCode.write(response.getOutputStream());  
	}
	//保存用户信息的Action
	public String saveUser(){
		Date date = new Date();
		String userDate = DateUtil.getDateFormat(date, "yyyy-MM-dd HH:mm:SSS");
		user.setUserdate(userDate);
		int count = userService.save(user);
		if(count == 1){
			return "success";
		}else{
			return "fail";
		}
	}
	private Integer pageno;
	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}
	//分页查询用户信息
	public String pageQuery(){
		/*if(ServletActionContext.getRequest().getParameter("pageno") != null){
			pageno = Integer.parseInt(ServletActionContext.getRequest().getParameter("pageno"));
		}*/
		
		Page<User> page = new Page<User>(pageno);
		List<User> list = userService.pageQueryUser(page);
		for (User user : list) {
			page.getList().add(user);
		}
		List<User> totalList = userService.findAll();
		page.setTotalSize(totalList.size());
		ServletActionContext.getRequest().setAttribute("page", page);
		return "pageQuery";
	}
	//登录
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String code = request.getParameter("code");
		String validateCode = (String) session.getAttribute("code");
		/*if(! StringUtil.equalIgnoreCase(code,validateCode)){
			request.setAttribute("msg", "验证码错误");
			return "errorValidateCode";
		}*/
		User target = userService.findOne(user);
		if(target != null){
			session.setAttribute("user", target);
		}else{
			request.setAttribute("msg", "用户不存在，请重新输入");
			return "loginFail";
		}
		return "login";
	}
	//跳转到添加用户界面
	public String toAddUser(){
		return "toAddUser";
	}
	//处理异步ajax请求
	public void checkUsercode() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String usercode = request.getParameter("usercode");
		User user = userService.getByUsercode(usercode);
		/*response.setContentType("text/html;charset='utf-8'");
		PrintWriter out = response.getWriter();
		if(user != null){
			out.print("<font color='red'>用户代码已存在</font>");
			
		}
		else {
			out.print("<font color='green'>用户代码可用</font>");
		}*/
		if(user != null){
			request.setAttribute("msg",false);
		}else{
			request.setAttribute("msg",true);
		}
		request.getRequestDispatcher("/user/Msg.jsp").forward(request, response);
		
		
	}
	//删除用户信息
	public String delete(){
		String usercode = ServletActionContext.getRequest().getParameter("checkbox");
		User user = userService.getByUsercode(usercode);
		if(user != null){
			userService.delete(user);
		}
		return "delete";
	}
	//跳转到修改用户界面
	public String toUpdatePage(){
		String usercode = ServletActionContext.getRequest().getParameter("checkbox");
		User u = userService.getByUsercode(usercode);
		if(u != null){
			ServletActionContext.getRequest().setAttribute("user", u);
			return "toUpdatePage";
		}
		return "";
	}
	//修改用户信息
	public String update(){
		String usercode = ServletActionContext.getRequest().getParameter("usercode");
		user.setUserId(userService.getByUsercode(usercode).getUserId());
		userService.update(user);
		return "update";
	}
	//登出
	public String logout(){
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		
		return "logout";
	}
	
}
