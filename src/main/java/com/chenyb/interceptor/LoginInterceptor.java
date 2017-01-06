package com.chenyb.interceptor;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {  
	  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override  
    public String intercept(ActionInvocation invocation) throws Exception {  
  
        // 取得请求相关的ActionContext实例  
        ActionContext ctx = invocation.getInvocationContext();  
        Map<String, Object> session = ctx.getSession();  
        //String username = (String) session.get("username"); 
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);  
        System.out.println(request.getParameter("username"));  
        System.out.println(request.getRequestURI());  
        System.out.println(request.getServletPath());   
        // 如果没有登陆，或者登陆所有的用户名不是yuewei，都返回重新登陆  
        if (request.getParameter("username") != null) {  
            System.out.println("username = "+request.getParameter("username"));  
            return invocation.invoke();  
        }  
        System.out.println("你还没有登录");          
        return Action.LOGIN;  
    }  
}  
