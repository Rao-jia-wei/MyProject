package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;


import com.entity.ResumeBasicinfo;
import com.utils.DBUtils;

public class ResumeDao {

	/**
	 * 是否判断ID用户是否存在(已经注册)
	 * @return
	 */
	public ResumeBasicinfo isExitResme(int applicantID){
		//插入语句
		String sql = "select * from TB_RESUME_BASICINFO where applicant_id =?";

		Connection con = null;

		PreparedStatement ps = null;

		ResultSet rs = null;

		ResumeBasicinfo resume = new ResumeBasicinfo();

		try {
			con = DBUtils.getConnection();  //获取数据库连接

			ps = con.prepareStatement(sql);  //执行预编译的sql语句

			ps.setInt(1, applicantID); //第一个参数:占位符,第二个参数：参数

			rs = ps.executeQuery(); //执行查询

			while (rs.next()) {
				resume.setApplicantId(rs.getInt("APPLICANT_ID"));
				resume.setBasicinfoId(rs.getInt("BASICINFO_ID"));
				resume.setRealName(rs.getString("REALNAME"));
				resume.setGender(rs.getString("GENDER"));
				resume.setEmail(rs.getString("EMAIL"));
				resume.setBirthday(rs.getTimestamp("BIRTHDAY"));
				resume.setCurrentLoc(rs.getString("CURRENT_LOC"));
				resume.setResidentLog(rs.getString("RESIDENT_LOC"));
				resume.setTelephone(rs.getString("TELEPHONE"));
				resume.setJobExperience(rs.getString("JOB_EXPERIENCE"));
				resume.setJoIntension(rs.getString("JOB_INTENSION"));
				resume.setHeadShot(rs.getString("HEAD_SHOT"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}

		return resume;
	}

	/**
	 * 向求职信息表，插入简历
	 * @param basicinfo
	 * @param applicant_id
	 * @return
	 */
	public int add(ResumeBasicinfo basicinfo,int applicant_id){

		String sql = "INSERT INTO tb_resume_basicinfo(applicant_id, realname, gender, birthday, current_loc, resident_loc, telephone, email, job_intension, job_experience, head_shot) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		Connection con = null;

		PreparedStatement ps = null;

		ResultSet rs = null;

		int basicinfoid= 0;

		try {
			con = DBUtils.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, applicant_id);
			ps.setString(2, basicinfo.getRealName());
			ps.setString(3, basicinfo.getGender());
			ps.setTimestamp(4, basicinfo.getBirthday()==null?null : new Timestamp(basicinfo.getBirthday().getTime()));
//			ps.setDate(4, Integer.parseInt(basicinfo.getBirthday().toString()));
			ps.setString(5, basicinfo.getCurrentLoc()); //当前所在地
			ps.setString(6, basicinfo.getResidentLog());
			ps.setString(7, basicinfo.getTelephone());
			ps.setString(8, basicinfo.getEmail());
			ps.setString(9, basicinfo.getJoIntension());
			ps.setString(10, basicinfo.getJobExperience());
			ps.setString(11, basicinfo.getHeadShot());
			ps.executeUpdate();

			String sql2 = "select basicinfo_id from TB_RESUME_BASICINFO where APPLICANT_ID=?";
			ps = con.prepareStatement(sql2);
			ps.setInt(1, applicant_id);
			rs = ps.executeQuery();
			if(rs.next()){
				basicinfoid = rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}

		return basicinfoid;
	}


	/**
	 * 查询
	 * @param basicinfo
	 * @param applicant_id
	 * @return
	 */
	public ResumeBasicinfo queryResuemBasicInfo(int basicinfo_id){

		//插入语句
		String sql = "select * from TB_RESUME_BASICINFO where BASICINFO_ID =?"; // 登录的sql语句

		Connection con = null;

		PreparedStatement ps = null;

		ResultSet rs = null;

		ResumeBasicinfo resume = new ResumeBasicinfo();

		try {
			con = DBUtils.getConnection();  //获取数据库连接

			ps = con.prepareStatement(sql);  //执行预编译的sql语句

			ps.setInt(1, basicinfo_id); //第一个参数:占位符,第二个参数：参数

			rs = ps.executeQuery(); //执行查询

			while (rs.next()) {
				resume.setApplicantId(rs.getInt("APPLICANT_ID"));
				resume.setBasicinfoId(rs.getInt("BASICINFO_ID"));
				resume.setRealName(rs.getString("REALNAME"));
				resume.setGender(rs.getString("GENDER"));
				resume.setEmail(rs.getString("EMAIL"));
				resume.setBirthday(rs.getTimestamp("BIRTHDAY"));
				resume.setCurrentLoc(rs.getString("CURRENT_LOC"));
				resume.setResidentLog(rs.getString("RESIDENT_LOC"));
				resume.setTelephone(rs.getString("TELEPHONE"));
				resume.setJobExperience(rs.getString("JOB_EXPERIENCE"));
				resume.setJoIntension(rs.getString("JOB_INTENSION"));
				resume.setHeadShot(rs.getString("HEAD_SHOT"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}

		return resume;
	}

	/**
	 * 更新照片
	 */
	public void updateHeadShot(int basicinfoId,String newFileName){
		//插入语句
		String sql = "update TB_RESUME_BASICINFO set HEAD_SHOT=? where BASICINFO_ID =?"; //

		Connection con = null;

		PreparedStatement ps = null;

		ResultSet rs = null;

		try {
			con = DBUtils.getConnection();  //获取数据库连接

			ps = con.prepareStatement(sql);  //执行预编译的sql语句

			ps.setString(1, newFileName);

			ps.setInt(2, basicinfoId); //第一个参数:占位符,第二个参数：参数

			ps.executeUpdate(); //执行查询

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}


	}

	/**
	 * 修改个人信息
	 * @param resume
	 */
	public void update(ResumeBasicinfo basicinfo){
		//插入语句
		String sql = "update TB_RESUME_BASICINFO set applicant_id=?, realname=?, gender=?, birthday=?, " +
				"current_loc=?, resident_loc=?, telephone=?, email=?, job_intension=?, job_experience=?, head_shot=? where BASICINFO_ID =?";

		Connection con = null;

		PreparedStatement ps = null;

		ResultSet rs = null;

		try {
			con = DBUtils.getConnection();  //获取数据库连接

			ps = con.prepareStatement(sql);  //执行预编译的sql语句
			ps.setInt(1, basicinfo.getApplicantId());
			ps.setString(2, basicinfo.getRealName());
			ps.setString(3, basicinfo.getGender());
			ps.setTimestamp(4, basicinfo.getBirthday()==null?null : new Timestamp(basicinfo.getBirthday().getTime()));
			ps.setString(5, basicinfo.getCurrentLoc()); //当前所在地
			ps.setString(6, basicinfo.getResidentLog());
			ps.setString(7, basicinfo.getTelephone());
			ps.setString(8, basicinfo.getEmail());
			ps.setString(9, basicinfo.getJoIntension());
			ps.setString(10, basicinfo.getJobExperience());
			ps.setString(11, basicinfo.getHeadShot());
			ps.setInt(12, basicinfo.getBasicinfoId());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}

	}



}