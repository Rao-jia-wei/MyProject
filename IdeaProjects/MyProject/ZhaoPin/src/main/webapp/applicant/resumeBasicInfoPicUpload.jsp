<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>我的简历 - 锐聘网</title>
<link href="../css/base.css" type="text/css" rel="stylesheet" />
<link href="../css/my_resume.css" type="text/css" rel="stylesheet" />
<meta content="大学生求职,大学生就业,大学生招聘,IT人才,IT人才招聘,大学生名企招聘,,大学生找工作,IT名企招聘，IT行业招聘，IT企业快速入职" name="keywords">
<meta content="锐聘专注于为企业提供高效的人力资源解决方案，同时面向IT类技术人才推出快速一站式免费就业服务。秉承QST青软实训人才服务理念，为数千家企业量身定做个性化、全程化的人才培养体系，同时帮助中高级人才铺设成功之路，为人才和企业架设起沟通之桥。" name="description">
<script type="text/javascript">
	function validate() {
		var headShot = document.getElementById("headShot");
		if (headShot.value == "") {
			alert("请选择要上传的头像！");
			headShot.focus();
			return false;
		}
		return true;
	}
	
	function showimage(obj){
		//判断是否支持FileReader
      if (window.FileReader) {
          var reader = new FileReader();
      } else {
          alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
      }

      //获取文件
      var file = obj.files[0];
      var imageType = /^image\//;
      //是否是图片
      if (!imageType.test(file.type)) {
          alert("请选择图片！");
          //return;
      }
      //读取完成
      reader.onload = function(e) {
          //获取图片dom
          var img = document.getElementById("previewImg");
          //图片路径设置为读取的图片
          img.src = e.target.result;
      };
      reader.readAsDataURL(file);
	
	}
</script>
</head>
<body>
	<jsp:include page="../top.jsp"></jsp:include>

	<!-- 简历照片上传页面 开始 -->
	<div class="resume_con">
		<!--tab设置-->
		<div class="user_operate">
			<ul style="float: left">
			  <li> <a href="resume.jsp">我的简历</a></li>
              <li class="tn-tabs-selected"> <a href="jobApply.jsp">我的申请</a></li>
			</ul>
			<div class="clear"></div>
		</div>
		<!--主体部分-->
		<div class="resume_main">
			<!--左边-->
			<div class="resume_left">
				<div class="resume_title">
					<div style="float: left">简历照片</div>
				</div>
				<div class="all_resume">
					<!--------------------- 简历照片修改    上传文件：enctype="multipart/form-data"------------------------->
					<form action="<%=basePath %>resumeupload.do" method="post"
						enctype="multipart/form-data" onsubmit="return validate();">
						<div class="table_style" style="margin-left: 150px;">
							<div class="uploade">
								<div align="center">
									<img src="<%=basePath%>applicant/images/anonymous.png" width="150" height="150" id="previewImg">
									<p>&nbsp;</p>
									<input name="headShot" id="headShot" type="file" value="上传照片" onchange="showimage(this)">
								</div>
							</div>
							<div class="clear"></div>
							<div class="he"></div>
							<div align="center">
								<input name="submit" type="submit" class="save1" value="保存"> 
								<input name="reset" type="reset" class="cancel2" value="取消">
							</div>
						</div>
					</form>
					<!--------------------- 简历照片修改 结束---------------------->
				</div>
			</div>
			<!--右边-->
		<jsp:include page="resume_right.jsp"></jsp:include>
		<div style="clear:both"></div>
		</div>
	</div>
	<!-- 我的简历页面结束 -->
	<!-- 网站公共尾部 -->
	<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>