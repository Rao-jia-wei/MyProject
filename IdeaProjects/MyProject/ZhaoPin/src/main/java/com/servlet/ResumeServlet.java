package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.dao.EducationDao;
import com.dao.ResumeDao;
import com.entity.Education;
import com.entity.ResumeBasicinfo;

@WebServlet("/resume.do")
public class ResumeServlet extends HttpServlet {

	EducationDao edudao = new EducationDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = req.getParameter("type");//操作类别
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		ResumeDao resumdao = new ResumeDao();
		if("add".equals(type)){//添加简历
			Object applicant_id = session.getAttribute("applicant_id"); //取得登录保留的数据
			ResumeBasicinfo basicinfo = requestGetData(req);
			int basicinfo_id = resumdao.add(basicinfo, Integer.parseInt(applicant_id.toString()));
			session.setAttribute("baseinfo_id",basicinfo_id);  //把简历信息ID存在session中
			ResumeBasicinfo resumeInfo = resumdao.queryResuemBasicInfo(basicinfo_id); //获取简历基本信息
			//存储基本信息对象放到request对象中
			req.setAttribute("resumeInfo", resumeInfo);
			//请求转发
			req.getRequestDispatcher("applicant/resume.jsp").forward(req, resp);
		}else if("query".equals(type)){ //查询简历（进入个人简历中心）
			//显示教育经历数据
			int applicant_id = 0;
			if(session.getAttribute("applicant_id")!=null){
				applicant_id =(Integer) session.getAttribute("applicant_id");
			}
			List<Education> edulist = edudao.getEducationList(applicant_id);
			req.setAttribute("edulist", edulist);

			//显示个人信息
			int bascinfo_id = 0;
			if(session.getAttribute("baseinfo_id")!=null){
				bascinfo_id =(Integer) session.getAttribute("baseinfo_id");
			}
			ResumeBasicinfo resumeInfo = resumdao.queryResuemBasicInfo(bascinfo_id); //获取简历基本信息
			//存储基本信息对象放到request对象中
			req.setAttribute("resumeInfo", resumeInfo);
			//请求转发
			req.getRequestDispatcher("applicant/resume.jsp").forward(req, resp);
		}else if("update".equals(type)){ //个人简历的修改
			int bascinfo_id = 0;
			if(session.getAttribute("baseinfo_id")!=null){
				bascinfo_id =(Integer) session.getAttribute("baseinfo_id");
			}
			ResumeBasicinfo resumeInfo = resumdao.queryResuemBasicInfo(bascinfo_id); //获取简历基本信息
			//存储基本信息对象放到request对象中
			req.setAttribute("resumeInfo", resumeInfo);
			req.getRequestDispatcher("applicant/resumeBasicinfoUpdate.jsp").forward(req, resp);
		}else if("modify".equals(type)){//修改
			ResumeBasicinfo basicinfo = RequestModfiyData(req); //获取基本信息
			resumdao.update(basicinfo);
			resp.sendRedirect("resume.do?type=query");
		}


	}

	//获取客户端传递数据
	private ResumeBasicinfo requestGetData(HttpServletRequest req){

		String realName = req.getParameter("realName");

		String gender =  req.getParameter("gender");

		String birthday =  req.getParameter("birthday");; //出生日期

		String telephone =  req.getParameter("telephone"); //手机

		String email =  req.getParameter("email"); //邮箱

		String joIntension =  req.getParameter("joIntension"); //求职意向

		String jobExperience =  req.getParameter("jobExperience"); //工作经验

//		String headShot =  req.getParameter("headShot"); //头像

		String currentLoc =  req.getParameter("currentLoc"); //当前所在地

		String residentLog =  req.getParameter("residentLog"); //户口所在地

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date birhdayDate = null;

		try {
			birhdayDate =sdf.parse(birthday);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		ResumeBasicinfo resumeBasicinfo = new ResumeBasicinfo(realName,  gender,  birhdayDate,
				currentLoc,  residentLog,  telephone,
				email,  joIntension,  jobExperience);

		return resumeBasicinfo;

	}

	//获取客户端传递数据
	private ResumeBasicinfo RequestModfiyData(HttpServletRequest req){

		String basicinfoId = req.getParameter("basicinfoId");

		String applicantId =  req.getParameter("applicantId");

		String realName = req.getParameter("realName");

		String gender =  req.getParameter("gender");

		String birthday =  req.getParameter("birthday");; //出生日期

		String telephone =  req.getParameter("telephone"); //手机

		String email =  req.getParameter("email"); //邮箱

		String joIntension =  req.getParameter("joIntension"); //求职意向

		String jobExperience =  req.getParameter("jobExperience"); //工作经验

		String headShot =  req.getParameter("headShot"); //头像

		String currentLoc =  req.getParameter("currentLoc"); //当前所在地

		String residentLog =  req.getParameter("residentLog"); //户口所在地

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date birhdayDate = null;

		try {
			birhdayDate =sdf.parse(birthday);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		ResumeBasicinfo resumeBasicinfo = new ResumeBasicinfo(realName,  gender,  birhdayDate,
				currentLoc,  residentLog,  telephone,
				email,  joIntension,  jobExperience);

		resumeBasicinfo.setApplicantId(Integer.parseInt(applicantId));
		resumeBasicinfo.setBasicinfoId(Integer.parseInt(basicinfoId));

		return resumeBasicinfo;

	}
}