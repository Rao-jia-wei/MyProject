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
	 * ��ְ�ߵ�¼��֤
	 * @param email
	 * @param password
	 * @return
	 */
	public Applicant login(String email,String password){
		
		//SQL���
		String sql = "select * from tb_applicant where applicant_email =? and applicant_password=?";
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		Applicant applicant = new Applicant();
		
		try {
			con = DBUtils.getConnection();  //��ȡ���ݿ�����
			
			ps = con.prepareStatement(sql);  //ִ��Ԥ�����sql���
			
			ps.setString(1, email);  //��һ������:ռλ��,�ڶ������������� 
			
			ps.setString(2, password); //��һ������:ռλ��,�ڶ�������������
			
			rs = ps.executeQuery(); //ִ�в�ѯ
			
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
	 * ��ְ��ע��������֤�Ƿ����
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean isExistEmail(String email){
		
		//�������
		String sql = "select * from tb_applicant where applicant_email =?";
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		boolean temp = false;
		
		try {
			con = DBUtils.getConnection();  //��ȡ���ݿ�����
			
			ps = con.prepareStatement(sql);  //ִ��Ԥ�����sql���
			
			ps.setString(1, email);  //��һ������:ռλ��,�ڶ������������� 
			
			rs = ps.executeQuery(); //ִ�в�ѯ
			
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
	 * ������ְ����Ϣ�����䡢����,ʱ�䣩
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
			ps.setTimestamp(3, new Timestamp(new Date().getTime()));  //��ȡ��ǰ����
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
