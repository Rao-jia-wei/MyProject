package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 退出登录:直接清空session里面的保存的值
 * session实现原理:https://www.cnblogs.com/xdp-gacl/p/3855702.html
 * @author liyunf
 *
 */
@WebServlet("/logout.do")
public class ApplicantLogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();

		//手工调用session.invalidate方法，摧毁session
		session.invalidate();
		resp.sendRedirect("index.jsp");  //退出后跳转到首页

	}
}