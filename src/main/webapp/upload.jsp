<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>struts2文件上传测试</title>
</head>
<body>
<a href="<%=basePath%>/fileAction1!toUploadJsp.action">刷新文件下载列表</a>
<hr>
<s:form action="upload.action" method="post" theme="simple"
		enctype="multipart/form-data">
		<table align="center" width="50%" border="1">
			<tr>
				<td>选择上传文件</td>
				<td id="more"><s:file name="file"></s:file> </td>
			</tr>
			<tr>
				<td>选择上传文件</td>
				<td id="more"><s:file name="file"></s:file> </td>
			</tr>
			<tr>
				<td>选择上传文件</td>
				<td id="more"><s:file name="file"></s:file> </td>
			</tr>
			<tr>
				<td colspan=2 align=center><s:submit type="button" value="submit"/></td>
			</tr>
		</table>
	</s:form>
	<hr>
	<s:form action="upload.action" method="post" theme="simple"
		enctype="multipart/form-data">
		<table align="center" width="50%" border="1">
			<tr>
				<td>选择上传文件</td>
				<td id="more"><s:file name="file"></s:file></td>
			</tr>
			<tr>
				<td colspan=2 align=center><s:submit type="button" value="submit"/></td>
			</tr>
		</table>
	</s:form>
	<hr>
    <div style="border:1px solid black;width:45%;float:left;margin-right:10px;"><b>struts2下载</b>
        <ul style="list-style-type:decimal">
        <s:iterator value="#request.fileList" id="file" var='o' status="o_status">
            <s:iterator value="#request.fileList[#o_status.index]">     
             <li><a href="<%=basePath%>/download.action?fileName=<s:property value="value"/>"><s:property value="value"/></a>
            </s:iterator> 
        </s:iterator>
        </ul>
    </div>
    <div style="border:1px solid black;float:left;width:45%"><b>普通下载</b>
        <ul style="list-style-type:decimal">
        <s:iterator value="#request.fileList" id="file" var='o' status="o_status">
            <s:iterator value="#request.fileList[#o_status.index]">     
             <li><a href="<%=basePath%>/fileAction!download2.action?fileName=<s:property value="value"/>"><s:property value="value"/></a>
            </s:iterator> 
        </s:iterator>
        </ul>
    </div>
</body>
</html>