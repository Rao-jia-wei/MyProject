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
<link href="<%=basePath %>css/base.css" type="text/css" rel="stylesheet" />
<link href="<%=basePath %>css/applysuccess.css" type="text/css" rel="stylesheet" />
<body>
<jsp:include page="../top.jsp"></jsp:include>
<div class="applyit-content-box">
  <div class="it-success-tips">
    <div class="it-success-icon">
      <div class="it-pageimg"> </div>
    </div>
    <div class="it-success-word"> <a href="#" title="恭喜您成功申请职位！">恭喜您成功申请职位！</a> <br>
      锐聘网会在3-5天内跟您取得联系。
      <p> 企业：<a href="#"><b>无锡晟奥软件有限公司</b></a><br>
        职位：<a href="#"><b>对日Cobol软件开发工程师</b></a></p>
    </div>
    <div class="clear"></div>
  </div>
  <div class="it-more-actions">
    <p class="tn-text-note"> 接下来您可以：</p>
    <div class="it-comment-btn"> <a href="http://www.itoffer.cn" class="app_btn"> <span class="tn-icon it-icon-arrow"></span><span class="tn-button-text">申请其他职位</span> </a> </div>
  </div>
  <div class="it-secondary-link">
    <ul>
      <li><span class="it-icon-view"></span> <a href="#" title="查看我的职位申请">查看我的职位申请</a> </li>
      <li><span class="it-icon-modify"></span> <a href="#" title="修改我的简历">修改我的简历</a> </li>
    </ul>
  </div>
</div>
<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>

