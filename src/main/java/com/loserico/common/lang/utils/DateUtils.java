package com.loserico.common.lang.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.regex.Pattern;

import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Locale.ENGLISH;

/**
 * 最全, 功能最完整的DateUtils
 * <p>
 * Copyright: (C), 2019/11/7 9:25
 * <p>
 * <p>
 * Company: Sexy Uncle Inc.
 *
 * @author Rico Yu ricoyu520@gmail.com
 * @version 1.0
 */
@Slf4j
public class DateUtils {
	
	/**
	 * 毫秒
	 */
	public final static long MS = 1;
	/**
	 * 每秒钟的毫秒数
	 */
	public final static long SECOND_MS = MS * 1000;
	/**
	 * 每分钟的毫秒数
	 */
	public final static long MINUTE_MS = SECOND_MS * 60;
	/**
	 * 每小时的毫秒数
	 */
	public final static long HOUR_MS = MINUTE_MS * 60;
	/**
	 * 每天的毫秒数
	 */
	public final static long DAY_MS = HOUR_MS * 24;
	
	public static final int MINUTES_PER_HOUR = 60;
	public static final int SECONDS_PER_MINUTE = 60;
	public static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
	
	/**
	 * -------------- 正则表达式, 日期格式对 -------------------------
	 */
	// yyyy-MM-dd
	private static final Pattern PT_ISO_DATE = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
	private static final String FMT_ISO_DATE = "yyyy-MM-dd";
	private static final DateTimeFormatter DTF_ISO_DATE = ofPattern(FMT_ISO_DATE);
	// yyyy-MM-d
	private static final Pattern PT_ISO_DATE_1 = Pattern.compile("\\d{4}-\\d{2}-\\d{1}");
	private static final String FMT_ISO_DATE_1 = "yyyy-MM-d";
	private static final DateTimeFormatter DTF_ISO_DATE_1 = ofPattern(FMT_ISO_DATE_1);
	// yyyy-M-dd
	private static final Pattern PT_ISO_DATE_2 = Pattern.compile("\\d{4}-\\d{1}-\\d{2}");
	private static final String FMT_ISO_DATE_2 = "yyyy-M-dd";
	private static final DateTimeFormatter DTF_ISO_DATE_2 = ofPattern(FMT_ISO_DATE_2);
	// yyyy-M-d
	private static final Pattern PT_ISO_DATE_3 = Pattern.compile("\\d{4}-\\d{1}-\\d{1}");
	private static final String FMT_ISO_DATE_3 = "yyyy-M-d";
	private static final DateTimeFormatter DTF_ISO_DATE_3 = ofPattern(FMT_ISO_DATE_3);
	
	// MM-dd-yyyy
	private static final Pattern PT_DATE_EN = Pattern.compile("\\d{2}-\\d{2}-\\\\d{4}");
	private static final String FMT_DATE_FORMAT_EN = "MM/dd/yyyy";
	private static final DateTimeFormatter DTF_DATE_FORMAT_EN = ofPattern(FMT_DATE_FORMAT_EN);
	// MM-d-yyyy
	private static final Pattern PT_DATE_EN_1 = Pattern.compile("\\d{2}-\\d{1}-\\\\d{4}");
	private static final String FMT_DATE_FORMAT_EN_1 = "MM/d/yyyy";
	private static final DateTimeFormatter DTF_DATE_FORMAT_EN_1 = ofPattern(FMT_DATE_FORMAT_EN_1);
	// M-dd-yyyy
	private static final Pattern PT_DATE_EN_2 = Pattern.compile("\\d{1}-\\d{2}-\\\\d{4}");
	private static final String FMT_DATE_FORMAT_EN_2 = "M/dd/yyyy";
	private static final DateTimeFormatter DTF_DATE_FORMAT_EN_2 = ofPattern(FMT_DATE_FORMAT_EN_2);
	// M-d-yyyy
	private static final Pattern PT_DATE_EN_3 = Pattern.compile("\\d{1}-\\d{1}-\\\\d{4}");
	private static final String FMT_DATE_FORMAT_EN_3 = "M/d/yyyy";
	private static final DateTimeFormatter DTF_DATE_FORMAT_EN_3 = ofPattern(FMT_DATE_FORMAT_EN_3);
	
