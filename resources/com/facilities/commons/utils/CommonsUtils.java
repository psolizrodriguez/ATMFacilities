package com.facilities.commons.utils;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
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

	public static Calendar getFinalizationTime(Calendar calendar, int minutes) {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
		date.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		date.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
		date.set(Calendar.HOUR, calendar.get(Calendar.HOUR));
		date.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + minutes);
		date.set(Calendar.SECOND, calendar.get(Calendar.SECOND));

		return date;
	}

	public static String CalendarToString(Calendar value) {
		if (value == null)
			return "";
		return new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(value.getTime());
	}

	public static boolean isCalendarBetween(Calendar calendar, Calendar from, Calendar to) {
		if (calendar.getTimeInMillis() >= from.getTimeInMillis()
				&& calendar.getTimeInMillis() <= to.getTimeInMillis()) {
			return true;
		}
		return false;
	}

	public static long minutesBetween(Calendar startDate, Calendar endDate) {
		return ChronoUnit.MINUTES.between(startDate.toInstant(), endDate.toInstant());
	}
}
