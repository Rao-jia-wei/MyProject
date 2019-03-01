<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- JSP中动态include和静态include区别:https://www.cnblogs.com/zhaideyou/p/5929930.html 
	静态导入：<%-- <%@ include file="路径" %> --%> 适合使用使用于页面全为文字，不会发生改变，全为常量
	动态导入：<jsp:include page="../top.jsp"></jsp:include> 

-->
<!doctype html> 
<html>
<head>
<meta charset="utf-8">
<title>我的简历 - 锐聘网</title>
<link href="<%=basePath %>/css/base.css" type="text/css" rel="stylesheet" />
<link href="<%=basePath %>/css/my_resume.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath %>js/jquery-3.1.js"></script>
<meta content="大学生求职,大学生就业,大学生招聘,IT人才,IT人才招聘,大学生名企招聘,,大学生找工作,IT名企招聘，IT行业招聘，IT企业快速入职" name="keywords">
<meta content="锐聘专注于为企业提供高效的人力资源解决方案，同时面向IT类技术人才推出快速一站式免费就业服务。秉承QST青软实训人才服务理念，为数千家企业量身定做个性化、全程化的人才培养体系，同时帮助中高级人才铺设成功之路，为人才和企业架设起沟通之桥。" name="description">
<script type="text/javascript">
	function showaddform(){
		$("#educationshow").hide();
		$("#educationadd").show();
		
	}
	
	$(function(){
		$("#edusave").click(function(){
		    var school = $("#school");
		    var begintime = $("#begintime");
		    var schooling = $("#schooling");
		    var profession = $("#profession");
		    if(school.val() == null || school.val() == ""){
		    	alert("毕业院校不能为空，请输入");
		    	school.focus();
		    	return false;
		    }
		    if(begintime.val()==null || begintime.val() == ""){
		    	alert("毕业时间不能为空,请输入");
		    	begintime.focus();
		    	return false;
		    }
		    if(schooling.val()==null || schooling.val() == ""){
		    	alert("学历不能为空,请输入");
		    	schooling.focus();
		    	return false;
		    }
		    if(profession.val()==null || profession.val() == ""){
		    	alert("专业不能为空,请输入");
		    	profession.focus();
		    	return false;
		    }
		   
		    $.ajax({
		    	url:"edu.do?type=add",  //url链接
		    	type:"POST",  //请求方式
		    	dataType:"JSON",  //服务器返回的数据类型
		    	data:{school:school.val(),begintime:begintime.val(),schooling:schooling.val(),profession:profession.val()},  //传递的参数
		    	success:function(data){ //返回成功的操作
		    		if(data.code=='0'){
		    			$("#educationadd").hide();
		    			var edushow = $("#educationshow");
		    			var s = "";
		    			edushow.show(); //显示教育经历di
		    			edushow.empty(); // 清空div下的所有子元素
		    			var str = "<ul><li class='tn-border-gray tn-border-bottom it-table-grid-header'>"+
		    					"<p class='tn-name'> 毕业院校</p>"+
		    					"<p class='tn-date'> 就读时间</p>"+
			           			"<p class='tn-degree'>学历</p>"+
			            		"<p class='tn-fieldofstudy'>专业</p>"+
			        			"</li>";
			        	//$(str).appendTo(edushow);
		    			//第一个参数：index 表示集合的下标。
		    			//第二个参数：集合这个对象 object对象 
		    			$.each(data.edulist,function(index,edulist){
		    				
			        		html = "<li class='tn-border-gray tn-border-bottom'>"+
					           		 	"<input type='hidden' name='education_id' value='"+edulist.education_id+"'></input>"+
					           		 	"<p class='tn-date'>"+edulist.school+"&nbsp;</p>"+
					            		"<p class='tn-date'>"+edulist.beginTime+"&nbsp;</p>"+
					            		"<p class='tn-degree' title=''>"+edulist.schooling+"</p>"+
					            		"<p class='tn-fieldofstudy' title='软件工程'>"+edulist.profession+"</p>"+
							            "<span class='tn-actions'>"+
								            "<a href='#' class='tn-action tn-action-text-icon' onclick='modify(this)'>"+
								            	"<span class='tn-icon it-icon-modify'></span><span class='tn-action-text' >修改</span>"+
								            "</a>"+
								            "<a href='<%=basePath %>edu.do?type=del&education_id="+edulist.education_id+"' class='tn-action tn-action-text-icon tn-delete'>"+
								            	"<span class='tn-icon it-icon-delete'></span><span class='tn-action-text'>删除</span>"+
								            "</a>";
							            "</span>"+
					         		"</li>";
					        s+=html;
		    			});
		    			var ul = "</ul>";
		    			var resut = str+s+ul;
		    			$(resut).appendTo(edushow);
		    		}
		    	},
		    	error:function(data){  //请求失败后的操作
		    		alert("解析失败!");
		    	}
		    });
		 });
	});
	
	//修改，获取相应的值
	function modify(obj){
	    var parent =$(obj).parent().parent(); //html dom对象  jquery对象  $()可以把Dom对象转成Jquery对象
	    var p =parent.children("p");//获取到所有的子元素<p>
	    var education_id=parent.children("input").val();//获取要修改的教育经历的id号
	     html ="<li class='tn-border-gray tn-border-bottom'>"+
    				"<p class='tn-name' title='青软实训'><input type='hidden' name='education_id' value='"+education_id+"'></input><input type='text' name='school' value='"+$(p[0]).text().trim()+"'></input></p>"+
			        "<p class='tn-date'><input type='text' name='beginTime' value='"+$(p[1]).text().trim()+"'></input></p>"+
			        "<p class='tn-degree' title='学历'><input type='text' name='schooling' value='"+$(p[2]).text().trim()+"'></input></p>"+
			        "<p class='tn-fieldofstudy' title='软件工程'><input type='text' name='profession' value='"+$(p[3]).text().trim()+"'></input></p>"+
			        "<span class='tn-actions'>"+
			        	"<a href='javascript:void(0);' class='tn-action tn-action-text-icon' onclick='update(this)'>"+
			        		"<span class='tn-icon it-icon-modify' ></span><span class='tn-action-text'>保存</span>"+
			        	"</a>"+
			        	"<a href='javascript:void(0)' class='tn-action tn-action-text-icon tn-delete' onclick='cancel(this)' >"+
			        		"<span class='tn-icon it-icon-delete'></span><span class='tn-action-text'>取消</span>"+
			        	"</a>"+
			        "</span>"+
				"</li>";
	      $(parent).after(html);
	      $(parent).remove();   
	  }
	
	  
	//修改之后，进行保存
	function update(obj) {
		var parent =$(obj).parent().parent(); //html dom对象  jquery对象  $()可以把Dom对象转成Jquery对象
		var education_id = parent.find("input[name='education_id']").val();
		var school = parent.find("input[name='school']").val();
		var begintime = parent.find("input[name='beginTime']").val();
		var schooling = parent.find("input[name='schooling']").val();
		var profession = parent.find("input[name='profession']").val();

		  $.ajax({
		    	url:"edu.do?type=update",  //url链接
		    	type:"POST",  //请求方式
		    	dataType:"JSON",  //服务器返回的数据类型
		    	data:{education_id:education_id,school:school,begintime:begintime,schooling:schooling,profession:profession},  //传递的参数
		    	success:function(data){
		    		if(data.code=="0"){
				    	html ="<li class='tn-border-gray tn-border-bottom'>"+
				    				"<p class='tn-name' title='青软实训'><input type='hidden' name='education_id' value='"+education_id+"'></input>"+school+"</p>"+
							        "<p class='tn-date'>"+begintime+"</p>"+
							        "<p class='tn-degree' title='学历'>"+schooling+"</p>"+
							        "<p class='tn-fieldofstudy' title='软件工程'>"+profession+"</p>"+
							        "<span class='tn-actions'>"+
							        	"<a href='javascript:void(0);' class='tn-action tn-action-text-icon' onclick='modify(this)'>"+
							        		"<span class='tn-icon it-icon-modify' ></span><span class='tn-action-text'>修改</span>"+
							        	"</a>"+
							        	"<a href='<%=basePath%>edu.do?type=del&education_id="+education_id+"' class='tn-action tn-action-text-icon tn-delete' >"+
							        		"<span class='tn-icon it-icon-delete'></span><span class='tn-action-text'>删除</span>"+
							        	"</a>"+
							        "</span>"+
								"</li>";

					      $(parent).after(html);
					      $(parent).remove();    
		    		}
		    	},
		    	error:function(data){
		    		alert("修改错误");
		    	}
		    	
		    });
		
	}
	
	//取消
	function cancel(obj){
		var parent =$(obj).parent().parent(); //html dom对象  jquery对象  $()可以把Dom对象转成Jquery对象
		
	}