	// yyyy/MM/dd
	private static final Pattern PT_DATE_EN_4 = Pattern.compile("\\d{4}/\\d{2}/\\d{2}");
	private static final String FMT_DATE_FORMAT_EN_4 = "yyyy/MM/dd";
	private static final DateTimeFormatter DTF_DATE_FORMAT_EN_4 = ofPattern(FMT_DATE_FORMAT_EN_4);
	private static final DateTimeFormatter DTF_DATE_FORMAT_EN_LOCALE_4 = ofPattern(FMT_DATE_FORMAT_EN_4, ENGLISH);
	// yyyy/MM/d
	private static final Pattern PT_DATE_EN_5 = Pattern.compile("\\d{4}/\\d{2}/\\d{1}");
	private static final String FMT_DATE_FORMAT_EN_5 = "yyyy/MM/d";
	private static final DateTimeFormatter DTF_DATE_FORMAT_EN_5 = ofPattern(FMT_DATE_FORMAT_EN_5);
	// yyyy/M/dd
	private static final Pattern PT_DATE_EN_6 = Pattern.compile("\\d{4}/\\d{1}/\\d{2}");
	private static final String FMT_DATE_FORMAT_EN_6 = "yyyy/M/dd";
	private static final DateTimeFormatter DTF_DATE_FORMAT_EN_6 = ofPattern(FMT_DATE_FORMAT_EN_6);
	// yyyy/M/d
	private static final Pattern PT_DATE_EN_7 = Pattern.compile("\\d{4}/\\d{1}/\\d{1}");
	private static final String FMT_DATE_FORMAT_EN_7 = "yyyy/M/d";
	private static final DateTimeFormatter DTF_DATE_FORMAT_EN_7 = ofPattern(FMT_DATE_FORMAT_EN_7);
	
	// yyyyMMdd
	private static final Pattern PT_DATE_CONCISE = Pattern.compile("\\d{8}");
	private static final String FMT_DATE_CONCISE = "yyyyMMdd";
	private static final DateTimeFormatter DTF_DATE_CONCISE = ofPattern(FMT_DATE_CONCISE);
	
	//d-MMM-yy
	private static final Pattern PT_DATE_FORMAT_EN_8 = Pattern.compile("\\d{1}-\\w{3}-\\d{2}");
	private static final String FMT_DATE_FORMAT_EN_8 = "d-MMM-yy"; // 15-Sep-18 1-Sep-18 这种格式
	private static final DateTimeFormatter DTF_DATE_FORMAT_EN_8 = ofPattern(FMT_DATE_FORMAT_EN_8);
	
	
	// ----------------------- 下面是日期时间类型 ---------------------------------------------------
	// yyyy-MM-dd HH:mm:ss
	private static final Pattern PT_ISO_DATETIME = Pattern.compile("\\d{4}-\\d{2}-\\d{2}(\\s+)\\d{2}:\\d{2}:\\d{2}");
	private static final String FMT_ISO_DATETIME = "yyyy-MM-dd HH:mm:ss";
	private static final DateTimeFormatter DTF_ISO_DATETIME = ofPattern(FMT_ISO_DATETIME);
	
	// yyyy-MM-d HH:mm:ss
	private static final Pattern PT_ISO_DATETIME_1 = Pattern.compile("\\d{4}-\\d{2}-\\d{1}(\\s+)\\d{2}:\\d{2}:\\d{2}");
	private static final String FMT_ISO_DATETIME_1 = "yyyy-MM-d HH:mm:ss";
	private static final DateTimeFormatter DTF_ISO_DATETIME_1 = ofPattern(FMT_ISO_DATETIME_1);
	// yyyy-M-dd HH:mm:ss
	private static final Pattern PT_ISO_DATETIME_2 = Pattern.compile("\\d{4}-\\d{1}-\\d{2}(\\s+)\\d{2}:\\d{2}:\\d{2}");
	private static final String FMT_ISO_DATETIME_2 = "yyyy-M-dd HH:mm:ss";
	private static final DateTimeFormatter DTF_ISO_DATETIME_2 = ofPattern(FMT_ISO_DATETIME_2);
	// yyyy-M-d HH:mm:ss
	private static final Pattern PT_ISO_DATETIME_3 = Pattern.compile("\\d{4}-\\d{1}-\\d{1}(\\s+)\\d{2}:\\d{2}:\\d{2}");
	private static final String FMT_ISO_DATETIME_3 = "yyyy-M-d HH:mm:ss";
	private static final DateTimeFormatter DTF_ISO_DATETIME_3 = ofPattern(FMT_ISO_DATETIME_3);
	// yyyy-M-d H:mm:ss
	private static final Pattern PT_ISO_DATETIME_4 = Pattern.compile("\\d{4}-\\d{1}-\\d{1}(\\s+)\\d{1}:\\d{2}:\\d{2}");
	private static final String FMT_ISO_DATETIME_4 = "yyyy-M-d H:mm:ss";
	private static final DateTimeFormatter DTF_ISO_DATETIME_4 = ofPattern(FMT_ISO_DATETIME_4);
	
