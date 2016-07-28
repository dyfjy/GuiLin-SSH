package org.andy.shop.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 使用注解来配置Action
 * 
 */
@ParentPackage("struts-default")
// 父包
@Namespace("/login")
@Results({ @Result(name = "success", location = "/index.jsp"), @Result(name = "error", location = "/index.jsp") })
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -2554018432709689579L;
	private String userName;
	private String userPass;

	@Action(value = "login",results={
			@Result(name="success",type="chain", location="/userinfo")})
	public String login() throws Exception {
		System.out.println("login");
		if ("123".equals(userPass)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "add", results = { @Result(name = "success", location = "/index.jsp") })
	public String add() throws Exception {
		return SUCCESS;
	}

	@Action(value = "logout")
	public String logout() throws Exception {
		System.out.println("logout");
		return SUCCESS;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

}