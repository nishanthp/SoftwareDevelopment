package JavaConcepts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Different in built classes to use for date and time.
 * 
 * @author prakasni
 *
 */
public class LocalDateTimeDemo {
	public static void main(String[] args) throws ParseException {
		// simple date format.
		String stringfromUser = new String("23:34");
		try {
			Date startTime = new SimpleDateFormat("HH:mm").parse(stringfromUser);
			System.out.println(startTime.getHours() + "       " + startTime.getMinutes());
		} catch (ParseException e) {
			throw e;
		}

		// 2nd Method.
		Instant time = Instant.now();
		System.out.println(time.getEpochSecond());
		System.out.println(System.currentTimeMillis());

		// 3rd Method. This seems to be a better option as the 1st option has
		// deprecated methods.
		DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm");
		LocalTime data = dtf.parseLocalTime(stringfromUser);
		System.out.println(data.getHourOfDay());
		System.out.println(data.getMinuteOfHour());

	}
}
