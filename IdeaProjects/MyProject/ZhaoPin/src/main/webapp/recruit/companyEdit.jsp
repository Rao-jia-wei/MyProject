<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>“锐聘之星”软件设计大赛 - 锐聘网</title>
<link href="<%=basePath %>css/base.css" type="text/css" rel="stylesheet" />
<link href="<%=basePath %>css/company.css" type="text/css" rel="stylesheet" />
<script src="<%=basePath %>js/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath %>js/ueditor.all.min.js"></script>
<script src="<%=basePath %>js/lang/zh-cn/zh-cn.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>

<jsp:include page="../top.jsp"></jsp:include>
<div class="tn-grid">
  <div class="it-com-keyimg">
    <div class="tn-widget-content"> <img src="<%=basePath %>images/635581231315281772.jpg" /> </div>
  </div>
</div>
<div class="clear"></div>
<div class="tn-grid">
  <div class="tn-widget-content">
    <div class="tn-box-content">
      <div class="tn-helper-clearfix">
        <div class="it-main2">
          <div class="it-ctn-heading">
            <div class="it-title-line"> <span> <em> 157 </em> 浏览 </span>
              <h3> 企业简介 </h3>
            </div>
          </div>
          <div class="it-com-textnote"> <span class="kuai"> 行业：计算机软件 </span> <span class="kuai"> 所在地：南通市 </span> <span class="kuai"> 规模：1000人以上 </span> <span class="kuai"> 性质：其它 </span> </div>
          <div class="it-company-text">
          	<!-- 在线编辑器 start -->
          	<div>
				<script id="edit" type="text/plan" style="width: 960px;height: 800px;"></script>
			</div>
			<!-- 在线编辑器 end -->
			
            <!-- <p class="p1"> <strong> 一、活动主旨 </strong> </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> <strong> </strong> <span style="line-height: 1.5; font-size: 14px;"> 为培养创新精神和团队意识，切实增强理论联系实际的能力，通过本次大赛为广大同学提供一个提高自我、展示才华的平台，提高同学们的学习积极性、创新意识和勇于实践的科学精神。 </span> </p>
            <br />
            <p class="p1"> <strong> 二、活动目的 </strong> </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 1、通过竞赛形式，培养学生的创新意识、竞争精神和实际操作能力。进一步深入进行合办专业大学生精神文明建设，丰富大学生课余生活，提高大学生学习热情，激发学习欲望。 </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 2、强化学生软件设计技能，加强学生对软件应用广泛性和实用性的了解，提高学生实际开发能力，加速软件后备人才的培养。 </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 3、通过此次比赛，向RTO锐聘合作企业展现合办专业学生知识技能及风采，增加RTO锐聘合作企业对合办专业学生的认可，为未来合办专业学生择优就业奠定良好基础。 </p>
            <br />
            <p class="p1"> <strong> 四、活动时间 </strong> </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 2015年1月16日&mdash;&mdash;2015年6月13日 </p>
            <br />
            <p class="p1"> <strong> 五、参赛要求 </strong> </p>
            <br />
            <p class="p1"> 1、团队组建 </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 由学生自行进行团队组建，每个团队4名成员。每位成员对应如下职责： </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 组长：组建团队并领导团队完成比赛过程，协调团队各成员间的工作，负责收集、提交比赛所需相关材料。 </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 程序创意&amp;界面设计：负责团队程序设计的创意及程序界面设计。 </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 技术负责人：负责解决程序设计过程中的重、难点问题，并负责软件技术架构的分析与讲解。 </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 文档制作：配合其他组员完成产品设计文档、说明文档、展示demo等文件的制作。 </p>
            <br />
            <p class="p1"> 2、作品要求 </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 1）本次大赛不限命题，但必须使用C/C++作为开发语言。 </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 2）作品内容健康，丰富科学，结构清晰、创意新颖，设计技术先进。不得违反国家的有关法律、法规和规定。 </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 3）作品必须是独立的软件，最低功能项不低于10项，具备可演示的运行环境（PC、Mac、IOS、android等终端），可演示的用户界面（图形用户界面，Web界面或者命令行界面等）。 </p>
            <br />
            <p class="p1"> 3、作品提交 </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 1) 所有参赛作品请登录www.itoffer.cn&ldquo;锐聘之星&rdquo;程序设计大赛页面进行提交，提交内容需包含团队介绍、作品源代码、作品安装文件、版权说明、演示demo及相关设计文档，所有文档需以PPT形式提交，演示demo不超过15min，以.WMV格式提交；作者应自行保留备份，提交的作品不予退回。 </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 2) 提交的作品应实现设计文档中描述的基本功能，能正确运行，并给出正确结果。 </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 3) 作者必须确保作品软件和相关文档无任何知识产权纠纷，若存在任何知识产权纠纷则取消参赛资格，并由作者承担相应责任。 </p>
            <br />
            <p class="p1" style="padding-left: 30px;"> 4) 作品须为自己创作，如作品有抄袭、拷贝行为，一经发现，组委会将取消参赛者的评奖资格。 </p>
            <br /> -->
            
          </div>
          <p class="tn-helper-right"> <a href="javascript:void(0)" target="_blank" class="tn-action"> <span class="tn-icon"> </span> <span class="tn-action-text"> 成功案例 </span> </a> </p>
        </div>
      </div>
    </div>
  </div>

  <input type="hidden" id="videoListCompanyId" value="151" />
  <input type="hidden" id="companyTotalVideoCount" value='1' />
  <div class="it-content-seqbox">
    <div id="morejob"   >
      <div class="it-ctn-heading">
        <div class="it-title-line">
          <h3> 职位 </h3>
        </div>
      </div><!--职位列表-->
      <div class="it-post-box tn-border-dashed">
        <div class="it-post-name">
          <div class="tn-helper-right it-post-btn"> <a class="it-font-underline" 
href="<%=basePath %>recruit/job.jsp" target=_blank><span 
class="tn-icon-view"></span><span class=tn-action-text>查看详细</span> </a><a class="tn-button-small" 
href="#"><span 
class="tn-button-text">申请</span> </a></div>
          <h3><a title=对日Java软件开发工程师 href="job.html" 
target=_blank>对日Java软件开发工程师</a></h3>
        </div>
        <ul class="it-post">
          <li style="width:300px;">薪资： <span 
class="it-font-size">2500~4000元/月</span></li>
          <li style="width:250px;"><span class=tn-text-note>工作地区：</span>
            <LaBEL 
for="">苏州市</LaBEL>
          </li>
          <li><span class="tn-text-note">招聘人数：</span> 35 </li>
          <li><span class="tn-text-note">申请人数：</span> 5 </li>
        </ul>
      </div>
      <!--职位列表-->
    </div>
  </div>
  <div class="bottomban">
    <div class="bottombanbox"> <img src="<%=basePath %>images/635560750235172731.jpg" /> </div>
  </div>
</div>
</div>
</div>
<!-- InstanceBeginEditable name="backtop" -->
<p class="it-back-to-top" style=" position:fixed" id="backTop" title="返回顶部"> <a href="#top"> <span> </span> 返回顶部 </a> </p>
<!-- InstanceEndEditable -->
<jsp:include page="../foot.jsp"></jsp:include>
</div>

<script language="JavaScript" type="text/javascript">
	var ue = UE.getEditor('edit');
</script>

</body>
</html>