	// yyyy-MM-d H:mm:ss
	private static final Pattern PT_ISO_DATETIME_5 = Pattern.compile("\\d{4}-\\d{2}-\\d{1}(\\s+)\\d{1}:\\d{2}:\\d{2}");
	private static final String FMT_ISO_DATETIME_5 = "yyyy-MM-d H:mm:ss";
	private static final DateTimeFormatter DTF_ISO_DATETIME_5 = ofPattern(FMT_ISO_DATETIME_5);
	
	// yyyy-MM-dd HH:mm
	private static final Pattern PT_ISO_DATETIME_SHORT = Pattern.compile("\\d{4}-\\d{2}-\\d{2}(\\s+)\\d{2}:\\d{2}");
	private static final String FMT_ISO_DATETIME_SHORT = "yyyy-MM-dd HH:mm";
	private static final DateTimeFormatter DTF_ISO_DATETIME_SHORT = ofPattern(FMT_ISO_DATETIME_SHORT);
	// yyyy-MM-d HH:mm
	private static final Pattern PT_ISO_DATETIME_SHORT_1 = Pattern.compile("\\d{4}-\\d{2}-\\d{1}(\\s+)\\d{2}:\\d{2}");
	private static final String FMT_ISO_DATETIME_SHORT_1 = "yyyy-MM-d HH:mm";
	private static final DateTimeFormatter DTF_ISO_DATETIME_SHORT_1 = ofPattern(FMT_ISO_DATETIME_SHORT_1);
	// yyyy-M-dd HH:mm
	private static final Pattern PT_ISO_DATETIME_SHORT_2 = Pattern.compile("\\d{4}-\\d{1}-\\d{2}(\\s+)\\d{2}:\\d{2}");
	private static final String FMT_ISO_DATETIME_SHORT_2 = "yyyy-M-dd HH:mm";
	private static final DateTimeFormatter DTF_ISO_DATETIME_SHORT_2 = ofPattern(FMT_ISO_DATETIME_SHORT_2);
	// yyyy-M-d HH:mm
	private static final Pattern PT_ISO_DATETIME_SHORT_3 = Pattern.compile("\\d{4}-\\d{1}-\\d{1}(\\s+)\\d{2}:\\d{2}");
	private static final String FMT_ISO_DATETIME_SHORT_3 = "yyyy-M-d HH:mm";
	private static final DateTimeFormatter DTF_ISO_DATETIME_SHORT_3 = ofPattern(FMT_ISO_DATETIME_SHORT_3);
	
	// yyyy-MM-dd H:mm
	private static final Pattern PT_ISO_DATETIME_SHORT_4 = Pattern.compile("\\d{4}-\\d{2}-\\d{2}(\\s+)\\d{1}:\\d{2}");
	private static final String FMT_ISO_DATETIME_SHORT_4 = "yyyy-MM-dd H:mm";
	private static final DateTimeFormatter DTF_ISO_DATETIME_SHORT_4 = ofPattern(FMT_ISO_DATETIME_SHORT_4);
	
	// yyyy-MM-d H:mm
	private static final Pattern PT_ISO_DATETIME_SHORT_5 = Pattern.compile("\\d{4}-\\d{2}-\\d{1}(\\s+)\\d{1}:\\d{2}");
	private static final String FMT_ISO_DATETIME_SHORT_5 = "yyyy-MM-d H:mm";
	private static final DateTimeFormatter DTF_ISO_DATETIME_SHORT_5 = ofPattern(FMT_ISO_DATETIME_SHORT_5);
	
