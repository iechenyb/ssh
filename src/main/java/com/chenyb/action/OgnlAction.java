package com.chenyb.action;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.chenyb.entity.Person;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("ognlAction")  
@Namespace("/ognl")  
@ParentPackage("struts-default")  
@Results( { @Result(name = "success", location = "/showognl.jsp"),  
        @Result(name = "fail", location = "/showognl.jsp"),  
        @Result(name = "input", location = "/showognl.jsp") })  
public class OgnlAction extends ActionSupport {  
    private static final long serialVersionUID = -1494290883433357310L;  
    private List<Person> persons;  
  
    @Action("show")  
    public String ognlTest() throws Exception {  
        // 获得ActionContext实例，以便访问Servlet API  
        ActionContext ctx = ActionContext.getContext();  
        // 存入application  
        ctx.getApplication().put("msg", "application信息");  
        // 保存session  
        ctx.getSession().put("msg", "seesion信息");  
        // 保存request信息  
        HttpServletRequest request = ServletActionContext.getRequest();  
        request.setAttribute("msg", "request信息");  
        // 为persons赋值  
        persons = new LinkedList<Person>();  
        Person person1 = new Person();  
        person1.setName("pla1");  
        person1.setAge(26);  
        person1.setBirthday(new Date());  
        persons.add(person1);  
  
        Person person2 = new Person();  
        person2.setName("pla2");  
        person2.setAge(36);  
        person2.setBirthday(new Date());  
        persons.add(person2);  
  
        Person person3 = new Person();  
        person3.setName("pla3");  
        person3.setAge(16);  
        person3.setBirthday(new Date());  
        persons.add(person3);  
  
        return SUCCESS;  
  
    }  
  
    public List<Person> getPersons() {  
        return persons;  
    }  
  
    public void setPersons(List<Person> persons) {  
        this.persons = persons;  
    }  
}  
