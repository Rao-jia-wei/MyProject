package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ApplicantDao;
import com.dao.CompanyDao;
import com.dao.ResumeDao;
import com.entity.Applicant;
import com.entity.Company;
import com.entity.ResumeBasicinfo;
import com.utils.CookieEncrypTool;

/**
 * 登录
 * @author emily
 *
 */
@WebServlet("/login.do")
public class ApplicantLoginServlet extends HttpServlet{

	Company company = new Company();
	CompanyDao companydao = new CompanyDao();
	ApplicantDao adao = new ApplicantDao();

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

		//通过web.xml filter过滤器完成
//		req.setCharacterEncoding("utf-8"); //设置post请求编码格式 （页面到后台）
//
//		resp.setContentType("text/html;charset=utf-8"); //设置响应的编码格式
//
//		resp.setCharacterEncoding("utf-8");

		PrintWriter out =resp.getWriter(); //文本的输出流，两者选其一

		String email = req.getParameter("email");

		String password = req.getParameter("password");

		String rememberMe = req.getParameter("rememberMe"); //获取记住密码

		System.out.println("rememberMe="+rememberMe);  //结果因为Boolean

		System.out.println("email="+email+",passwod="+password);

		//第一次请求的时候，服务端会自动产生一个sessionID返回给客户端，客户端利用cookie技术保存在浏览器,只有重新关闭浏览器后再重新访问，cookie才会发生变化
		HttpSession session = req.getSession(); //session 对象 会话 请求 响应 (会话期)

		Applicant applicant = adao.login(email, password); //返回登录信息  调用applicantDao中login()方法

		int applicant_id = applicant.getApplicant_id();

		if(applicant_id!=0){ //登录成功后执行的操作
			System.out.println("登录成功");
			//保存邮箱名
			session.setAttribute("username", email);
			session.setAttribute("applicant_id", applicant_id);
			//调用记住密码的方法，通过cookie技术记住邮箱和密码
			rememberMe(rememberMe,email,password,req,resp);
			ResumeDao resumDao = new ResumeDao();
			String usertype = applicant.getUsertype();  //得到用户类型
			session.setAttribute("usertype", usertype); //把用户类型，存储到session会话中，用于判断主页显示
			if("0".equals(usertype)){  //个人用户
				ResumeBasicinfo resumebasicinfo = resumDao.isExitResme(applicant_id);
				int baseinfo_id = resumebasicinfo.getBasicinfoId();
				System.out.println("baseinfo_id="+baseinfo_id);
				if(baseinfo_id == 0){ //简历还未填写
					resp.sendRedirect("applicant/resumeGuide.jsp");
				}else{//简历已经填写
					ResumeBasicinfo resume = resumDao.isExitResme(applicant_id);
					session.setAttribute("baseinfo_id", resume.getBasicinfoId());  //把简历信息ID存在session中
					req.setAttribute("resumeInfo", resume);
					resp.sendRedirect("index.jsp");
				}
			}else if("1".equals(usertype)){  //企业用户
				company = companydao.isExitCompany(applicant_id);
				int company_id = company.getCompany_id();
				if(company_id==0){ //企业简历未填写
					resp.sendRedirect("recruit/companyGuide.jsp");
				}else{  //企业简历已经填写
					session.setAttribute("company", company); //把企业信息存在请求域
					req.getRequestDispatcher("index.jsp").forward(req, resp);
				}





			}
		}else{  //登录失败
			System.out.println("登录失败");
			out.println("<script type='text/javascript'>");
			out.println("alert('用户名或者密码错误,请重新输入');");
			//还是停留在登录页面
			out.println("window.location.href='login.jsp';");
			out.println("</script>");
		}
	}

	/**
	 * 判断是否记住密码
	 * rememberMe:true 表示选中记住密码
	 * rememberMe:false 表示未选中记住密码按钮
	 * @param rememberMe
	 * @param email
	 * @param password
	 * @param req
	 * @param resp
	 */
	private void rememberMe(String rememberMe,String email,String password,HttpServletRequest req, HttpServletResponse resp){

		//如果rememberMe:true需要记住邮箱和密码
		//这种写法，会防止报空指针异常
		if("true".equals(rememberMe)){

			Cookie cookie = new Cookie("cookie_applicantemail",CookieEncrypTool.encdeBase64(email)); //产生cookie对象  (base64加密)
			cookie.setPath("/"); //表示保存在当前路径下
			cookie.setMaxAge(7*24*3600); //cookie最大的保存时间，默认为：浏览器重新关闭后cookie就会消失  cookie保存时间为7天,以秒为单位
			resp.addCookie(cookie);  //把cookie写入到浏览器中

			cookie = new Cookie("cookie_applicantepassword",CookieEncrypTool.encdeBase64(password)); //产生cookie对象  (base64加密)
			cookie.setPath("/"); //表示保存在当前路径下
			cookie.setMaxAge(7*24*3600); //cookie最大的保存时间，默认为：浏览器重新关闭后cookie就会消失  cookie保存时间为7天,以秒为单位
			resp.addCookie(cookie);  //把cookie写入到浏览器中

		}else{

			//将邮箱和密码全部清空
			//只有得到cookie值才可以清空
			Cookie[] cookies = req.getCookies(); //返回cookie数组，获取所有的cookie数据
			if(cookies!=null){
				for(Cookie cookie:cookies){
					//cookie.getName() 获取的结果表示：获取cookie_applicantemail
					//cookie.getValue()获取的结果表示：获取的是CookieEncrypTool.encdeBase64(email)加密的值
					if("cookie_applicantemail".equals(cookie.getName()) || "cookie_applicantepassword".equals(cookie.getName()) ){
						cookie.setMaxAge(0); //删除cookie值
						cookie.setPath("/"); //表示保存在当前路径下
						resp.addCookie(cookie);  //把cookie写入到浏览器中
					}
				}
			}

		}
	}

}