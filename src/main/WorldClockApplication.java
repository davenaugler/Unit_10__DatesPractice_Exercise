package main;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class WorldClockApplication {
	
	// In this exercise, we are going to be using ZonedDateTime from the java.time package.  Like LocalDate and LocalDateTime,
	// starting from Java 8 onwards, we can easily add in timezones to our date to get the correct time information
	// from different countries.  If you chose your own countries, you may need to do a quick google search on your country
	// zone id.  The format is usually <Continent>/<City>
	
	private final static ZoneId CANADA = ZoneId.of("America/Toronto");
	private final static ZoneId BRISBANE = ZoneId.of("Australia/Brisbane");
	private final static ZoneId DUBLIN = ZoneId.of("Europe/Dublin");

	public static void main(String[] args) {
//		System.out.println(CANADA);
//		System.out.println(BRISBANE);
//		System.out.println(DUBLIN);

		// [1] first we need to capture what the time is at this exact moment...
		ZonedDateTime zonedDateTimeCanada = ZonedDateTime.now();
		ZonedDateTime zonedDateTimeBrisbane = ZonedDateTime.now();
		ZonedDateTime zonedDateTimeDublin = ZonedDateTime.now();
		
		// [2] from here you will need to create three system outs to print out the times and dates
		
		// ZonedDateTime has a method called withZoneSameInstant(<ZoneId>) which gives you the exact date time in the
		// time zone you put in using the zone id.  Try putting in zonedDateTime.withZoneSameInstant(BRISBANE)...
		zonedDateTimeCanada = zonedDateTimeCanada.withZoneSameInstant(CANADA);
		zonedDateTimeBrisbane = zonedDateTimeBrisbane.withZoneSameInstant(BRISBANE);
		zonedDateTimeDublin = zonedDateTimeDublin.withZoneSameInstant(DUBLIN);
		
		System.out.println(zonedDateTimeBrisbane);
		System.out.println(zonedDateTimeDublin);
		System.out.println(zonedDateTimeCanada);
		
		// [3] After we grabbed the time in our country, we need to format the output using our DateTimeFormatter...
		System.out.println("");
		System.out.println(CANADA + " -> "+ zonedDateTimeCanada.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a - z")));
		System.out.println(BRISBANE + " -> "+ zonedDateTimeBrisbane.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a - z")));
		System.out.println(DUBLIN + " -> "+ zonedDateTimeDublin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a - z")));
		
		// [4] We need to format it in a way that is easily readable, for this assignment, use FormatStyle.MEDIUM
		// ... .format(DateTimeFormatter.ofLocalizedDateTIme(FormatStyle.MEDIUM));
		System.out.println("");
		System.out.println("Toronto, Canada" +  " -> "+ zonedDateTimeCanada.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		System.out.println("Brisbane, Australia" +  " -> "+ zonedDateTimeBrisbane.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		System.out.println("Dublin, Ireland" +  " -> "+ zonedDateTimeDublin.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
	}

}
