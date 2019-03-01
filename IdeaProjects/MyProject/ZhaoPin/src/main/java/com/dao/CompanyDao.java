package com.dao;

import java.sql.*;

import com.entity.Company;
import com.entity.ResumeBasicinfo;
import com.mysql.jdbc.*;
import com.utils.DBUtils;


/**
 * 企业信息
 * @author liyunf
 *
 */
public class CompanyDao {

	/**
	 * 是否判断ID用户是否存在(已经注册)
	 * @return
	 */
	public Company isExitCompany(int applicantID){
		//插入语句
		String sql = "select * from tb_company where applicant_id =?";

		Connection con = null;

		PreparedStatement ps = null;

		ResultSet rs = null;

		Company company = new Company();

		try {
			con = DBUtils.getConnection();  //获取数据库连接

			ps = con.prepareStatement(sql);  //执行预编译的sql语句

			ps.setInt(1, applicantID); //第一个参数:占位符,第二个参数：参数

			rs = ps.executeQuery(); //执行查询

			while (rs.next()) {
				company.setCompany_id(rs.getInt("company_id"));
				company.setApplicant_id(rs.getInt("applicant_id"));
				company.setCompany_name(rs.getString("company_name"));
				company.setCompany_area(rs.getString("company_area"));
				company.setCompany_size(rs.getString("company_size"));
				company.setCompany_type(rs.getString("company_type"));
				company.setCompany_brief(rs.getString("company_brief"));
				company.setCompany_stater(rs.getInt("company_state"));  //取与数据库相同的字段
				company.setCompany_sort(rs.getInt("company_sort"));
				company.setCompany_viewnum(rs.getInt("company_viewnum"));
				company.setCompany_pic(rs.getString("company_pic"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}

		return company;
	}

	/**
	 * 向企业信息表，插入简历,并且返回company_id
	 * @param company
	 * @return
	 */
	public int add(Company company){

		String sql = "INSERT INTO tb_company(applicant_id, company_name, company_area, company_size, company_type, company_brief, company_state, company_sort, company_viewnum, company_pic) VALUES(?,?,?,?,?,?,?,?,?,?)";

		Connection con = null;

		PreparedStatement ps = null;

		ResultSet rs = null;

		int company_id= 0;

		try {
			con = DBUtils.getConnection();
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //返回保存对象的主键
			ps.setInt(1, company.getApplicant_id());
			ps.setString(2, company.getCompany_name());
			ps.setString(3, company.getCompany_area());
			ps.setString(4, company.getCompany_size());
			ps.setString(5, company.getCompany_type()); //当前所在地
			ps.setString(6, company.getCompany_brief());
			ps.setInt(7, company.getCompany_stater());
			ps.setInt(8, company.getCompany_sort());
			ps.setInt(9, company.getCompany_viewnum());
			ps.setString(10, company.getCompany_pic());
			ps.executeUpdate();

			// 检索由于执行此 Statement 对象而创建的所有自动生成的键
			rs= ps.getGeneratedKeys();
			while(rs.next()){
				company_id = rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}

		return company_id;
	}

	/**
	 * 通过企业id查找企业信息
	 * @param company_id
	 * @return
	 */
	public Company getCompany(int company_id){
		String sql ="select * from tb_company where company_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs  = null;
		Company company = new Company();
		try {
			con = DBUtils.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, company_id);
			rs = ps.executeQuery();
			while(rs.next()){
				company.setApplicant_id(rs.getInt("applicant_id"));
				company.setCompany_id(rs.getInt("company_id"));
				company.setCompany_name(rs.getString("company_name"));
				company.setCompany_area(rs.getString("company_area"));
				company.setCompany_size(rs.getString("company_size"));
				company.setCompany_type(rs.getString("company_type"));
				company.setCompany_brief(rs.getString("(company_brief"));
				company.setCompany_stater(rs.getInt("company_state"));
				company.setCompany_sort(rs.getInt("company_sort"));
				company.setCompany_viewnum(rs.getInt("company_viewnum"));
				company.setCompany_pic(rs.getString("company_pic"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(con, rs, null, ps);
		}

		return company;
	}


}