</script>


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
				<div style="float:left">基本信息</div>
				<c:if test="${resumeInfo.basicinfoId!=0 }">
					<div class="btn"><a href="<%=basePath %>resume.do?type=update">修改</a></div>
				</c:if>
				<c:if test="${resumeInfo.basicinfoId==0 }">
					<div class="btn"><a href="<%=basePath %>applicant/resumeBasicInfoAdd.jsp">修改</a></div>
				</c:if>
			</div>
		
			<c:if test="${resumeInfo.basicinfoId!=0 }">
				<div class="all_resume">
					<div class="table_style">
						<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
						  <tr>
						    <th width="110" align="right" bgcolor="#F8F8F8">姓名：</th>
						    <td bgcolor="#F8F8F8">${resumeInfo.realName }</td>
						  </tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
						  <tr>
						    <th width="110" align="right" bgcolor="#F8F8F8">性别：</th>
						    <td bgcolor="#F8F8F8">${resumeInfo.gender}</td>
						  </tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
						  <tr>
						    <th width="110" align="right" bgcolor="#F8F8F8">出生日期：</th>
						    <td bgcolor="#F8F8F8">${resumeInfo.birthday}</td>
						  </tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
						  <tr>
						    <th width="110" align="right" bgcolor="#F8F8F8">手机：</th>
						    <td bgcolor="#F8F8F8">${resumeInfo.telephone}</td>
						  </tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
						  <tr>
						    <th width="110" align="right" bgcolor="#F8F8F8">邮件：</th>
						    <td bgcolor="#F8F8F8">${resumeInfo.email}</td>
						  </tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
						  <tr>
						    <th width="110" align="right" bgcolor="#F8F8F8">求职意向：</th>
						    <td bgcolor="#F8F8F8">${resumeInfo.joIntension}</td>
						  </tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
						  <tr>
						    <th width="110" align="right" bgcolor="#F8F8F8">工作经验：</th>
						    <td bgcolor="#F8F8F8">${resumeInfo.jobExperience}</td>
						  </tr>
						</table>
						<div class="he"></div>
					</div>
					<div style="float:right" class="uploade">
						<c:if test="${empty resumeInfo.headShot }">
							<img src="<%=basePath%>images/person_img.jpg">
						</c:if>
						<c:if test="${!empty resumeInfo.headShot }">
							<img src="<%=basePath%>applicant/images/${resumeInfo.headShot}" width="110px" height="110px">
						</c:if>
						
						<div align="center">
							<a href="<%=basePath %>applicant/resumeBasicInfoPicUpload.jsp" class="uploade_btn">更换照片</a>
						</div>
					</div>
					<div class="clear"></div>
				</div> 
			
			</c:if>
			
			<div class="resume_title" >
				<div style="float:left">教育经历</div>
				<div class="btn"><a href="javascript:void(0);" onclick="showaddform();">添加</a></div>
			</div>
			<!-- 显示教育经历 -->
			<div class="it-table-grid"   id="educationshow">
		    	<ul>
			        <li class="tn-border-gray tn-border-bottom it-table-grid-header">
			            <p class="tn-name">
			                毕业院校</p>
			            <p class="tn-date">
			                就读时间</p>
			            <p class="tn-degree">
			                学历</p>
			            <p class="tn-fieldofstudy">
			                专业</p>
			        </li>
			        <c:if test="${!empty edulist }">
			        	 <c:forEach items="${edulist }" var="education">
			        		<li class="tn-border-gray tn-border-bottom">
			        		<input type="hidden" name="education_id" value="${education.education_id }"></input>
					            <p class="tn-name" title="青软实训">
					               ${ education.school}                   
					            </p>
					            <p class="tn-date">  ${ education.beginTime}</p>
					            <p class="tn-degree" title="">
					                  ${ education.schooling}&nbsp;
					            </p>
					            <p class="tn-fieldofstudy" title="软件工程">
					                  ${ education.profession}&nbsp;
					            </p>
					            <span class="tn-actions">
						            <a href="javascript:void(0);" class="tn-action tn-action-text-icon" onclick="modify(this)">
						            	<span class="tn-icon it-icon-modify"></span><span class="tn-action-text">修改</span>
						            </a>
						            <a href="<%=basePath %>edu.do?type=del&education_id=${education.education_id}" class="tn-action tn-action-text-icon tn-delete">
						            	<span class="tn-icon it-icon-delete"></span><span class="tn-action-text">删除</span>
						            </a>
					            </span>
					          </li>
			        
			        	</c:forEach>
			        </c:if>
				</ul>
			</div>
			<!-- 显示教育经历 -->
			
			<!-- 添加教育经历 开始-->
            <div class="it-table-grid" id="educationadd" style="display:none;">
				<div class="all_resume" >
					<div class="table_style" style="margin-left:20%">
						<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
						  <tr>
						    <th width="110" align="right" bgcolor="#F8F8F8">毕业院校：</th>
						    <td bgcolor="#F8F8F8"><input type="text" name="school" id="school" ></td>
						  </tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
						  <tr>
						    <th width="110" align="right" bgcolor="#F8F8F8">开始时间：</th>
						    <td bgcolor="#F8F8F8"><input type="text" name="begintime" id="begintime"></td>
						  </tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
						  <tr>
						    <th width="110" align="right" bgcolor="#F8F8F8">学历：</th>
						    <td bgcolor="#F8F8F8"><input type="text" name="schooling" id="schooling" ></td>
						  </tr>
						</table>
						
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
						  <tr>
						    <th width="110" align="right" bgcolor="#F8F8F8">专业：</th>
						    <td bgcolor="#F8F8F8"><input type="text" name="profession" id="profession"></td>
						  </tr>
						</table>
						
						<div class="he"></div>
						<div style="margin-left:100px;"><input type="button" class="save1" id="edusave" value="保存"> 
						<input  type="text" class="cancel2" value="取消"></div>
					</div>
					<!-- <div style="float:right" class="uploade"><img src="../images/person_img.jpg">
						<div align="center">
							<a href="#" class="uploade_btn">更换照片</a>
						</div>
					</div> -->
					<div class="clear"></div>
				</div>
            </div>
			<!-- 添加教育经历end-->

				
			
			
			
			
			
			

			<div class="resume_title">
				<div style="float:left">工作经历</div>
				<div class="btn">添加</div>
			</div>
			<div class="it-table-grid">
		    	<ul>
			        <li class="tn-border-gray tn-border-bottom it-table-grid-header">
			            <p class="tn-name">
			                工作公司	</p>
			            <p class="tn-date">
			                在职时间</p>
			            <p class="tn-degree">
			                部门</p>
			            <p class="tn-fieldofstudy">
			                职位名称</p>
			        </li>
					<li class="tn-border-gray tn-border-bottom">
			            <p class="tn-name" title="青软实训">
			                青软实训                   
			            </p>
			            <p class="tn-date">2013/10-2014/10</p>
			            <p class="tn-degree" title="">
			                 研发部
			            </p>
			            <p class="tn-fieldofstudy" title="软件工程">
			                软件开发工程师
			            </p>
			            <span class="tn-actions"><a href="#" class="tn-action tn-action-text-icon">
			            <span class="tn-icon it-icon-modify"></span><span class="tn-action-text">修改</span>
			            </a>
			            <a href="" class="tn-action tn-action-text-icon tn-delete">
			            <span class="tn-icon it-icon-delete"></span><span class="tn-action-text">删除</span>
			            </a></span>
			           </li>    
		       
				</ul>
			</div>

			<div class="resume_title">
				<div style="float:left">项目经验</div>
				<div class="btn">添加</div>
			</div>
			<div class="it-table-grid">
		    	<ul>
			        <li class="tn-border-gray tn-border-bottom it-table-grid-header">
			            <p class="tn-name">
			                项目名称	</p>
			            <p class="tn-date">
			                参与时间</p>
			            <p class="tn-degree">
			                担任职位</p>
			        </li>
					    
		       
				</ul>
			</div>
			<div class="resume_title">
				<div style="float:left">培训经历</div>
				<div class="btn">添加</div>
			</div>
			<div class="it-table-grid">
		    	<ul>
			        <li class="tn-border-gray tn-border-bottom it-table-grid-header">
			            <p class="tn-name">
			                培训名称	</p>
			            <p class="tn-date">
			                培训时间</p>
			            
			        </li>

		       
				</ul>
			</div>
			<div class="resume_title">
				<div style="float:left">获得证书</div>
				<div class="btn">添加</div>
			</div>
			<div class="it-table-grid">
		    	<ul>
			        <li class="tn-border-gray tn-border-bottom it-table-grid-header">
			            <p class="tn-name">
			                证书名称	</p>
			            
			        </li>

		       
				</ul>
			</div>
			<div class="resume_title">
				<div style="float:left">语言能力</div>
				<div class="btn">添加</div>
			</div>

			<div class="it-table-grid">
		    	<ul>
			        <li class="tn-border-gray tn-border-bottom it-table-grid-header">
			            <p class="tn-name">
			                语言	</p>
			            <p class="tn-date">
			                听说</p>
			            <p class="tn-degree">
			                读写</p>
			            <p class="tn-fieldofstudy">
			                等级考试</p>
			        </li>
					<li class="tn-border-gray tn-border-bottom">
			            <p class="tn-name" title="英语">
			                英语                   
			            </p>
			            <p class="tn-date">熟练</p>
			            <p class="tn-degree" title="">
			                 熟练
			            </p>
			            <p class="tn-fieldofstudy" title="CET-6">
			                CET-6
			            </p>
			            <span class="tn-actions"><a href="#" class="tn-action tn-action-text-icon">
			            <span class="tn-icon it-icon-modify"></span><span class="tn-action-text">修改</span>
			            </a>
			            <a href="" class="tn-action tn-action-text-icon tn-delete">
			            <span class="tn-icon it-icon-delete"></span><span class="tn-action-text">删除</span>
			            </a></span></li>    
		       
				</ul>
			</div>	
			<div class="resume_title">
				<div style="float:left">IT技能</div>
				<div class="btn">添加</div>
			</div>
			<div class="it-table-grid">
		    	<ul>
			        <li class="tn-border-gray tn-border-bottom it-table-grid-header">
						<p class="tn-auto">
		                技能名称</p>

			            <p class="tn-name">
		                熟练程度</p>
			        </li>
					<li class="tn-border-gray tn-border-bottom">
			            <p class="tn-auto">
		                    Oracle</p>
			            <p class="tn-name">
		                    熟练</p>
			            <span class="tn-actions"><a href="#" class="tn-action tn-action-text-icon">
			            <span class="tn-icon it-icon-modify"></span><span class="tn-action-text">修改</span>
			            </a>
			            <a href="" class="tn-action tn-action-text-icon tn-delete">
			            <span class="tn-icon it-icon-delete"></span><span class="tn-action-text">删除</span>
			            </a></span></li>    
					<li class="tn-border-gray tn-border-bottom">
			            <p class="tn-auto">
		                    JavaEE</p>
			            <p class="tn-name">
		                    熟练</p>
			            <span class="tn-actions"><a href="#" class="tn-action tn-action-text-icon">
			            <span class="tn-icon it-icon-modify"></span><span class="tn-action-text">修改</span>
			            </a>
			            <a href="" class="tn-action tn-action-text-icon tn-delete">
			            <span class="tn-icon it-icon-delete"></span><span class="tn-action-text">删除</span>
			            </a></span></li>    
					<li class="tn-border-gray tn-border-bottom">
			            <p class="tn-auto">
		                    Java</p>
			            <p class="tn-name">
		                    熟练</p>
			            <span class="tn-actions"><a href="#" class="tn-action tn-action-text-icon">
			            <span class="tn-icon it-icon-modify"></span><span class="tn-action-text">修改</span>
			            </a>
			            <a href="" class="tn-action tn-action-text-icon tn-delete">
			            <span class="tn-icon it-icon-delete"></span><span class="tn-action-text">删除</span>
			            </a></span></li>    
		       
				</ul>
			</div>	
			<div class="resume_title">
				<div style="float:left">其他信息</div>
				<div class="btn">添加</div>
			</div>
			<div class="it-table-grid">
		    	<ul>
			        <li class="tn-border-gray tn-border-bottom it-table-grid-header">
			            <p class="tn-name">
		                标题</p>
			            <p class="tn-auto">
		                描述</p>
			        </li>


		       
				</ul>
			</div>
			<div class="resume_title">
				<div style="float:left">简历附件</div>
				<div class="btn">添加</div>
			</div>
			<div class="it-table-grid">
				<div class="it-table-grid">
					暂无附件！</div>
			</div>	

		
	    </div>
    	<!--右边-->
		<jsp:include page="resume_right.jsp"></jsp:include>

		<div style="clear:both"></div>
	</div>
</div>
<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>
