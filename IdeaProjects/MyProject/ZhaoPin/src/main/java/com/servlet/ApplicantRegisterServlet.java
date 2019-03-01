package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ApplicantDao;

/**
 * 注册验证
 * @author emily
 *
 */
@WebServlet("/register.do")
public class ApplicantRegisterServlet extends HttpServlet{

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

/*		req.setCharacterEncoding("utf-8"); //设置post请求编码格式 （页面到后台）

		resp.setContentType("text/html;charset=utf-8"); //设置响应的编码格式

		resp.setCharacterEncoding("utf-8"); */

		PrintWriter out = resp.getWriter(); //输出流

		String email = req.getParameter("email"); //邮箱
		String password = req.getParameter("password"); //密码
		String code = req.getParameter("code");  //验证码
		String usertype = req.getParameter("usertype"); //用户类型
		System.out.println("email="+email+",passwod="+password+",code="+code);
		ApplicantDao dao = new ApplicantDao();
		boolean flag = dao.isExistEmail(email);

		System.out.println("后台code:"+req.getSession().getAttribute("code"));
		//获取保存在session中验证码跟前端输入的验证码进行比较
		if(!req.getSession().getAttribute("code").equals(code)){
			out.println("<script type='text/javascript'>");
			out.println("alert('验证码错误,请重新输入');");
			//还是停留在注册页面
			out.println("window.location.href='register.jsp';");
			out.println("</script>");
		}else if(flag){
			//邮箱已注册，进行错误提示
			out.println("<script type='text/javascript'>");
			out.println("alert('邮箱已注册,请直接登录');");
			//还是停留在注册页面
			out.println("window.location.href='login.jsp';");
			out.println("</script>");
		}else{
			//保存注册用户信息
			dao.save(email, password,usertype);
			//跳转到登录页面
			resp.sendRedirect("regsuccess.jsp");
		}





	}


}