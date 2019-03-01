package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utils.StringUtils;

/**
 * 字符验证
 * java filter过滤器配置方法:https://www.cnblogs.com/coderland/p/5902878.html
 * @author emily
 *
 */

//@WebFilter
public class CharSetFitler implements Filter{

	public String encode = "";

	String includeString = "";

	//销毁
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
						 FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest hrequest = (HttpServletRequest) req;
		HttpServletResponse hresponse = (HttpServletResponse) resp;

		req.setCharacterEncoding(encode); //设置post请求编码格式 （页面到后台）
		resp.setContentType("text/html;charset=utf-8"); //设置响应的编码格式
		resp.setCharacterEncoding(encode);
		//session不可以实例化对象  new ()
		HttpSession session = hrequest.getSession();


		//获取当前的请求，过滤器
		String url = hrequest.getRequestURL().toString();
		System.out.println("url="+url);
		//以逗号分隔,转成字符串数组
		String[] urls = includeString.split(",");

		//session过时未操作时，session过时，要求重新登录
		//如果查找到为:1,没有找到为:-1
		if(StringUtils.isExitsUrl(url, urls)){
			//将请求交给下一个链接,必须有这个，否则不会跳转到下一个链接
			chain.doFilter(hrequest, hresponse);
		}else{
			if(session.getAttribute("applicant_id") == null){ //表示没有登录
				hresponse.sendRedirect("login.jsp");
			}else{ //登录过后的操作
				//将请求交给下一个链接,必须有这个，否则不会跳转到下一个链接
				chain.doFilter(hrequest, hresponse);
			}
		}
	}

	//初始化
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		encode = config.getInitParameter("encode");  //获取初始化参数
		includeString = config.getInitParameter("includeString"); // 过滤资源后缀参数

		System.out.println("执行初始化操作");

	}

}