	// yyyy-M-dd H:mm
	private static final Pattern PT_ISO_DATETIME_SHORT_6 = Pattern.compile("\\d{4}-\\d{1}-\\d{2}(\\s+)\\d{1}:\\d{2}");
	private static final String FMT_ISO_DATETIME_SHORT_6 = "yyyy-M-dd H:mm";
	private static final DateTimeFormatter DTF_ISO_DATETIME_SHORT_6 = ofPattern(FMT_ISO_DATETIME_SHORT_6);
	
	// yyyy-M-d H:mm
	private static final Pattern PT_ISO_DATETIME_SHORT_7 = Pattern.compile("\\d{4}-\\d{1}-\\d{1}(\\s+)\\d{1}:\\d{2}");
	private static final String FMT_ISO_DATETIME_SHORT_7 = "yyyy-M-d H:mm";
	private static final DateTimeFormatter DTF_ISO_DATETIME_SHORT_7 = ofPattern(FMT_ISO_DATETIME_SHORT_7);
	
	//MM/dd/yyyy HH:mm:ss
	private static final Pattern PT_DATETIME_FORMAT_EN =
			Pattern.compile("\\d{2}/\\d{2}/\\d{4}(\\s+)\\d{2}:\\d{2}:\\d{2}");
	private static final String FMT_DATETIME_FORMAT_EN = "MM/dd/yyyy HH:mm:ss";
	private static final DateTimeFormatter DTF_DATETIME_FORMAT_EN = ofPattern(FMT_DATETIME_FORMAT_EN);
	
	//yyyy/MM/dd HH:mm:ss
	private static final Pattern PT_DATETIME_FORMAT_EN_1 =
			Pattern.compile("\\d{4}/\\d{2}/\\d{2}(\\s+)\\d{2}:\\d{2}:\\d{2}");
	private static final String FMT_DATETIME_FORMAT_EN_1 = "yyyy/MM/dd HH:mm:ss";
	private static final DateTimeFormatter DTF_DATETIME_FORMAT_EN_1 = ofPattern(FMT_DATETIME_FORMAT_EN_1);
	
	//yyyy/MM/d HH:mm:ss
	private static final Pattern PT_DATETIME_FORMAT_EN_2 =
			Pattern.compile("\\d{4}/\\d{2}/\\d{1}(\\s+)\\d{2}:\\d{2}:\\d{2}");
	private static final String FMT_DATETIME_FORMAT_EN_2 = "yyyy/MM/d HH:mm:ss";
	private static final DateTimeFormatter DTF_DATETIME_FORMAT_EN_2 = ofPattern(FMT_DATETIME_FORMAT_EN_2);
	
	//yyyy/M/dd HH:mm:ss
	private static final Pattern PT_DATETIME_FORMAT_EN_3 =
			Pattern.compile("\\d{4}/\\d{1}/\\d{2}(\\s+)\\d{2}:\\d{2}:\\d{2}");
	private static final String FMT_DATETIME_FORMAT_EN_3 = "yyyy/M/dd HH:mm:ss";
	private static final DateTimeFormatter DTF_DATETIME_FORMAT_EN_3 = ofPattern(FMT_DATETIME_FORMAT_EN_3);
	
	//yyyy/M/d HH:mm:ss
	private static final Pattern PT_DATETIME_FORMAT_EN_4 =
			Pattern.compile("\\d{4}/\\d{1}/\\d{1}(\\s+)\\d{2}:\\d{2}:\\d{2}");
	private static final String FMT_DATETIME_FORMAT_EN_4 = "yyyy/M/d HH:mm:ss";
	private static final DateTimeFormatter DTF_DATETIME_FORMAT_EN_4 = ofPattern(FMT_DATETIME_FORMAT_EN_4);
	
	//MM/dd/yyyy HH:mm:ss
	private static final Pattern PT_DATETIME_FORMAT_EN_5 =
			Pattern.compile("\\d{2}/\\d{2}/\\d{4}(\\s+)\\d{1}:\\d{2}:\\d{2}");
	private static final String FMT_DATETIME_FORMAT_EN_5 = "MM/dd/yyyy H:mm:ss";
	private static final DateTimeFormatter DTF_DATETIME_FORMAT_EN_5 = ofPattern(FMT_DATETIME_FORMAT_EN_5);
	
