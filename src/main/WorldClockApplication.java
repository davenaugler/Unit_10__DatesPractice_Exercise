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

		// [1] first we need to capture what the time is at this exact moment...
		ZonedDateTime zonedDateTimeCanada = ZonedDateTime.now(CANADA);
		ZonedDateTime zonedDateTimeBrisbane = ZonedDateTime.now(BRISBANE);
		ZonedDateTime zonedDateTimeDublin = ZonedDateTime.now(DUBLIN);
		
		// [2] from here you will need to create three system outs to print out the times and dates
		System.out.println("Time in Brisbane: " + zonedDateTimeBrisbane);
		System.out.println("Time in Dublin: " + zonedDateTimeDublin);
		System.out.println("Time in Canada: " + zonedDateTimeCanada);
		
		// For Fun
//		System.out.println("");
//		System.out.println(CANADA + " -> "+ zonedDateTimeCanada.format(DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a - z")));
//		System.out.println(BRISBANE + " -> "+ zonedDateTimeBrisbane.format(DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a - z")));
//		System.out.println(DUBLIN + " -> "+ zonedDateTimeDublin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a - z")));
		
		// [3] After we grabbed the time in our country, we need to format the output using our DateTimeFormatter...
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		
		// [4] We need to format it in a way that is easily readable, for this assignment, use FormatStyle.MEDIUM
		// ... .format(DateTimeFormatter.ofLocalizedDateTIme(FormatStyle.MEDIUM));
		System.out.println("");
		System.out.println("Toronto, Canada" +  " -> "+ zonedDateTimeCanada.format(dateTimeFormatter));
		System.out.println("Brisbane, Australia" +  " -> "+ zonedDateTimeBrisbane.format(dateTimeFormatter));
		System.out.println("Dublin, Ireland" +  " -> "+ zonedDateTimeDublin.format(dateTimeFormatter));
	}

}
