package com.api.utils;

import org.apache.commons.lang3.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeUtility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Set;

public class VerificationUtils {

	public static String obj2Str(Object o) {
		return o==null? StringUtils.EMPTY:String.valueOf(o);
	}
	
	public static String date2Str(Object o) {
		if (o instanceof Timestamp) {
			Timestamp ts = (Timestamp) o;
			Date date = new Date(ts.getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		}else {
			return StringUtils.EMPTY;
		}
	}
	
	public static <E> int setSize(Set<E> set) {
		if (set == null) {
			return 0;
		}
		return set.size();
	}
	
	public static int includeCountStr(String str,String regx) {
		if (StringUtils.isEmpty(str) || StringUtils.isEmpty(regx)) {
			return 0;
		}
		String shotStr = str.replaceAll(regx, StringUtils.EMPTY);
		return (str.length() - shotStr.length())/regx.replaceAll("\\\\", StringUtils.EMPTY).length();
	}
	
	public static String encodingPassword(String password,String random,String algorithmName) {
		ByteArrayOutputStream bos = null;
		try {
			String pass = password + random;
			MessageDigest md = MessageDigest.getInstance("SHA");
			byte[] digest = md.digest(pass.getBytes("iso-8859-1"));
			bos = new ByteArrayOutputStream();
			OutputStream encodedStream = MimeUtility.encode(bos, "base64");
			encodedStream.write(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return StringUtils.EMPTY;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return StringUtils.EMPTY;
		} catch (MessagingException e) {
			e.printStackTrace();
			return StringUtils.EMPTY;
		} catch (IOException e) {
			e.printStackTrace();
			return StringUtils.EMPTY;
		}
		try {
			return bos.toString("iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return StringUtils.EMPTY;
		}
	}
}
