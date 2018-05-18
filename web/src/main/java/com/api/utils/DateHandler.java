package com.api.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHandler extends DateUtils {

	public static String formartDate(String style, Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(style);
		return simpleDateFormat.format(date);
	}

	public static Date trimToLastSecond(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}
}
