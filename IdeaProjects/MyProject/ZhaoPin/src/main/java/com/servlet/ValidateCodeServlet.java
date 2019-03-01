package com.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 验证码
 * @author emily
 * 资源链接：http://blog.csdn.net/pangesange/article/details/54412049
 *  图片验证码： http://blog.csdn.net/love_legain/article/details/53589339
 */

@WebServlet("/code.do")
public class ValidateCodeServlet extends HttpServlet{

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

		resp.setContentType("image/jpeg"); //设置响应头contenType类型

		ServletOutputStream out = resp.getOutputStream(); //获取一个二进制输出流对象

		int width = 70;  //设置图片的宽度

		int height = 30; //设置图片的高度

		//创建图片缓冲区
		BufferedImage imgbuf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics2D g = imgbuf.createGraphics(); //创建一支画笔

		g.fillRect(0, 0, width, height); //设置图像的形状及高度

		g.setColor(getRandColor(200, 250)); //设置背景颜色,调用getrandcolor()

		//设置字体大小和字体样式
		g.setFont(new Font("微软雅黑",Font.PLAIN,21));

		//随机产生0-9之间的4位数字
		String code = "";
		Random r = new Random(); //随机数对象，产生随机数

		//随机产生干扰线，验证码上的干扰线
		g.setColor(getRandColor(160, 200));
		for(int i=0;i<100;i++){
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			int x1 = r.nextInt(12);
			int y1 = r.nextInt(12);
			g.drawOval(x, y, x+x1, y+y1);
		}

		//干扰点
		g.setColor(getRandColor(120, 240));
		for(int i=0;i<100;i++){
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			g.drawOval(x, y, 0, 0);
		}

		//随机产生4位带字母+数字的验证码(方法一)
	/*  String code1 = "";
	  for(int i=0;i<4;i++){
		  //String rand =   String.valueOf(r.nextInt(10));
	    	//随机数字和字母
	    	int rand;
			int cnt = 26 * 2 + 10;
			int v = r.nextInt(cnt);
			if (v < 10)
				rand = '0' + v;
			else if (v < 36)
				rand = v - 10 +  'A';
			else
				rand = v - 36 +  'a';
			g.setColor(new Color(20+r.nextInt(110),20+r.nextInt(110),20+r.nextInt(110)));
			g.drawString(String.valueOf((char)rand), 16*i+6, 20);
			code1 += String.valueOf((char)rand);
		}*/

		//随机产生4位带字母+数字的验证码(方法二)
		String str = "0123456789zxcvbnmasdfghjklqwertyuiopZXCVBNMASDFGHJKLQWERTYUIOP";
		int index = r.nextInt(str.length());
		for(int i=0;i<4;i++){
			String rand = String.valueOf(str.charAt(r.nextInt(index)));  //valueOf：将数字类型转换为字符类型
			code+=rand;

			//设置字体颜色
			g.setColor(new Color(20+r.nextInt(110),20+r.nextInt(110),20+r.nextInt(110)));
			g.drawString(rand, 13*i+6, 20);  //坐标 画字符串

		}

		System.out.println("生成的随机数code："+code);
		HttpSession session = req.getSession();
		session.setAttribute("code", code); //产生验证码保存在session会话中
		ImageIO.write(imgbuf, "JPEG", out);
		out.close();
	}

	/**
	 * 随机生成的图片颜色
	 * 获取指定范围的随机颜色
	 * @param fc
	 * @param bc
	 * @return
	 */
	private Color getRandColor(int fc,int bc){

		Random random = new Random();

		if(fc>255){
			fc = 255;
		}
		if(fc<0){
			fc = 0;
		}
		if(bc>255){
			bc = 255;
		}
		if(bc<0){
			bc = 0;
		}

		int r = fc + random.nextInt(bc-fc); //产生颜色
		int g = fc + random.nextInt(bc-fc); //产生颜色
		int b = fc + random.nextInt(bc-fc); //产生颜色
		return new Color(r,g,b);
	}

}