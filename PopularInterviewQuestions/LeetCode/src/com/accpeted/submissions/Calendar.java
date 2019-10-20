package com.accpeted.submissions;

public class Calendar {

	public Calendar() {
		// Ran on leetcode.
	}

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// Just on of those problems.
	public String dayOfTheWeek(int day, int month, int year) {
		String[] daysOfWeek = {"Friday", "Saturday", "Sunday", "Monday",
				"Tuesday", "Wednesday", "Thursday"};
		int leapYear = 366;
		int nonLeapYear = 365;
		int days = 0;
		for (int cy = 1971; cy < year; cy++) {
			if (checkLeapYear(cy))
				days += leapYear;
			else
				days += nonLeapYear;
		}

		boolean isLeapYear = checkLeapYear(year);

		for (int cm = 1; cm < month; cm++) {
			if (cm == 2)
				days += isLeapYear ? 29 : 28;
			else if (cm == 4 || cm == 6 || cm == 9 || cm == 11) {
				System.out.println(cm);
				days += 30;
			} else {
				days += 31;
			}
		}
		days += day - 1;
		return daysOfWeek[days % 7];
	}

	public boolean checkLeapYear(int year) {
		if (year % 400 == 0)
			return true;

		if (year % 100 == 0)
			return false;

		if (year % 4 == 0)
			return true;

		return false;
	}

}
