package com.chenyb.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller("fileDownloadAction")
public class FileDownloadAction extends ActionSupport
{
	public static String fileName = "";
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputStream getDownloadFile()
    {
        return ServletActionContext.getServletContext().getResourceAsStream("upload/"+fileName);
    }
    
    @Override
    public String execute() throws Exception
    {
        return SUCCESS;
    }
}