package edu.nju.express.common;

import java.util.Calendar;
import java.util.Locale;

public class MyDate {

	public static String getCurrentDate(){
		
		Calendar c = Calendar.getInstance(Locale.CHINA);
		String year = c.get(Calendar.YEAR)+"";
		String month = String.format("%02d", c.get(Calendar.MONTH)+1);
		String day = String.format("%02d", c.get(Calendar.DATE));
		
		return year+"/"+month+"/"+day;
		
	}
	
}
