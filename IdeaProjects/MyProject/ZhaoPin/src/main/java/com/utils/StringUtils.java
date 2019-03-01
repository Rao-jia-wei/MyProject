package com.utils;
/**
 * 字符
 * 资料:http://blog.csdn.net/gaoweizang/article/details/53097710
 * StringUtils常用的方法:http://blog.csdn.net/shwanglp/article/details/51373807
 * @author liyunf
 *
 */
public class StringUtils {

	/**
	 * 判断是否找到这个相应的
	 * @param url
	 * @param urls
	 * @return
	 */
	public  static boolean  isExitsUrl(String url,String[] urls){
		boolean flag = false;
		for(int i=0;i<urls.length;i++){
			if(url.indexOf(urls[i])!=-1){
				flag = true;
			}
		}
		return flag;
	}

}