package JavaConcepts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
/*import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;*/

/**
 * Different in built classes to use for date and time.
 * 
 * @author prakasni
 *
 */
public class LocalDateTimeDemo extends Object{
	public static void main(String[] args) throws ParseException {
		// simple date format.
		String stringfromUser = new String("23:34");
		try {
			Date startTime = new SimpleDateFormat("HH:mm").parse(stringfromUser);
			// System.out.println(startTime.getHours() + " " +
			// startTime.getMinutes());
		} catch (ParseException e) {
			throw e;
		}

		// 2nd Method.
		Instant time = Instant.now();
		// System.out.println(time.getEpochSecond());
		// System.out.println(System.currentTimeMillis());

		// 3rd Method. This seems to be a better option as the 1st option has
		// deprecated methods.
		//DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm");
		//LocalTime data = dtf.parseLocalTime(stringfromUser);
		// System.out.println(data.getHourOfDay());
		// System.out.println(data.getMinuteOfHour());

		// to get date and time.
		Date d = new Date();
		java.time.LocalDate localDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println(localDate.getDayOfMonth());
		System.out.println(localDate.getMonthValue());
		System.out.println(localDate.getMonth());
		System.out.println(localDate.getYear());

		Instant d1 = d.toInstant();
		System.out.println(ZoneId.getAvailableZoneIds());
		ZonedDateTime d2 = d1.atZone(ZoneId.systemDefault());
		LocalDate date = d2.toLocalDate();
		System.out.println("How does it know this" + date.getDayOfWeek());
		// or
		java.time.LocalTime t = d2.toLocalTime();
		t.getHour();
		// or
		LocalDateTime dateTime = d2.toLocalDateTime();
		System.out.println(dateTime.getDayOfMonth());

		// Another way of getting local date.
		LocalDate t1 = LocalDate.now(ZoneId.systemDefault());
		System.out.println("I KNOW" + t1.getDayOfMonth());

		java.time.LocalTime t3 = java.time.LocalTime.now();
		System.out.println("This is min." + t3.getMinute());
	}
	
	
}
