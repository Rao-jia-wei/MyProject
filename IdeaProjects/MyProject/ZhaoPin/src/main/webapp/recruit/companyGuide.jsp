<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>“锐聘之星”软件设计大赛 - 锐聘网</title>
<link href="<%=basePath %>/css/base.css" type="text/css" rel="stylesheet" />
<style>
.success_content {
	width: 1000px;
	background: #fff;
	margin: 15px auto;
	box-shadow: 0 1px 3px #999;
	font-family: microsoft yahei;
}
.success_left {
	background: url(<%=basePath %>/images/it-line03.png) repeat;
	width: 360px;
	float: left;
	height: 300px;
}
.success_left h3 {
	color: #19a8b6;
}
.success_right {
	float: left;
	text-align: center;
	width: 600px;
	padding-top: 50px;
}
.it-pageimg {
	background: url(<%=basePath %>/images/it-img.png) no-repeat -710px -40px;
	height: 160px;
	width: 160px;
	margin: 30px 0px 0px 70px;
}
.green16 {
	font-size: 16px;
	color: #19a8b6;
}
.tn-button {
	background: url(<%=basePath %>/images/it-button.png) no-repeat -205px -10px;
	height: 45px;
	width: 146px;
	font-size: 16px;
	display: inline-block;
	text-align: center;
	color: white;
	line-height: 45px;
}
.tn-button:hover {
	background: url(<%=basePath %>/images/it-button.png) no-repeat -205px -65px;
	width: 146px;
	height: 45px;
}
.success_right p {
	line-height: 50px;
}
.success_right p span {
	margin-left: 20px;
}
</style>
<body>
<jsp:include page="../top.jsp"></jsp:include>
<div class="success_content">
  <div class="success_left">
    <div class=it-pageimg></div>
    <h3 align="center">登录成功！</h3>
  </div>
  <div class="success_right">
    <p class="green16">需要先填写企业信息，才能发布招聘职位哟！</p>
    <p>快快选择以下任意一种方式完善企业信息，去寻找精英人才吧！</p>
    <p><a href="<%=basePath%>/recruit/companyadd.jsp"><span class="tn-button">填写企业基本信息</span></a>
	    <a href="<%=basePath%>index.jsp">
	    	<span class="tn-button">站点首页</span>
	    </a>
    </p>
  </div>
  <div class="clear"></div>
</div>
<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>

