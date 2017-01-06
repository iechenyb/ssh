package com.chenyb.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chenyb.util.DateUtil;
import com.chenyb.util.FileUtils;
import com.opensymphony.xwork2.ActionSupport;
@Controller("upDownAction")
@Scope("prototype")
public class UpDownAction  extends ActionSupport{
	Log log = LogFactory.getLog(UpDownAction.class);
	private static final long serialVersionUID = 1L;
    private List<File> file;// 对应jsp中file标签
    private List<String> fileFileName;// 参数名固定   
    private List<String> fileContentType;//参数名固定  
    private String fileName;//获得jsp中pram参数
    public String toUploadJsp(){
    	String root = ServletActionContext.getServletContext().getRealPath("/upload");// 上传路径
    	List<File> lst = FileUtils.readDirectory(root);
		List<Map<String,String>> names = new ArrayList<Map<String,String>>();
		for(int i=0;i<lst.size();i++){
			Map<String, String> tmp = new HashMap<String, String>();
			tmp.put("name", lst.get(i).getName());
			names.add(tmp);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("fileList", names);
    	return "toUpload";
    }
    // 文件上传
    public String uploadFile() throws Exception {
    	System.out.println("上传文件类型："+fileContentType+",文件名："+fileFileName);
        String root = ServletActionContext.getServletContext().getRealPath("/upload");// 上传路径
        log.info("保存目录："+root);
        InputStream inputStream;
        File destFile;
        OutputStream os;
        for (int i = 0; i < file.size(); i++) {
            inputStream = new FileInputStream(file.get(i));
            log.info(fileFileName+","+inputStream);
            destFile = new File(root, DateUtil.date2long14(new Date())+this.getFileFileName().get(i));
            os = new FileOutputStream(destFile);
            byte[] buffer = new byte[400];
            int length = 0;
            while ((length = inputStream.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            inputStream.close();
            os.close();
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("fileName", fileFileName);
    	List<File> lst = FileUtils.readDirectory(root);
		List<Map<String,String>> names = new ArrayList<Map<String,String>>();
		for(int i=0;i<lst.size();i++){
			Map<String, String> tmp = new HashMap<String, String>();
			tmp.put("name", lst.get(i).getName());
			names.add(tmp);
		}
        request.setAttribute("fileList", names);
        return SUCCESS;
    }
    // 下载
         public String downloadMyFile() throws Exception {
        	 System.out.println("准备下载...");
             return SUCCESS;
         }
    /*  注意看配置文件的inputName属性
     * <!--由getDownloadFile()方法获得inputStream -->
	<param name="inputName">downloadFile</param>*/
    // 文件下载
    public InputStream getDownloadFile() throws FileNotFoundException,
            UnsupportedEncodingException {
        // 如果下载文件名为中文，进行字符编码转换
    	//下边这句话和配置文件中的配置不能重复配置，否则下载不会提示下载提示框！！！！！！
        //ServletActionContext.getResponse().setHeader("Content-Disposition","attachment;fileName="+ fileName);
        String root = ServletActionContext.getServletContext().getRealPath("/upload");// 上传路径
        log.info(root+File.separator+this.getFileName());
        InputStream inputStream = new FileInputStream(root  //使用绝对路径 ，从该路径下载“测试.txt"文件
                +File.separator+ this.getFileName());
        log.info(getFileName()+","+inputStream);
        return inputStream;
    }
    public String download2() throws IOException{
        String fileName = ServletActionContext.getRequest().getParameter("fileName");
        //要处理中文乱码问题
        //fileName = new String(fileName.getBytes("iso8859-1"),"utf-8");
        //要下载的哪个文件
        String path = ServletActionContext.getServletContext().getRealPath("/");//得到项目的根目录
        InputStream is = new FileInputStream(path+"/upload/"+fileName);
        //下载到哪里？客户端
        HttpServletResponse response = ServletActionContext.getResponse();
        OutputStream os = response.getOutputStream();
        //弹出下载的框filename:提示用户下载的文件名
        response.addHeader("content-disposition", "attachment;filename="+fileName);
        byte[] b = new byte[1024];
        int size = is.read(b);
        while(size>0){
            os.write(b,0,size);
            size = is.read(b);
        }
        is.close();
        os.close();
        return null;
    }

    public String getFileName() throws UnsupportedEncodingException {
        return fileName;
    }

    public void setFileName(String fileName)
            throws UnsupportedEncodingException {
       // this.fileName = new String(fileName.getBytes("ISO8859-1"), "utf-8");
    	this.fileName = fileName;
    }

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}
	public List<String> getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}
}
