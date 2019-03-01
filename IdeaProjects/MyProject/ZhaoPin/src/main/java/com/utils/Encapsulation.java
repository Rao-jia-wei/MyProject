package com.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.entity.Company;


/**
 * 封装类方法
 * @author liyunf
 *
 */
public class Encapsulation {

	//获取客户端传递数据
	public Company getRequestData(HttpServletRequest req){
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