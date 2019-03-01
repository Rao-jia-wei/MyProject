package com.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.ResumeDao;
import com.entity.ResumeBasicinfo;

/**
 * 图片上传(servlet3.0文件上传)
 * 参考资料:http://blog.csdn.net/estelle_belle/article/details/51751844
 * 获取文件上传的文件名:https://www.cnblogs.com/xdp-gacl/p/4224960.html
 * @author emily
 *
 */
//使用@WebServlet配置UploadServlet的访问路径
@WebServlet("/resumeupload.do")
@MultipartConfig   //标识Servlet支持文件上传
public class ResumePicUploadServlet extends HttpServlet {

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

		//获取文件上传域
		Part part = req.getPart("headShot");
		//Servlet3没有提供直接获取文件名的方法,需要从请求头中解析出来
		//获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
		String header = part.getHeader("content-disposition"); //获取内容的头信息
		//获取上传文件的文件名称
		String fileName = header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));
		System.out.println("刚刚上传后的文件名："+fileName);
		//lastIndexOf()：从小数点开始取值，产生一个新的文件名
		String newFileName = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
		System.out.println("新的文件名newFileName="+newFileName);
		//得到这个文件的路径,获取文件上传后保存的路径，这个路径是发布项目的服务器的某个目录下
		String filepath = getServletContext().getRealPath("/applicant/images");
		System.out.println("上传文件所存的路径："+filepath);
		File f = new File(filepath);
		if(!f.exists()){
			f.mkdirs();  //如果这个目录不存在，则重新新建一个
		}
		//文件上传到该目录下的文件夹中
		part.write(filepath+"/"+newFileName);
		//需要把图片文件名保存在简历信息数据表中
		ResumeDao dao = new ResumeDao();
		HttpSession session = req.getSession();

		int basicinfoId = (Integer) session.getAttribute("baseinfo_id");  //从session得到该条简历基本信息的ID
		dao.updateHeadShot(basicinfoId, newFileName);
		session.setAttribute("baseinfo_id", basicinfoId);
		ResumeBasicinfo resumIfno = dao.queryResuemBasicInfo(basicinfoId); //跳转
		req.setAttribute("resumeInfo", resumIfno);
		req.getRequestDispatcher("applicant/resume.jsp").forward(req, resp);
	}

}