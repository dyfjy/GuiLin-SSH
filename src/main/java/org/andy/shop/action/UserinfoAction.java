package org.andy.shop.action;

import java.util.List;

import org.andy.shop.entity.UserInfo;
import org.andy.shop.service.UserInfoService;
import org.andy.shop.utils.AjaxUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 创建时间：2015-2-13 下午2:49:22
 * 
 * @author andy
 * @version 2.2 描述： user的Action
 */
@ParentPackage("struts-default")
//父包
@Namespace("/user")
@Results({ @Result(name = "success", location = "../user/userinfo.jsp"), @Result(name = "error", location = "/error.jsp") })
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class UserinfoAction extends ActionSupport implements
		ModelDriven<UserInfo>, Preparable {
	private static final long serialVersionUID = -2301203156032690317L;

	private static final  Logger logger = LogManager.getLogger(UserinfoAction.class.getName());    
	private Integer id;
	private UserInfo userInfo;
	private List<UserInfo> userInfos;
	@Autowired
	private UserInfoService userInfoService;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public UserInfo getModel() {
		logger.debug("getModel");
		if (null != id) {
			userInfo = userInfoService.get(id);
		} else {
			userInfo = new UserInfo();
		}
		return userInfo;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		
		logger.info("查询所有用户");
		userInfos = userInfoService.findAll();
		return SUCCESS;
		
	}

	/**
	 * userinfo!detail.action
	 * 动态指定的方法 方式
	 */
	public void detail() {
		String id = ServletActionContext.getRequest().getParameter("id");
		logger.info("查看用户详情：" + id);
		userInfo = userInfoService.get(Integer.valueOf(id));
		AjaxUtil.ajaxJSONResponse(userInfo);

	}
	/**
	 * 注解方式
	 *   
	 * @Description:
	 */
	@Action(value = "detailinfo")// 或者写成 @Action("login") 
//	@Result(name="success",location="/msg.jsp") 
	public void detailinfo() {
		String id = ServletActionContext.getRequest().getParameter("id");
		logger.info("查看用户详情：" + id);
		userInfo = userInfoService.get(Integer.valueOf(id));
		AjaxUtil.ajaxJSONResponse(userInfo);
		
	}
	@Action(value = "add", results = { @Result(name = "success", location = "/index.jsp") })    
    public String add() throws Exception {    
        return SUCCESS;    
    }    

	public void prepare() throws Exception {
		System.out.println("pppp");
	}

}
