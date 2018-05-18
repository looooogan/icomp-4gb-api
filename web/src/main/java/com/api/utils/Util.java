package com.api.utils;

import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class Util {
	
	private static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	
	private static final String numbers = "1234567890";
	
	public static final String KEY_SHA = "SHA";
	
	public static final Map<String, Object> cacheMap = new HashMap<String, Object>();
	
	/**
	 * 获取8位的随机码
	 * @return
	 */
	public static String getRandomCode(){
		String randCode = "";		
		for(int i=0; i<10; i++){
			int rand = Integer.parseInt(String.valueOf(Math.round((Math.random()*100000000))%36));
			randCode += letters.substring(rand, rand+1);
		}
		return randCode;
	}
	
	/**
	 * 获取指定length长度的随机码
	 * @param length
	 * @return
	 */
	public static String getRandomCode(int length){
		String randCode = "";		
		for(int i=0; i<length; i++){
			int rand = Integer.parseInt(String.valueOf(Math.round((Math.random()*100000000))%36));
			randCode += letters.substring(rand, rand+1);
		}
		return randCode;
	}
	
	/**
	 * 将输入的字符串进行MD5加密，并返回加密后的字符串
	 * @param s
	 * @return
	 */
	public final static String MD5(String s) {  
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
				'a', 'b', 'c', 'd', 'e', 'f' };  
		try {  
			byte[] strTemp = s.getBytes();  
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");  
			mdTemp.update(strTemp);  
			byte[] md = mdTemp.digest();  
			int j = md.length;  
			char str[] = new char[j * 2];  
			int k = 0;  
			for (int i = 0; i < j; i++) {  
				byte byte0 = md[i];  
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
				str[k++] = hexDigits[byte0 & 0xf];  
			}  
			return new String(str).toUpperCase();  
		} catch (Exception e) {  
			return null;  
		}  
	}  
	
	/**
	 * 获得项目的根目录的绝对路径
	 * @return
	 */
	public static String getRootPath(){
		Class thisClass = Util.class;
		URL url = thisClass.getResource(thisClass.getSimpleName() + ".class");
		String path = url.getPath();
		int endIndex = path.indexOf("WEB-INF");
		return path.substring(0, endIndex);
	}
	/**
	 * 获得项目WEB-INF目录的绝对路径
	 * @return
	 */
	public static String getWebInfoPath(){
		return getRootPath() + "WEB-INF" + System.getProperty("file.separator");
	}	
	/**
	 * 将List 中的元素组成以“，”号分隔的字符串
	 * @param list
	 * @return
	 */
	public static String transferListToString(List<String> list){
		String returnValue = "";
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String element = (String) iter.next();
			returnValue += (element + ",");
		}
		return returnValue.substring(0, returnValue.length()-1);
	}
	/**
	 * 判断字符串是否是空串 
	 * @param text
	 * @return
	 */
	public static boolean isNullOrBlank(String text){
		boolean isNull = false;
		if(text == null || text.equals("")){
			isNull = true;
		}
		return isNull;
	}
	
	/**
	 *
	 * @Title: getRandomPassword
	 * @Description: 生成随机短信密码
	 * @param length
	 * @return
	 * @return: String
	 */
	public static String getRandomPassword(int length){
		String randCode = "";		
		for(int i = 0; i < length; i++){
			int rand = Integer.parseInt(String.valueOf(Math.round((Math.random() * 100000000)) % 10));
			randCode += numbers.substring(rand, rand+1);
		}
		return randCode;
	}

	public static Map<String, Object> getCachemap() {
		return cacheMap;
	}
	
	/**
	 * 
	 * @Title: digestString
	 * @Description: BASE 64
	 * @param pass
	 * @param algorithm
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @return: String
	 */
//	  public static String digestString(String pass, String algorithm)
//			    throws NoSuchAlgorithmException
//			  {
//			    try
//			    {
//			      MessageDigest md = MessageDigest.getInstance(algorithm);
//			      byte[] digest = md.digest(pass.getBytes("iso-8859-1"));
//			      ByteArrayOutputStream bos = new ByteArrayOutputStream();
//			      OutputStream encodedStream = MimeUtility.encode(bos, "base64");
//			      encodedStream.write(digest);
//			      return bos.toString("iso-8859-1");
//			    } catch (IOException ioe) {
//			      throw new RuntimeException("Fatal error: " + ioe);
//			    } catch (MessagingException me) {
//			      throw new RuntimeException("Fatal error: " + me);
//			    }
//			  }
//
//			  public static String digestString2(String pass, String algorithm)
//			    throws NoSuchAlgorithmException
//			  {
//			    try
//			    {
//			      MessageDigest md = MessageDigest.getInstance(algorithm);
//			      byte[] digest = md.digest(pass.getBytes());
//			      byte[] dest = new byte[8];
//			      System.arraycopy(digest, 4, dest, 0, 8);
//			      char[] pwd = Hex.encodeHex(dest);
//			      return new String(pwd);
//			    } catch (Exception ioe) {
//			      throw new RuntimeException("Fatal error: " + ioe);
//			    }
//			  }
	
//	public static void main(String  args[]){
//		String str = null;
//		try {
//			str = digestString("123456", KEY_SHA);
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//		System.out.println(str);
//	}
}
