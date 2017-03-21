package cn.edu.xiyou.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String dateConvertToString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String str=sdf.format(date);  
		return str;
	}
}
