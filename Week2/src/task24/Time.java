package task24;

import java.util.Calendar;

public class Time {
	private int hour;
	private int minute;
	private int second;
	
	private int day;
	private int month;
	private int year;
	
	public Time(int hour, int minute, int second,
				int day, int month, int year) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String toString() {
		return String.format("%02d:%02d:%02d %02d.%02d.%04d", 
							 hour, minute, second, day, month, year);
	}
	
	public static Time now() {
		Calendar cal = Calendar.getInstance();

		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);

		return new Time(hour, minute, second,
				        day, month, year);
	}
}
