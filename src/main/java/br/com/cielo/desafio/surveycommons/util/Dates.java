package br.com.cielo.desafio.surveycommons.util;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.ZoneOffset.UTC;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static java.time.temporal.ChronoUnit.DAYS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Dates {

	private static final String INITIAL_TIMESTAMP = "T00:00:00";
	private static final String FINAL_TIMESTAMP = "T23:59:59";
	private static final int FIRST_DAY_OF_MONTH = 1;
	
	public static String getFormattedDate(LocalDateTime localDateTime, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return localDateTime.format(formatter);
	}
	
	public static String getFormattedDate(LocalDate localDate, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return localDate.format(formatter);
	}
	
	public static String getFormattedDate(YearMonth yearMonth, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return yearMonth.format(formatter);
	}
	
	public static LocalDateTime toLocalDateTimeFromGmt(Date gmtDate) {
		Date localDate = new Date();
		Date localDateFromGmt = new Date(gmtDate.getTime() + TimeZone.getDefault().getOffset(localDate .getTime()));
		return localDateFromGmt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
	public static LocalDateTime getInitialTimestampOfDay(LocalDate localDate) {
		CharSequence fromText = localDate.toString() + INITIAL_TIMESTAMP;
		return LocalDateTime.parse(fromText, ISO_DATE_TIME);
	}

	public static LocalDateTime getFinalTimestampOfDay(LocalDate localDate) {
		CharSequence fromText = localDate.toString() + FINAL_TIMESTAMP;
		return LocalDateTime.parse(fromText, ISO_DATE_TIME);
	}
	
	public static LocalDateTime getInitialTimestampOfDay(YearMonth yearMonth) {
		LocalDate localDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), FIRST_DAY_OF_MONTH);
		return getInitialTimestampOfDay(localDate);
	}
	
	public static LocalDateTime getFinalTimestampOfDay(YearMonth yearMonth) {
		int lastDayOfMonth = yearMonth.atEndOfMonth().lengthOfMonth();
		LocalDate localDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), lastDayOfMonth );
		return getFinalTimestampOfDay(localDate);
	}

	public static String getFormattedDate(LocalDateTime localDatetime, String pattern, Locale locale) {
		DateTimeFormatter formatter = DateTimeFormatter
				  .ofPattern(pattern)
				  .withLocale(locale);
		return localDatetime.format(formatter);
	}
	
	public static LocalDate getFirstDay(YearMonth yearMonth) {
		return yearMonth.atDay(FIRST_DAY_OF_MONTH);
	}

	public static LocalDate getLastDay(YearMonth yearMonth) {
		return yearMonth.atEndOfMonth();
	}

	public static LocalDateTime getLocalDateTime(String date, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDateTime.parse(date, formatter);
	}
	
	public static LocalTime getLocalTime(String time, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalTime.parse(time, formatter);
	}

	public static MonthDay getMonthDay(String date, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return MonthDay.parse(date, formatter);
	}

	public static Integer getCurrentYear() {
		return Year.now().getValue();
	}
	
	public static Integer getCurrentMonth() {
		return MonthDay.now().getMonthValue();
	}
	
	public static Integer getCurrentDayOfMonth() {
		return MonthDay.now().getDayOfMonth();
	}
	
	public static LocalDateTime addDaysToCurrentDate(Integer days) {
		return LocalDateTime.ofInstant(Instant.now(), UTC).plus(days, DAYS);
	}
	
	public static LocalDate addDaysToCurrentDate(Long days) {
		return LocalDate.now(TimeZones.getDefault()).plusDays(days);
	}

	public static Integer addDaysToCurrentYear(Integer days) {
		LocalDateTime now = addDaysToCurrentDate(days);
		return now.getYear();
	}
	
	public static Integer addDaysToCurrentMonth(Integer days) {
		LocalDateTime now = addDaysToCurrentDate(days);
		return now.getMonthValue();
	}
	
	public static Integer addDaysToCurrentDayOfMonth(Integer days) {
		LocalDateTime now = addDaysToCurrentDate(days);
		return now.getDayOfMonth();
	}

	public static LocalDate addWorkingDays(Integer days, LocalDate localDate) {
		var result = LocalDate.from(localDate);
		var addedDays = Numbers.ZERO;
		while (addedDays < days) {
			result = result.plusDays(Numbers.ONE);
			if (!isWeekend(result)) {
				++addedDays;
			}
		}
		return result;
	}

	public static LocalDate minusWorkingDays(Integer days, LocalDate localDate) {
		var result = LocalDate.from(localDate);
		var subtractedDays = Numbers.ZERO;
		while (subtractedDays < days) {
			result = result.minusDays(Numbers.ONE);
			if (!isWeekend(result)) {
				++subtractedDays;
			}
		}
		return result;
	}

	public static LocalDate addWorkingDaysToNow(Integer days) {
		return addWorkingDays(days, LocalDate.now());
	}

	public static LocalDate minusWorkingDaysToNow(Integer days) {
		return minusWorkingDays(days, LocalDate.now());
	}

	public static boolean isWeekend(LocalDate localDate) {
		return localDate.getDayOfWeek() == SATURDAY || localDate.getDayOfWeek() == SUNDAY;
	}
	
	public static LocalDate yesterday() {
		return today().minusDays(Numbers.ONE);
	}
	
	public static LocalDate today() {
		return LocalDate.now(TimeZones.getDefault());
	}

	public static LocalDateTime now() {
		return LocalDateTime.now(TimeZones.getDefault());
	}

	public static LocalDate getDateFromBrazilianFull(String date) {
		return LocalDate.parse(date.toLowerCase(), DateTimeFormatter.ofPattern(DatePatterns.BRAZILIAN_FULL, Locales.brazil()));
	}

	public static boolean isValid(String dateStr, String pattern) {
		try {
			DateFormat df = new SimpleDateFormat(pattern);
			df.setLenient(false);
			df.parse(dateStr);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
