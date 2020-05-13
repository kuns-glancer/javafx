package saber.kuns.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TimeUtils {

	/**
	 * convert LocalDate to Date
	 * 
	 * @param localDate
	 * @return
	 */
	public static Date localDate2Date(LocalDate localDate) {
		if (localDate == null) {
			return null;
		}
		ZoneId zoneId = ZoneId.systemDefault();
		return Date.from(localDate.atStartOfDay(zoneId).toInstant());
	}

	/**
	 * convert date to localDate
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate date2LocalDate(Date date) {
		if(date == null) {
			return null;
		}
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		return localDateTime.toLocalDate();
	}

}
