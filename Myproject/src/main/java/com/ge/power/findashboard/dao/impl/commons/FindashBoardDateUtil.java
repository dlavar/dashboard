package com.ge.power.findashboard.dao.impl.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ge.power.findashboard.constants.FinAppConstants;

public class FindashBoardDateUtil {
	public static String dateToString(String date,String currentFormat,String targetFormat) throws ParseException{
		SimpleDateFormat stf = new SimpleDateFormat(currentFormat);
		Date d = stf.parse(date);
		stf = new SimpleDateFormat(targetFormat);
		return stf.format(d);
	}
	
	public static String formatDate(String date,String dateFormat) throws ParseException{
		SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = stf.parse(date);
		stf = new SimpleDateFormat(dateFormat);
		return stf.format(d);	
	}
	/*public static void main(String args[]) throws ParseException{
		Calendar cal = Calendar.getInstance();
		System.out.println(formatDate("2016-03-31",FinAppConstants.QUATERENDDATEFORAMT));
		
	}*/
}
