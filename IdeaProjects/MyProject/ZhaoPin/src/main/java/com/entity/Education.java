package com.entity;

import java.util.Date;

/**
 * 教育经历
 * @author liyunf
 *
 */
public class Education {

	private int education_id; //教育经历ID

	private int applicant_id;  //简历基本信息ID

	private String school;  //毕业院校

	private String beginTime;  //毕业时间

	private String schooling; //学历

	private String profession; //专业

	public Education() {
		// TODO Auto-generated constructor stub
	}

	//
	public Education(int education_id, int applicant_id, String school,
					 String beginTime, String schooling, String profession) {
		super();
		this.education_id = education_id;
		this.applicant_id = applicant_id;
		this.school = school;
		this.beginTime = beginTime;
		this.schooling = schooling;
		this.profession = profession;
	}

	public Education( int applicant_id, String school,
					  String beginTime, String schooling, String profession) {
		super();
		this.applicant_id = applicant_id;
		this.school = school;
		this.beginTime = beginTime;
		this.schooling = schooling;
		this.profession = profession;
	}

	public Education(String school, String beginTime, String schooling,
					 String profession) {
		super();
		this.school = school;
		this.beginTime = beginTime;
		this.schooling = schooling;
		this.profession = profession;
	}

	public int getEducation_id() {
		return education_id;
	}

	public void setEducation_id(int education_id) {
		this.education_id = education_id;
	}

	public int getApplicant_id() {
		return applicant_id;
	}

	public void setApplicant_id(int applicant_id) {
		this.applicant_id = applicant_id;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getSchooling() {
		return schooling;
	}

	public void setSchooling(String schooling) {
		this.schooling = schooling;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}


	@Override
	public String toString() {
		return "Education [education_id=" + education_id + ", applicant_id="
				+ applicant_id + ", school=" + school + ", begintime="
				+ beginTime + ", schooling=" + schooling + ", profession="
				+ profession + "]";
	}



}