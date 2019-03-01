<%@ page contentType="text/html" language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>无标题文档</title>
	<link href="<%=basePath %>css/base.css" rel="stylesheet" type="text/css">
</head>

<body><div class="head">
	<div class="head_area">
		<div class="head_nav">
			<ul>
				<li><img src="<%=basePath %>images/nav_inc1.png" /><a href="index.html" target="_parent">首页</a></li>
				<li><img src="<%=basePath %>images/nav_inc2.png" /><a href="#">成功案例</a></li>
				<li><img src="<%=basePath %>images/nav_inc3.png" /><a href="#">关于锐聘</a></li>
			</ul>
		</div>
		<div class="head_logo"><img src="<%=basePath %>images/head_logo.png" /></div>
		<div class="head_user">

			<c:if test="${empty sessionScope.username }">
				<a href="login.jsp" target="_parent"><span class="type1">登录</span></a>
				<a href="register.jsp" target="_parent"><span class="type2">注册</span></a>
			</c:if>
			<c:if test="${!empty sessionScope.username && sessionScope.usertype==0}">
				<span>欢迎&nbsp;&nbsp;${sessionScope.username }</span>&nbsp;&nbsp;
				<a href="<%=basePath %>resume.do?type=query" target="_parent">个人简历中心</a>
				<a href="<%=basePath %>logout.do" target="_parent">退出</a>
			</c:if>
			<c:if test="${!empty sessionScope.username && sessionScope.usertype==1}">
				<span>欢迎&nbsp;&nbsp;${sessionScope.username }</span>&nbsp;&nbsp;
				<a href="<%=basePath %>company.do?type=query" target="_parent">企业基本信息</a>
				<a href="<%=basePath %>logout.do" target="_parent">退出</a>
			</c:if>


		</div>
		<div class="clear"></div>
	</div>
</div>

<div class="top_main">
	<div class="top_logo"><img src="<%=basePath %>images/main_logo.png" /></div>
	<div class="top_instr">提供岗前培训的IT职位</div>
	<div class="top_tel"><img src="<%=basePath %>images/it-phone.png" /></div>
	<div class="clear"></div>
</div>

<div class="clear"></div>

</body>
</html>