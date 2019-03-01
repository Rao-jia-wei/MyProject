package com.entity;

/**
 * 企业信息
 * @author liyunf
 *
 */
public class Company {

	private int company_id;  //企业ID

	private int applicant_id;  //求职者ID

	private String company_name; //企业名称

	private String company_area; // 企业所在地区

	private String company_size; // 企业规模

	private String company_type; // 企业性质

	private String company_brief; // 企业简介

	private int company_stater;  // 招聘状态:1招聘中 2已暂停 3已结束

	private int company_sort; // 排序序号

	private int company_viewnum; // 浏览数

	private String company_pic; // 宣传图片

	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(int company_id, int applicant_id, String company_name,
				   String company_area, String company_size, String company_type,
				   String company_brief, int company_stater, int company_sort,
				   int company_viewnum, String company_pic) {
		super();
		this.company_id = company_id;
		this.applicant_id = applicant_id;
		this.company_name = company_name;
		this.company_area = company_area;
		this.company_size = company_size;
		this.company_type = company_type;
		this.company_brief = company_brief;
		this.company_stater = company_stater;
		this.company_sort = company_sort;
		this.company_viewnum = company_viewnum;
		this.company_pic = company_pic;
	}

	public Company(String company_name, String company_area,
				   String company_size, String company_type, String company_brief,
				   String company_pic) {
		super();
		this.company_name = company_name;
		this.company_area = company_area;
		this.company_size = company_size;
		this.company_type = company_type;
		this.company_brief = company_brief;
		this.company_pic = company_pic;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public int getApplicant_id() {
		return applicant_id;
	}

	public void setApplicant_id(int applicant_id) {
		this.applicant_id = applicant_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_area() {
		return company_area;
	}

	public void setCompany_area(String company_area) {
		this.company_area = company_area;
	}

	public String getCompany_size() {
		return company_size;
	}

	public void setCompany_size(String company_size) {
		this.company_size = company_size;
	}

	public String getCompany_type() {
		return company_type;
	}

	public void setCompany_type(String company_type) {
		this.company_type = company_type;
	}

	public String getCompany_brief() {
		return company_brief;
	}

	public void setCompany_brief(String company_brief) {
		this.company_brief = company_brief;
	}

	public int getCompany_stater() {
		return company_stater;
	}

	public void setCompany_stater(int company_stater) {
		this.company_stater = company_stater;
	}

	public int getCompany_sort() {
		return company_sort;
	}

	public void setCompany_sort(int company_sort) {
		this.company_sort = company_sort;
	}

	public int getCompany_viewnum() {
		return company_viewnum;
	}

	public void setCompany_viewnum(int company_viewnum) {
		this.company_viewnum = company_viewnum;
	}

	public String getCompany_pic() {
		return company_pic;
	}

	public void setCompany_pic(String company_pic) {
		this.company_pic = company_pic;
	}

	@Override
	public String toString() {
		return "Company [company_id=" + company_id + ", applicant_id="
				+ applicant_id + ", company_name=" + company_name
				+ ", company_area=" + company_area + ", company_size="
				+ company_size + ", company_type=" + company_type
				+ ", company_brief=" + company_brief + ", company_stater="
				+ company_stater + ", company_sort=" + company_sort
				+ ", company_viewnum=" + company_viewnum + ", company_pic="
				+ company_pic + "]";
	}

}