package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CompanyDao;
import com.entity.Company;
import com.utils.Encapsulation;


/**
 * 企业信息
 * @author liyunf
 *
 */
@WebServlet("/company.do")
public class CompanyServlet extends HttpServlet {

	CompanyDao companydao = new CompanyDao();
	Company company = new Company();
	Encapsulation encap = new Encapsulation(); //封装

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
		String type = req.getParameter("type");//操作-----类别
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		company = encap.getRequestData(req);

		if("add".equals(type)){   //添加企业简历
			int company_id = companydao.add(company);
			req.setAttribute("company", company); //把企业信息对象存在请求域
			req.getRequestDispatcher("recruit/company.jsp").forward(req, resp);

		}else if("query".equals(type)){ //查询
//				int applicant_id= 0;
//				if(session.getAttribute("applicant_id") != null){
//					applicant_id =(Integer) session.getAttribute("applicant_id");
//				}
//				company = companydao.isExitCompany(applicant_id);  //通过ID进行
			req.getRequestDispatcher("recruit/company.jsp").forward(req, resp);
		}

	}


	//获取客户端传递数据
	private Company getRequestData(HttpServletRequest req){
		String company_name = req.getParameter("company_name"); //企业名称
		String company_area = req.getParameter("company_area"); // 企业所在地区
		String company_size = req.getParameter("company_size");  // 企业规模
		String company_type = req.getParameter("company_type");  // 企业性质
		String company_brief = req.getParameter("company_brief"); //企业简介
		String company_pic = req.getParameter("company_pic"); //宣传图片
		HttpSession session = req.getSession();
		int applicant_id= 0;
		if(session.getAttribute("applicant_id") != null){
			applicant_id =(Integer) session.getAttribute("applicant_id");
		}
		Company company = new Company();
		company.setApplicant_id(applicant_id);
		company.setCompany_name(company_name);
		company.setCompany_area(company_area);
		company.setCompany_size(company_size);
		company.setCompany_type(company_type);
		company.setCompany_brief(company_brief);
		company.setCompany_pic(company_pic);
		return company;
	}


}