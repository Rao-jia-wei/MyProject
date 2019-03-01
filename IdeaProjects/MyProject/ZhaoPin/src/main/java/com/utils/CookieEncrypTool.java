package com.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * Cookie加密、解密功能
 * @author emily
 * 参考资料：http://blog.csdn.net/zhou_kapenter/article/details/62890262
 *
 */
public class CookieEncrypTool {

	/**
	 * Base64加密
	 * @param cleartext
	 * @return
	 */
	public static String encdeBase64(String cleartext){

		String resulttext="";

		try {

			BASE64Encoder encoder = new BASE64Encoder();
			resulttext = encoder.encode(cleartext.getBytes("utf-8"));


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return resulttext;
	}

	/**
	 * 解码
	 * @param ciphertext
	 * @return
	 */
	public static String decodeBase64(String ciphertext){

		String resulttext="";

		try {

			BASE64Decoder  decoder = new BASE64Decoder();
			resulttext = new String(decoder.decodeBuffer(ciphertext),"utf-8");


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return resulttext;
	}

	public static void main(String[] args) {

		String str ="重庆文理emily";
		String rs = encdeBase64(str);
		System.out.println(rs);

		String str1 = "6YeN5bqG5paH55CGZW1pbHk=";
		System.out.println(decodeBase64(str1));

	}

}