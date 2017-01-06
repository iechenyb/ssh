<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传下载测试</title>
</head>
<body>
   <b>struts2下载</b>
    <div style="border:1px solid black">成功上传的文件:<br>
        <ul style="list-style-type:decimal">
        <s:iterator value="#request.fileName" id="file" var='o' status="status">
            <li><a href="<%=basePath%>/download.action?fileName=<s:property value="o"/>"><s:property value="o"/></a>
        </s:iterator>
        </ul>
    </div>
    <hr>
    <b>普通下载</b>
    <div style="border:1px solid black">成功上传的文件:<br>
        <ul style="list-style-type:decimal">
        <s:iterator value="#request.fileName" id="file" var='o' status="status">
            <li><a href="<%=basePath%>/fileAction!download2.action?fileName=<s:property value="o"/>"><s:property value="o"/></a>
        </s:iterator>
        </ul>
    </div>
</body>
</html>