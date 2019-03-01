package com.entity;

import java.util.Date;

/**
 * 简历基本信息
 * @author liyunf
 *
 */
public class ResumeBasicinfo {

	private int basicinfoId; //简历ID

	private int applicantId; //求职者ID

	private String realName; //姓名

	private String gender; //性别

	private Date birthday; //出生日期

	private String currentLoc; //当前所在地

	private String residentLog; //户口所在地

	private String telephone; //手机

	private String email; //邮箱

	private String joIntension; //求职意向

	private String jobExperience; //工作经验

	private String headShot; //头像

	public ResumeBasicinfo() {
		// TODO Auto-generated constructor stub
	}

	public ResumeBasicinfo(String realName, String gender, Date birthday,
						   String currentLoc, String residentLog, String telephone,
						   String email, String joIntension, String jobExperience) {
		super();
		this.realName = realName;
		this.gender = gender;
		this.birthday = birthday;
		this.currentLoc = currentLoc;
		this.residentLog = residentLog;
		this.telephone = telephone;
		this.email = email;
		this.joIntension = joIntension;
		this.jobExperience = jobExperience;
	}

	public int getBasicinfoId() {
		return basicinfoId;
	}

	public void setBasicinfoId(int basicinfoId) {
		this.basicinfoId = basicinfoId;
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCurrentLoc() {
		return currentLoc;
	}

	public void setCurrentLoc(String currentLoc) {
		this.currentLoc = currentLoc;
	}

	public String getResidentLog() {
		return residentLog;
	}

	public void setResidentLog(String residentLog) {
		this.residentLog = residentLog;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoIntension() {
		return joIntension;
	}

	public void setJoIntension(String joIntension) {
		this.joIntension = joIntension;
	}

	public String getJobExperience() {
		return jobExperience;
	}

	public void setJobExperience(String jobExperience) {
		this.jobExperience = jobExperience;
	}

	public String getHeadShot() {
		return headShot;
	}

	public void setHeadShot(String headShot) {
		this.headShot = headShot;
	}

	@Override
	public String toString() {
		return "ResumeBasicinfo [basicinfoId=" + basicinfoId + ", applicantId="
				+ applicantId + ", realName=" + realName + ", gender=" + gender
				+ ", birthday=" + birthday + ", currentLoc=" + currentLoc
				+ ", residentLog=" + residentLog + ", telephone=" + telephone
				+ ", email=" + email + ", joIntension=" + joIntension
				+ ", jobExperience=" + jobExperience + ", headShot=" + headShot
				+ "]";
	}

}