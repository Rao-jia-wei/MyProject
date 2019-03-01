<%@page import="com.utils.CookieEncrypTool"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登录 - 锐聘网</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/login.css" type="text/css" rel="stylesheet" />
<meta content="大学生求职,大学生就业,大学生招聘,IT人才,IT人才招聘,大学生名企招聘,,大学生找工作,IT名企招聘，IT行业招聘，IT企业快速入职" name="keywords">
<meta content="锐聘专注于为企业提供高效的人力资源解决方案，同时面向IT类技术人才推出快速一站式免费就业服务。秉承QST青软实训人才服务理念，为数千家企业量身定做个性化、全程化的人才培养体系，同时帮助中高级人才铺设成功之路，为人才和企业架设起沟通之桥。" name="description">
</head>

<%
	String applicant_email = "";
	String applicant_password = "";
	//获取对象的值,request、response是系统内置变量，无需定义
	Cookie[] cookies = request.getCookies(); 
	if(cookies != null){
		for(Cookie cookie:cookies){
			if("cookie_applicantemail".equals(cookie.getName())){
				applicant_email = CookieEncrypTool.decodeBase64(cookie.getValue());
			}
			
			if("cookie_applicantepassword".equals(cookie.getName())){
				applicant_password = CookieEncrypTool.decodeBase64(cookie.getValue());
			}
		}
	}
 %>

<body>
<jsp:include page="top.jsp"></jsp:include>
<div class="content">
  <div class="page_name">登陆</div>
  <div class="login_content">
  
  <form action="login.do" method="post" name="form1">
    <div class="login_l">
      <p class="font14">使用注册邮箱登录</p>
      <div class="span1">
        <label class="tn-form-label">邮箱：</label>
        <input  class="tn-textbox" type="text" name="email" value="<%=applicant_email%>">
      </div>
      <div class="span1">
        <label class="tn-form-label">密码：</label>
        <input class="tn-textbox"  type="password" name="password" value="<%=applicant_password%>">
      </div>
      <div class="tn-form-row-button">
        <div class="span1">
          <input name="" type="submit" class="tn-button-text" value="登   录">
          <span class="it-register-text">
          <input checked="checked" class="tn-checkbox" value="true" type="checkbox" name="rememberMe">
          <label for="RememberPassword"> 记住密码</label>
          </span> </div>
      </div>
      <div class="clear"></div>
    </div>
   </form>
    
    <div class="login_r">
      <p align="center"> <b>还没有帐号？</b><a  href="register.jsp">10秒钟快速注册</a></p>
    
      <div><img src="images/login_pic.jpg"></div>
    
      <div class="clear"></div>
    </div>
    <div class="clear"></div>
  </div>
</div>
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>

