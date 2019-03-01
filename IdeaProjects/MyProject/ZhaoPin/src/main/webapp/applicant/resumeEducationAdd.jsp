<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>我的简历 - 锐聘网</title>
<link href="<%=basePath %>css/base.css" type="text/css" rel="stylesheet" />
<link href="<%=basePath %>css/my_resume.css" type="text/css" rel="stylesheet" />
<meta content="大学生求职,大学生就业,大学生招聘,IT人才,IT人才招聘,大学生名企招聘,,大学生找工作,IT名企招聘，IT行业招聘，IT企业快速入职" name="keywords">
<meta content="锐聘专注于为企业提供高效的人力资源解决方案，同时面向IT类技术人才推出快速一站式免费就业服务。秉承QST青软实训人才服务理念，为数千家企业量身定做个性化、全程化的人才培养体系，同时帮助中高级人才铺设成功之路，为人才和企业架设起沟通之桥。" name="description">

</head>

<body>
<jsp:include page="../top.jsp"></jsp:include>
<div class="resume_con">
	<!--tab设置-->
	<div class="user_operate">
		<ul style="float:left">
			<li><a href="resume.jsp" class="active">我的简历</a></li>
			<li><a href="jobApply.jsp">我的申请</a></li>
			<div class="clear"></div>
		</ul>
		<div class="clear"></div>
	</div>
    <!--主体部分-->
    <div class="resume_main">
    	<!--左边-->
	    <div class="resume_left">
			<div class="resume_title">
				<div style="float:left">教育经历</div>
			</div>
			<form action="<%=basePath %>edu.do?type=add" method="post" name="">
			<div class="all_resume" >
				<div class="table_style" style="margin-left: 150px">
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">毕业院校：</th>
					    <td bgcolor="#F8F8F8"><input type="text" name="school" value=""></td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">就读时间：</th>
					    <td bgcolor="#F8F8F8"><input type="text" name="begintime" value=""></td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">学历：</th>
					    <td bgcolor="#F8F8F8"><input type="text" name="schooling" value=""></td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">专业：</th>
					    <td bgcolor="#F8F8F8"><input type="text" name="profession" value=""></td>
					  </tr>
					</table>
					<div class="he"></div>
					<div class="he"></div>
					<div align="center"></div>
					<div style="margin-left:100px;"><input type="submit" class="save1" value="保存"> 
					<input type="reset" class="cancel2" value="取消"></div>
				</div>

				<div class="clear"></div>
			</div>
			</form>
	    </div>
    	<!--右边-->
		<jsp:include page="resume_right.jsp"></jsp:include>
		<div style="clear:both"></div>
	</div>
</div>

<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>
