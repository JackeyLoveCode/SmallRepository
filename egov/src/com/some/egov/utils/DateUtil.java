package com.some.egov.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getDateFormat(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
}
