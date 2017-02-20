package com.facilities.commons.utils;

import java.util.Calendar;

public class CommonsUtils {
	public static Calendar getCalendar(int month, int day, int year, int hours, int minutes, int seconds) {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, year);
		date.set(Calendar.MONTH, month + 1);
		date.set(Calendar.DAY_OF_MONTH, day);
		date.set(Calendar.HOUR, hours);
		date.set(Calendar.MINUTE, minutes);
		date.set(Calendar.SECOND, seconds);

		return date;
	}
}