	//yyyy/MM/dd HH:mm:ss
	private static final Pattern PT_DATETIME_FORMAT_EN_6 =
			Pattern.compile("\\d{4}/\\d{2}/\\d{2}(\\s+)\\d{1}:\\d{2}:\\d{2}");
	private static final String FMT_DATETIME_FORMAT_EN_6 = "yyyy/MM/dd H:mm:ss";
	private static final DateTimeFormatter DTF_DATETIME_FORMAT_EN_6 = ofPattern(FMT_DATETIME_FORMAT_EN_6);
	
	//yyyy/MM/d HH:mm:ss
	private static final Pattern PT_DATETIME_FORMAT_EN_7 =
			Pattern.compile("\\d{4}/\\d{2}/\\d{1}(\\s+)\\d{1}:\\d{2}:\\d{2}");
	private static final String FMT_DATETIME_FORMAT_EN_7 = "yyyy/MM/d H:mm:ss";
	private static final DateTimeFormatter DTF_DATETIME_FORMAT_EN_7 = ofPattern(FMT_DATETIME_FORMAT_EN_7);
	
	//yyyy/M/dd HH:mm:ss
	private static final Pattern PT_DATETIME_FORMAT_EN_8 =
			Pattern.compile("\\d{4}/\\d{1}/\\d{2}(\\s+)\\d{1}:\\d{2}:\\d{2}");
	private static final String FMT_DATETIME_FORMAT_EN_8 = "yyyy/M/dd H:mm:ss";
	private static final DateTimeFormatter DTF_DATETIME_FORMAT_EN_8 = ofPattern(FMT_DATETIME_FORMAT_EN_8);
	
	//yyyy/M/d HH:mm:ss
	private static final Pattern PT_DATETIME_FORMAT_EN_9 =
			Pattern.compile("\\d{4}/\\d{1}/\\d{1}(\\s+)\\d{1}:\\d{2}:\\d{2}");
	private static final String FMT_DATETIME_FORMAT_EN_9 = "yyyy/M/d H:mm:ss";
	private static final DateTimeFormatter DTF_DATETIME_FORMAT_EN_9 = ofPattern(FMT_DATETIME_FORMAT_EN_9);
	
	private static final String UTC_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	private static final String UTC_DATETIME_FORMAT2 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	
	private DateUtils() {
	}
	
	public static void clearThreadLocal() {
		SimpleDateFormatHolder.clearThreadLocal();
	}
	
