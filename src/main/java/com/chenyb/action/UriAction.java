package com.chenyb.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chenyb.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ��ͨ�������ļ�����
 * @author DHUser
 *
 */
@Controller("uriAction")
@Scope("prototype")
public class UriAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, ServletContextAware{
	Log log = LogFactory.getLog(UriAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private User user;
	public String add() throws Exception {	
		log.info("����ָ����Ĭ�ϵ�add������username="+username);
		return SUCCESS;
	}
	/** 
	 * Ĭ��ִ�з���
	 */
	@Override
	public String execute() throws Exception {	
		HttpServletRequest request = ServletActionContext.getRequest();
	    ServletContext servletContext = ServletActionContext.getServletContext();
	    HttpServletResponse response = ServletActionContext.getResponse();
		  //DynaActionForm loginForm = (DynaActionForm) form;   ActionForm form,
		  //String username = (String) loginForm.get("username");  
		  //String password = (String) loginForm.get("password");  
		if(user!=null){
			log.info("ģ���������ԣ�user.username="+user.getUsername());
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
	    ActionContext.getContext().getSession().put("username",getUsername());  
	    ActionContext.getContext().getSession().put("password",getPassword());  
		log.info("��ͨ���Դ��ݣ�username:"+user.getUsername());
		request.getSession().setAttribute("username", username);
		if (!"chenyb".equals(username))
		{
			log.info("登录成功!");
			return SUCCESS;
		}
		else {
			return SUCCESS;
		}
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public void setServletContext(ServletContext arg0) {
		log.info(arg0);
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		log.info(arg0);
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		log.info(arg0);
	}

}
