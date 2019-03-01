<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 百度编辑器API:http://fex.baidu.com/ueditor/ -->

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>我的简历 - 锐聘网</title>
<link href="<%=basePath %>css/base.css" type="text/css" rel="stylesheet" />
<link href="<%=basePath %>css/my_resume.css" type="text/css" rel="stylesheet" />
<meta content="大学生求职,大学生就业,大学生招聘,IT人才,IT人才招聘,大学生名企招聘,,大学生找工作,IT名企招聘，IT行业招聘，IT企业快速入职" name="keywords">
<meta content="锐聘专注于为企业提供高效的人力资源解决方案，同时面向IT类技术人才推出快速一站式免费就业服务。秉承QST青软实训人才服务理念，为数千家企业量身定做个性化、全程化的人才培养体系，同时帮助中高级人才铺设成功之路，为人才和企业架设起沟通之桥。" name="description">
<script src="<%=basePath %>js/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath %>js/ueditor.all.min.js"></script>
<script src="<%=basePath %>js/lang/zh-cn/zh-cn.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-3.1.js"></script>
<script type="text/javascript">
$(function(){
	
	$(".save1").click(function(){
	alert("ddd");
			 var arr = [];
			var company_name = $("#company_name").val();
			var company_area = $("#company_area").val();
			var company_size = $("#company_size").val();
			var company_type = $("#company_type").val();
			var company_brief = arr.push(UE.getEditor('company_pic').getPlainTxt());
			var company_pic = $("#company_pic").val();
			alert("company_brief="+company_brief);
			alert("company_name="+company_name+"\ncompany_area="+company_area+"\ncompany_size="+company_size+"\ncompany_type="+company_type+"\ncompany_brief="+company_brief+"\ncompany_pic="+company_pic);
	});
	
	function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
	

});


	

</script>

</head>

<body>
<jsp:include page="../top.jsp"></jsp:include>
<div class="resume_con">
    <!--主体部分-->
    <div class="resume_main">
    	<!--左边-->
	    <div class="resume_left" style="width: 100%">
			<div class="resume_title">
				<div style="float:left">企业基本信息</div>
			</div>
			<form action="<%=basePath %>company.do?type=add" method="post" name=""> 
			<div class="all_resume" >
				<div class="table_style" style="margin-left: 0px">
					<table width="900" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="100" align="right" bgcolor="#F8F8F8">企业名称：</th>
					    <td bgcolor="#F8F8F8">
					    <!-- 	<input type="hidden" name="company_id" id="company_id" value="">
					    	<input type="hidden" name=applicant_id id="applicant_id" value=""> -->
					    	<input type="text" name="company_name" id="company_name" value="">
					    </td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="900" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="100" align="right" bgcolor="#F8F8F8">企业所在地区：</th>
					    <td bgcolor="#F8F8F8"><input type="text" name="company_area" id="company_area" value=""></td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="900" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="100" align="right" bgcolor="#F8F8F8">企业规模：</th>
					    <td bgcolor="#F8F8F8"><input type="text" name="company_size" id="company_size" value=""></td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="900" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="100" align="right" bgcolor="#F8F8F8">企业性质：</th>
					    <td bgcolor="#F8F8F8"><input type="text" name="company_type" id="company_type" value=""></td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="900" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="100" align="right" bgcolor="#F8F8F8">企业简介：</th>
					    <td bgcolor="#F8F8F8">
					    	<!-- <input type="text" name="joIntension" value=""> -->
					    	<!-- 在线编辑器 start -->
				          	<div>
								<script id="edit" type="text/plan"  id="company_brief" name="company_brief" style="width: 800px;height: 300px;"></script>
							</div>
							<!-- 在线编辑器 end -->
					    </td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="900" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="100" align="right" bgcolor="#F8F8F8">宣传图片：</th>
					    <td bgcolor="#F8F8F8">
					    	<div class="uploade">
								<div align="center">
									<img src="<%=basePath%>applicant/images/anonymous.png" width="150" height="150" id="previewImg">
									<p>&nbsp;</p>
									<input name="company_pic" id="company_pic" type="file" value="上传照片" onchange="showimage(this)">
								</div>
							</div>
					    </td>
					  </tr>
					</table>
					<div class="he"></div>
					<div class="he"></div>
					<div align="center"></div>
					<div style="margin-left:400px;"><input type="submit"  value="保存" > <!--  class="save1" -->
					<input type="reset" class="cancel2" value="取消"></div>
				</div>
				<%-- <div style="float:right" class="uploade">
					<img src="<%=basePath %>images/person_img.jpg">
					<div align="center">
						<a href="<%=basePath %>applicant/resumeBasicInfoPicUpload.jsp" class="uploade_btn">更换照片</a>
					</div>
				</div> --%>
				<div class="clear"></div>
			</div>
			</form>
	    </div>
		<div style="clear:both"></div>
	</div>
</div>

<script language="JavaScript" type="text/javascript">
	var ue = UE.getEditor('edit');
</script>

<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>
