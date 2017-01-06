<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Struts 学习</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
	<b>配置文件测试</b>
	<hr>
	struts表单标签使用
	<s:form action="my/uri.action" method="post">
     <s:textfield name="username" key="用户名"></s:textfield>
     <s:password name="password" key="密码"></s:password>
     <s:submit name="submit" key="注册"></s:submit>
    </s:form>
	普通属性传递(调用默认方法)
		<form action="my/uri.action" method="post">
			username:
			<input type="text" name="username" />
			password:
			<input type="password" name="password" />
			<input type="submit" value="注册" />
		</form>
	模型驱动属性传递(调用默认方法)
		<form action="my/uri.action" method="post">
			username:
			<input type="text" name="user.username" />
			password:
			<input type="password" name="user.password" />
			<input type="submit" value="注册" />
		</form>
	模型驱动属性传递(调用默认方法),动态调用
		<form action="my/uri!add.action" method="post">
			username:
			<input type="text" name="user.username" />
			password:
			<input type="password" name="user.password" />
			<input type="submit" value="注册" />
		</form>
	struts使用springBeanAction(调用默认方法)
		<form action="my/uriAnn.action" method="post">
			username:
			<input type="text" name="user.username" />
			password:
			<input type="password" name="user.password" />
			<input type="submit" value="注册" />
		</form>
	在特定的action中指定method方法
		<form action="my/uriAdd.action" method="post">
			username:
			<input type="text" name="username" />
			password:
			<input type="password" name="password" />
			<input type="submit" value="注册" />
		</form>
		username:<font size=5 color=red><s:property value="username"/></font>
		user.username:<font size=5 color=red><s:property value="user.username"/></font>
		<hr>
		<a href="ognl/show.action">OGNL测试</a>
		<a href="upload.jsp">文件上传</a>
		<s:debug></s:debug>
	</body>
</html>
