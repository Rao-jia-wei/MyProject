package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.entity.Education;
import com.utils.DBUtils;
import com.utils.DateUtils;

public class EducationDao {

	/**
	 * 保存教育经历对象
	 * @param education
	 */
	public void save(Education education){
		String sql = "insert into tb_education(applicant_id,school,begintime" +
				",schooling,profession) values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBUtils.getConnection();  //获取数据库连接
			ps = con.prepareStatement(sql);  //执行预编译的sql语句
			ps.setInt(1,education.getApplicant_id() );
			ps.setString(2,education.getSchool());
			ps.setTimestamp(3, education.getBeginTime()==null?null : new Timestamp(DateUtils.getStringToDate(education.getBeginTime()).getTime()));
			ps.setString(4,education.getSchooling());
			ps.setString(5,education.getProfession());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}

	}

	/**
	 * 通过applicant_id查询得到教育经历
	 * @param applicant_id
	 * @return
	 */
	public List<Education>  getEducationList(int applicant_id){
		String sql = "select * from tb_education where applicant_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;  //保留结果街
		List<Education> list = new ArrayList<Education>();
		try {
			con = DBUtils.getConnection();  //获取数据库连接
			ps = con.prepareStatement(sql);  //执行预编译的sql语句
			ps.setInt(1,applicant_id );
			rs = ps.executeQuery();
			Education education = null;
			while (rs.next()) {
				education = new Education();
				education.setEducation_id(rs.getInt("education_id"));
				education.setApplicant_id(rs.getInt("applicant_id"));
				education.setSchool(rs.getString("school"));
				education.setBeginTime(DateUtils.getDateToString(rs.getDate("begintime")));
				education.setSchooling(rs.getString("schooling"));
				education.setProfession(rs.getString("profession"));
				list.add(education);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}

		return list;
	}

	/**
	 * 删除
	 * @param educ
	 */
	public void delete(int education_id){
		String sql = "delete from tb_education where education_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;  //保留结果集
		try {
			con = DBUtils.getConnection();  //获取数据库连接
			ps = con.prepareStatement(sql);  //执行预编译的sql语句
			ps.setInt(1,education_id);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}

	}

	/**
	 * 查询教育经历
	 * @param education_id
	 * @return
	 */
	public Education queryEducation(int education_id){
		//插入语句
		String sql = "select * from  tb_education where education_id=?";

		Connection con = null;

		PreparedStatement ps = null;

		ResultSet rs = null;

		Education educ = new Education();

		try {
			con = DBUtils.getConnection();  //获取数据库连接

			ps = con.prepareStatement(sql);  //执行预编译的sql语句

			ps.setInt(1, education_id); //第一个参数:占位符,第二个参数：参数

			rs = ps.executeQuery(); //执行查询

			while(rs.next()){
				educ.setEducation_id(rs.getInt("education_id"));
				educ.setApplicant_id(rs.getInt("applicant_id"));
				educ.setSchool(rs.getString("school"));
				educ.setBeginTime(DateUtils.getDateToString(rs.getDate("begintime")));
				educ.setSchooling(rs.getString("schooling"));
				educ.setProfession(rs.getString("profession"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return educ;
	}



	/**
	 * 修改
	 * @param educ
	 */
	public void update(Education educ){
		//插入语句
		String sql = "update tb_education set school=?, beginTime=?, schooling=?, " +
				"profession=? where education_id =?";

		Connection con = null;

		PreparedStatement ps = null;

		ResultSet rs = null;

		try {
			con = DBUtils.getConnection();  //获取数据库连接

			ps = con.prepareStatement(sql);  //执行预编译的sql语句
			ps.setString(1, educ.getSchool());
			ps.setTimestamp(2, educ.getBeginTime()==null?null : new Timestamp(DateUtils.getStringToDate(educ.getBeginTime()).getTime()));
			ps.setString(3, educ.getSchooling()); //当前所在地
			ps.setString(4, educ.getProfession());
			ps.setInt(5,educ.getEducation_id());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}
	}


}