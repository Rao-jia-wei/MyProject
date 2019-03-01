package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import com.entity.Applicant;
import com.utils.DBUtils;

public class ApplicantDao {
	
	/**
	 * 求职者登录验证
	 * @param email
	 * @param password
	 * @return
	 */
	public Applicant login(String email,String password){
		
		//SQL语句
		String sql = "select * from tb_applicant where applicant_email =? and applicant_password=?";
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		Applicant applicant = new Applicant();
		
		try {
			con = DBUtils.getConnection();  //获取数据库连接
			
			ps = con.prepareStatement(sql);  //执行预编译的sql语句
			
			ps.setString(1, email);  //第一个参数:占位符,第二个参数：参数 
			
			ps.setString(2, password); //第一个参数:占位符,第二个参数：参数
			
			rs = ps.executeQuery(); //执行查询
			
			while (rs.next()) {
				applicant.setApplicant_id(rs.getInt("applicant_id"));
				applicant.setApplicant_email(rs.getString("applicant_email"));
				applicant.setUsertype(String.valueOf(rs.getInt("usertype")));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}
		
		return applicant;
	}
	
	/**
	 * 求职者注册邮箱验证是否存在
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean isExistEmail(String email){
		
		//插入语句
		String sql = "select * from tb_applicant where applicant_email =?";
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		boolean temp = false;
		
		try {
			con = DBUtils.getConnection();  //获取数据库连接
			
			ps = con.prepareStatement(sql);  //执行预编译的sql语句
			
			ps.setString(1, email);  //第一个参数:占位符,第二个参数：参数 
			
			rs = ps.executeQuery(); //执行查询
			
			while (rs.next()) {
				temp = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}
		
		return temp;
	}
	
	/**
	 * 保存求职者信息（邮箱、密码,时间）
	 * @param email
	 * @param password
	 */
	public void save(String email,String password,String usertype){
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		String sql = "insert into tb_applicant(applicant_email,applicant_password,applicant_regdate,usertype) values(?,?,?,?)";
		try {
			
			con = DBUtils.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setTimestamp(3, new Timestamp(new Date().getTime()));  //获取当前日期
			ps.setString(4, usertype);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}
	}

}
