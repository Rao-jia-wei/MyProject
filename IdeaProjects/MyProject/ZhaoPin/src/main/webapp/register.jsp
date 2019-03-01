<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>注册 - 锐聘网</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/register.css" type="text/css" rel="stylesheet" />
<meta content="大学生求职,大学生就业,大学生招聘,IT人才,IT人才招聘,大学生名企招聘,,大学生找工作,IT名企招聘，IT行业招聘，IT企业快速入职" name="keywords">
<meta content="锐聘专注于为企业提供高效的人力资源解决方案，同时面向IT类技术人才推出快速一站式免费就业服务。秉承QST青软实训人才服务理念，为数千家企业量身定做个性化、全程化的人才培养体系，同时帮助中高级人才铺设成功之路，为人才和企业架设起沟通之桥。" name="description">

<script type="text/javascript">
	//点击看不清文字，改变验证码
	function changecode(img){
		var img = document.getElementById("img");
		img.src = "code.do" + "?" + new Date().getTime();
	}
	
	//验证邮箱、密码、验证码、条款是否为空或者长度
	//邮箱正则表达式:/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
	//密码正则表达式:
	function validate(){
		var email = document.getElementById("email");
		
		var password = document.getElementById("password");
		
		var code = document.getElementById("code");
		
		var agree = document.getElementById("agree");  //条款
		
		var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z])+/;  //邮箱验证
		
		if(email.value == ""){
			alert("邮箱不能为空!");
			email.focus(); 
			return false;
		}else if(!pattern.test(email.value)){
			alert("邮箱格式错误，请输入正确的邮箱格式！");
			email.focus(); 
			return false;
		}
		
		if(password.value == ""){
			alert("密码不能为空！");
			password.focus(); 
			return false;
		}else if(!(password.value.length>=6 && password.value.length<=12)){
			alert("密码应在6-12位密码！");
			password.focus(); 
			return false;
		}
		
		if(code.value==""){
			alert("验证不能为空！");
			code.focus(); 
			return false;
		}
	
		if(!agree.checked){
			alert("请先同意本站服务条款！");
			return false;
		}
	}
</script>

</head>

<body>
<jsp:include page="top.jsp"></jsp:include>
<div class="content">
  <div class="page_name">注册</div>
  <div class="login_content">
  
  <form action="register.do" method="post" onsubmit="return validate();">
    <div class="login_l">
      <div class="span1">
        <label class="tn-form-label">邮箱：</label>
        <input  class="tn-textbox" type="text" name="email" id="email">
      </div>
      <div class="span1">
        <label class="tn-form-label">密码：</label>
        <input class="tn-textbox"  type="password" name="password" id="password">
      </div>
      <div class="span1">
        <label class="tn-form-label">用户类型：</label>
        <input type="radio" name="usertype" id="usertype" checked="checked" value="0">个人用户&nbsp;&nbsp;
        <input type="radio" name="usertype" id="usertype" value="1">企业用户
      </div>
      <div class="span1">
        <label class="tn-form-label">验证码：</label>
        <input class="tn-textbox-long"  type="text"  id="code" name="code" />
        <span> <img src="code.do" title="点击换一换" id="img" onclick="changecode(this)"><a href="javascript:;" onclick="changecode(this)" >看不清？</a> </span> 
      </div>
        
      <div class="tn-form-row-button">
        <div class="span1">
          <input name="" type="submit" class="tn-button-text" value="立即注册">
          <p class="it-register-text">
            <input  name="" id="agree" class="tn-checkbox" value="true" checked="checked" type="checkbox">
            <label > 同意本站服务条款</label>
            <a href="javascript:;">查看</a> </p>
        </div>
      </div>
      <div class="clear"></div>
    </div>
   </form>
   
    <div class="register_r">
      <p align="center"> <b>还没有帐号？</b><a  href="register.jsp">10秒钟快速注册</a></p>
    
      <div><img src="images/reg_pic.jpg"></div>
    
      <div class="clear"></div>
    </div>
    <div class="clear"></div>
  </div>
</div>
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