	/**
	 * 采用"yyyy-MM-dd HH:mm:ss"格式化Date对象, 时区为"Asia/Shanghai", Locale为CHINA
	 *
	 * @param date
	 * @return String
	 */
	public static String format(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME);
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 根据指定的format格式化Date对象, 时区为"Asia/Shanghai", Locale为CHINA
	 *
	 * @param date
	 * @return String
	 */
	public static String format(Date date, String format) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = SimpleDateFormatHolder.formatFor(format);
		return simpleDateFormat.format(date);
	}
	
	public static String format(Date date, String format, Locale locale) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = SimpleDateFormatHolder.formatFor(format, locale);
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 采用"yyyy-MM-dd HH:mm:ss", 根据指定的时区格式化Date对象
	 *
	 * @param date
	 * @return String
	 */
	public static String format(Date date, TimeZone timeZone) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME, timeZone);
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 根据指定格式及时区格式化Date对象
	 *
	 * @param date
	 * @param format
	 * @param timeZone
	 * @return String
	 */
	public static String format(Date date, String format, TimeZone timeZone) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = SimpleDateFormatHolder.formatFor(format, timeZone);
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 采用"yyyy-MM-dd HH:mm:ss", 指定的时区和locale格式化Date对象
	 *
	 * @param date
	 * @param timeZone
	 * @param locale
	 * @return String
	 */
	public static String format(Date date, TimeZone timeZone, Locale locale) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME, timeZone, locale);
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 根据指定的format, 指定的时区和locale格式化Date对象
	 *
	 * @param date
	 * @param format
	 * @param timeZone
	 * @param locale
	 * @return String
	 */
	public static String format(Date date, String format, TimeZone timeZone, Locale locale) {
		if (date == null) {
			return null;
		}
		Objects.requireNonNull(format);
		SimpleDateFormat simpleDateFormat = SimpleDateFormatHolder.formatFor(format, timeZone, locale);
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 根据指定的format格式化LocalDate对象
	 *
	 * @param localDate
	 * @param format
	 * @return String
	 */
	public static String format(LocalDate localDate, String format) {
		if (localDate == null) {
			return null;
		}
		return localDate.format(ofPattern(format));
	}
	
	/**
	 * 根据指定的format格式化LocalDateTime对象
	 *
	 * @param localDateTime
	 * @param format
	 * @return String
	 */
	public static String format(LocalDateTime localDateTime, String format) {
		if (localDateTime == null) {
			return null;
		}
		return localDateTime.format(ofPattern(format));
	}
	
	/**
	 * 用ISO 日期格式化 yyyy-MM-dd HH:mm:ss
	 *
	 * @param localDateTime
	 * @return String
	 */
	public static String format(LocalDateTime localDateTime) {
		if (localDateTime == null) {
			return null;
		}
		return localDateTime.format(ofPattern(FMT_ISO_DATETIME));
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	
	/**
	 * 根据正则表达式匹配日期格式并解析日期字符串, 时区为"Asia/Shanghai", Locale为CHINA
	 *
	 * @param source
	 * @return Date
	 */
	public static Date parse(String source) {
		if (source == null || "".equals(source.trim())) {
			return null;
		}
		
		SimpleDateFormat simpleDateFormat = null;
		/**
		 * 把最常用的格式放前面
		 */
		if (PT_ISO_DATETIME.matcher(source).matches()) { // yyyy-MM-dd HH:mm:ss
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_1);
		} else if (PT_ISO_DATE.matcher(source).matches()) { // yyyy-MM-dd
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATE);
		} else if (PT_ISO_DATETIME_1.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_1);
		} else if (PT_ISO_DATETIME_2.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_2);
		} else if (PT_ISO_DATETIME_3.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_3);
		} else if (PT_ISO_DATETIME_4.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_4);
		} else if (PT_ISO_DATETIME_5.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_5);
		} else if (PT_ISO_DATETIME_SHORT.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT);
		} else if (PT_ISO_DATETIME_SHORT_1.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_1);
		} else if (PT_ISO_DATETIME_SHORT_2.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_2);
		} else if (PT_ISO_DATETIME_SHORT_3.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_3);
		} else if (PT_ISO_DATETIME_SHORT_4.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_4);
		} else if (PT_ISO_DATETIME_SHORT_5.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_5);
		} else if (PT_ISO_DATETIME_SHORT_6.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_6);
		} else if (PT_ISO_DATETIME_SHORT_7.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_7);
		} else if (PT_DATETIME_FORMAT_EN.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN);
		} else if (PT_DATETIME_FORMAT_EN_1.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_1);
		} else if (PT_DATETIME_FORMAT_EN_2.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_2);
		} else if (PT_DATETIME_FORMAT_EN_3.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_3);
		} else if (PT_DATETIME_FORMAT_EN_4.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_4);
		} else if (PT_DATETIME_FORMAT_EN_5.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_5);
		} else if (PT_DATETIME_FORMAT_EN_6.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_6);
		} else if (PT_DATETIME_FORMAT_EN_7.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_7);
		} else if (PT_DATETIME_FORMAT_EN_8.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_8);
		} else if (PT_DATETIME_FORMAT_EN_9.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_9);
		} else if (PT_ISO_DATE_1.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATE_1);
		} else if (PT_ISO_DATE_2.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATE_2);
		} else if (PT_ISO_DATE_3.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATE_3);
		} else if (PT_DATE_EN.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN);
		} else if (PT_DATE_EN_1.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_1);
		} else if (PT_DATE_EN_2.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_2);
		} else if (PT_DATE_EN_3.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_3);
		} else if (PT_DATE_EN_4.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_4);
		} else if (PT_DATE_EN_5.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_5);
		} else if (PT_DATE_EN_6.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_6);
		} else if (PT_DATE_EN_7.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_7);
		}
		
		if (simpleDateFormat == null) {
			log.info("No suitable Dateformat found!");
			return null;
		}
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			log.error(MessageFormat.format("Parse date string:[{0}]", source));
		}
		return null;
	}
	
	/**
	 * 根据指定的format解析日期字符串, 时区为"Asia/Shanghai", Locale为CHINA
	 *
	 * @param source
	 * @param format
	 * @return Date
	 */
	public static Date parse(String source, String format) {
		if (isBlank(source)) {
			return null;
		}
		Objects.requireNonNull(format);
		SimpleDateFormat simpleDateFormat = SimpleDateFormatHolder.formatFor(format);
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			log.error(MessageFormat.format("Parse date string:[{0}]", source));
		}
		return null;
	}
	
	/**
	 * 采用"yyyy-MM-dd HH:mm:ss", 根据指定的时区解析日期字符串
	 *
	 * @param source
	 * @return Date
	 */
	public static Date parse(String source, TimeZone timezone) {
		if (source == null || "".equals(source.trim())) {
			return null;
		}
		
		SimpleDateFormat simpleDateFormat = null;
		if (PT_ISO_DATETIME.matcher(source).matches()) { // yyyy-MM-dd HH:mm:ss
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_1, timezone);
		} else if (PT_ISO_DATE.matcher(source).matches()) { // yyyy-MM-dd
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATE, timezone);
		} else if (PT_ISO_DATETIME_1.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_1, timezone);
		} else if (PT_ISO_DATETIME_2.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_2, timezone);
		} else if (PT_ISO_DATETIME_3.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_3, timezone);
		} else if (PT_ISO_DATETIME_4.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_4, timezone);
		} else if (PT_ISO_DATETIME_5.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_5, timezone);
		} else if (PT_ISO_DATETIME_SHORT.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT, timezone);
		} else if (PT_ISO_DATETIME_SHORT_1.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_1, timezone);
		} else if (PT_ISO_DATETIME_SHORT_2.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_2, timezone);
		} else if (PT_ISO_DATETIME_SHORT_3.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_3, timezone);
		} else if (PT_ISO_DATETIME_SHORT_4.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_4, timezone);
		} else if (PT_ISO_DATETIME_SHORT_5.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_5, timezone);
		} else if (PT_ISO_DATETIME_SHORT_6.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_6, timezone);
		} else if (PT_ISO_DATETIME_SHORT_7.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME_SHORT_7, timezone);
		} else if (PT_DATETIME_FORMAT_EN.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN, timezone);
		} else if (PT_DATETIME_FORMAT_EN_1.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_1, timezone);
		} else if (PT_DATETIME_FORMAT_EN_2.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_2, timezone);
		} else if (PT_DATETIME_FORMAT_EN_3.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_3, timezone);
		} else if (PT_DATETIME_FORMAT_EN_4.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_4, timezone);
		} else if (PT_DATETIME_FORMAT_EN_5.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_5, timezone);
		} else if (PT_DATETIME_FORMAT_EN_6.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_6, timezone);
		} else if (PT_DATETIME_FORMAT_EN_7.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_7, timezone);
		} else if (PT_DATETIME_FORMAT_EN_8.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_8, timezone);
		} else if (PT_DATETIME_FORMAT_EN_9.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATETIME_FORMAT_EN_9, timezone);
		} else if (PT_ISO_DATE_1.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATE_1, timezone);
		} else if (PT_ISO_DATE_2.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATE_2, timezone);
		} else if (PT_ISO_DATE_3.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATE_3, timezone);
		} else if (PT_DATE_EN.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN, timezone);
		} else if (PT_DATE_EN_1.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_1, timezone);
		} else if (PT_DATE_EN_2.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_2, timezone);
		} else if (PT_DATE_EN_3.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_3, timezone);
		} else if (PT_DATE_EN_4.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_4, timezone);
		} else if (PT_DATE_EN_5.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_5, timezone);
		} else if (PT_DATE_EN_6.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_6, timezone);
		} else if (PT_DATE_EN_7.matcher(source).matches()) {
			simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_DATE_FORMAT_EN_7, timezone);
		}
		
		if (simpleDateFormat == null) {
			log.info("No suitable Dateformat found!");
			return null;
		}
		
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			log.error(MessageFormat.format("Parse date string:[{0}]", source));
		}
		return null;
	}
	
	/**
	 * 根据指定的format, 指定的时区解析日期字符串
	 *
	 * @param source
	 * @param format
	 * @return Date
	 */
	public static Date parse(String source, String format, TimeZone timezone) {
		if (source == null || "".equals(source.trim())) {
			return null;
		}
		Objects.requireNonNull(format);
		SimpleDateFormat simpleDateFormat = SimpleDateFormatHolder.formatFor(format, timezone);
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			log.error(MessageFormat.format("Parse date string:[{0}] with timezone:[{1}] and format:[{2}] failed!",
					source, timezone,
					format));
		}
		return null;
	}
	
	/**
	 * 根据指定的format, 指定的时区解析日期字符串
	 *
	 * @param source
	 * @param format
	 * @return Date
	 */
	public static Date parse(String source, String format, Locale locale) {
		if (source == null || "".equals(source.trim())) {
			return null;
		}
		Objects.requireNonNull(format);
		SimpleDateFormat simpleDateFormat = SimpleDateFormatHolder.formatFor(format, locale);
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			log.error(MessageFormat.format("Parse date string:[{0}] with locale:[{1}] and format:[{2}] failed!",
					source, locale,
					format));
		}
		return null;
	}
	
	/**
	 * 采用"yyyy-MM-dd HH:mm:ss", 指定的时区和locale解析日期字符串
	 * 
	 * @param source
	 * @param timezone
	 * @param locale
	 * @return Date
	 */
	public static Date parse(String source, TimeZone timezone, Locale locale) {
		if (source == null || "".equals(source.trim())) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = SimpleDateFormatHolder.formatFor(FMT_ISO_DATETIME, timezone, locale);
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			log.error(MessageFormat.format(
					"Parse date string:[{0}] with timezone:[{1}], locale:[{2}] and format:[{3}] failed!",
					source, timezone, locale, FMT_ISO_DATETIME));
		}
		return null;
	}
	
	/**
	 * 根据指定的format, 指定的时区和locale解析日期字符串
	 *
	 * @param source
	 * @param format
	 * @return Date
	 */
	public static Date parse(String source, String format, TimeZone timezone, Locale locale) {
		if (source == null || "".equals(source.trim())) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = SimpleDateFormatHolder.formatFor(format, timezone, locale);
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			log.error(MessageFormat.format(
					"Parse date string:[{0}] with timezone:[{1}], locale:[{2}] and format:[{3}] failed!",
					source, timezone, locale, format));
		}
		return null;
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	
	/**
	 * 采用"yyyy-MM-dd HH:mm:ss"格式将日期字符串从srcTimezone转换成destTimezone日期字符串
	 *
	 * @param source
	 * @param srcTimezone
	 * @param destTimezone
	 * @return String
	 */
	public static String convert2TargetTimezone(String source, TimeZone srcTimezone, TimeZone destTimezone) {
		if (source == null || "".equals(source.trim())) {
			return null;
		}
		Date srcDate = parse(source, srcTimezone);
		return format(srcDate, destTimezone);
	}
	
	
	/**
	 * 根据指定格式将日期字符串从srcTimezone转换成destTimezone日期字符串
	 *
	 * @param source
	 * @param srcTimezone
	 * @param destTimezone
	 * @return String
	 */
	public static String convert2TargetTimezone(String source, String format, TimeZone srcTimezone,
												TimeZone destTimezone) {
		if (isBlank(source)) {
			return null;
		}
		Objects.requireNonNull(format);
		Date srcDate = parse(source, format, srcTimezone);
		return format(srcDate, format, destTimezone);
	}
	
	/**
	 * 根据指定格式将日期字符串从srcTimezone转换成destTimezone, destFormat日期字符串
	 *
	 * @param source
	 * @param srcFormat
	 * @param destFormat
	 * @param srcTimezone
	 * @param destTimezone
	 * @return String
	 */
	public static String convert2TargetTimezone(String source, String srcFormat, String destFormat,
												TimeZone srcTimezone,
												TimeZone destTimezone) {
		if (source == null || "".equals(source.trim())) {
			return null;
		}
		Objects.requireNonNull(srcFormat);
		Objects.requireNonNull(destFormat);
		Date srcDate = parse(source, srcFormat, srcTimezone);
		return format(srcDate, destFormat, destTimezone);
	}
	
	
	private static boolean isBlank(String s) {
		return s == null || "".equals(s.trim());
	}
}
