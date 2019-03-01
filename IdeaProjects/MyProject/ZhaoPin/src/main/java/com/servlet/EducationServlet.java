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

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

import com.dao.EducationDao;
import com.dao.ResumeDao;
import com.entity.Education;
import com.entity.ResumeBasicinfo;

/**
 * 教育经历
 * @author liyunf
 *
 */
@WebServlet("/edu.do")
public class EducationServlet extends HttpServlet {

	EducationDao edudao = new EducationDao();
	ResumeDao resumdao = new ResumeDao();

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

		if("add".equals(type)){
			Education education = getRequestData(req);
			int applicant_id = 0;
			if(session.getAttribute("applicant_id")!=null){
				applicant_id =(Integer) session.getAttribute("applicant_id");
			}
			edudao.save(education); //执行添加教育经历，执行后需要返回列表(这个时候执行查询操作)
			//获取教育经历基本信息
			List<Education> edulist = edudao.getEducationList(applicant_id);
			//req.setAttribute("edulist", edulist);

			/*---------------json----------------*/
			JSONObject json = new JSONObject();  //产生一个json对象
			try {
				JSONArray josnarry =JSONArray.fromObject(edulist);  //这个集合需要返回到页面
				json.put("edulist", josnarry);
				json.put("code", "0");
				json.put("message", "添加成功");
				System.out.println(josnarry.toString());
			} catch (Exception e) {
				// TODO: handle exception
				json.put("code", "1");
				json.put("message", "添加失败");
				e.printStackTrace();
			}
			out.println(json.toString());  //输出到页面中
			/*---------------json----------------*/

		}else if("update".equals(type)){ //修改后，返回的页面
			Education education = getRequestData(req);
			String education_id = req.getParameter("education_id");
			education.setEducation_id(Integer.parseInt(education_id));
			edudao.update(education);
			JSONObject json = new JSONObject();  //产生一个json对象
			try {
				json.put("code", "0");
				json.put("message", "添加成功");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				json.put("code", "1");

				json.put("message", "添加失败");
			}
			out.println(json.toString());  //输出到页面中

		}else if("del".equals(type)){ //删除教育经历
			//获取简历基本信息
			int education_id =Integer.parseInt(req.getParameter("education_id").toString());
			edudao.delete(education_id);
			resp.sendRedirect("resume.do?type=query");
		}

	}

	/**
	 * 封装
	 * @param req
	 * @return
	 */
	private Education getRequestData(HttpServletRequest req){
		HttpSession session = req.getSession();
		String school = req.getParameter("school");
		String begintime = req.getParameter("begintime");
		String schooling = req.getParameter("schooling");
		String profession = req.getParameter("profession");
		//容易抛空指针
		int applicant_id=0;
		if(session.getAttribute("applicant_id")!=null){
			applicant_id = (Integer) session.getAttribute("applicant_id");
		}
		Education education = new Education(applicant_id,school,
				begintime,schooling,profession);
		return education;
	}


}