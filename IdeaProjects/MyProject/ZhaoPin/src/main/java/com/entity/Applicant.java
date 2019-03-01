package com.entity;

/**
 * 求职者信息
 * @author emily
 *
 */
public class Applicant {

	private int applicant_id; //首字母不能大写   求职者编号

	private String applicant_email;  //求职者电子邮箱

	private String applicant_password;  //求职者登录密码

	private String usertype; //用户类型

	private String applicant_regdate; //求职者注册时间

	public Applicant() {
		// TODO Auto-generated constructor stub
	}




	public Applicant(int applicant_id, String applicant_email,
					 String applicant_password, String usertype, String applicant_regdate) {
		super();
		this.applicant_id = applicant_id;
		this.applicant_email = applicant_email;
		this.applicant_password = applicant_password;
		this.usertype = usertype;
		this.applicant_regdate = applicant_regdate;
	}




	public String getUsertype() {
		return usertype;
	}


	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}


	public int getApplicant_id() {
		return applicant_id;
	}

	public void setApplicant_id(int applicant_id) {
		this.applicant_id = applicant_id;
	}

	public String getApplicant_email() {
		return applicant_email;
	}

	public void setApplicant_email(String applicant_email) {
		this.applicant_email = applicant_email;
	}

	public String getApplicant_password() {
		return applicant_password;
	}

	public void setApplicant_password(String applicant_password) {
		this.applicant_password = applicant_password;
	}

	public String getApplicant_regdate() {
		return applicant_regdate;
	}

	public void setApplicant_regdate(String applicant_regdate) {
		this.applicant_regdate = applicant_regdate;
	}


	@Override
	public String toString() {
		return "Applicant [applicant_id=" + applicant_id + ", applicant_email="
				+ applicant_email + ", applicant_password="
				+ applicant_password + ", usertype=" + usertype
				+ ", applicant_regdate=" + applicant_regdate + "]";
	}




}