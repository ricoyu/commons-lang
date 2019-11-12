package com.loserico.common.lang.utils;

import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

/**
 * A factory for {@link SimpleDateFormat}s. The instances are stored in a threadlocal way
 * because SimpleDateFormat is not threadsafe as noted in {@link SimpleDateFormat its javadoc}.
 */
final class SimpleDateFormatHolder {
	
	private static final TimeZone CHINA = TimeZone.getTimeZone("Asia/Shanghai");
	private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
	
	private static final Map<TimeZone, Locale> TIME_ZONE_LOCALE_HASH_MAP = new HashMap<>();
	static {
		TIME_ZONE_LOCALE_HASH_MAP.put(CHINA, Locale.CHINA);
		TIME_ZONE_LOCALE_HASH_MAP.put(GMT, Locale.ENGLISH);
	}
	
	private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> THREADLOCAL_FORMATS =
			new ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>>();
	
	/**
	 * 获取SimpleDateFormat对象，timezone默认为Asia/Shanghai，locale为SIMPLIFIED_CHINESE
	 *
	 * @param pattern
	 * @return
	 */
	public static SimpleDateFormat formatFor(final String pattern) {
		Objects.requireNonNull(pattern);
		final SoftReference<Map<String, SimpleDateFormat>> ref = THREADLOCAL_FORMATS.get();
		Map<String, SimpleDateFormat> formats = ref == null ? null : ref.get();
		if (formats == null) {
			formats = new HashMap<String, SimpleDateFormat>();
			THREADLOCAL_FORMATS.set(new SoftReference<Map<String, SimpleDateFormat>>(formats));
		}
		
		SimpleDateFormat format = formats.get(pattern);
		if (format == null) {
			format = new SimpleDateFormat(pattern, Locale.CHINA);
			format.setTimeZone(CHINA);
			formats.put(pattern, format);
		}
		
		return format;
	}
	
	/**
	 * 根据format和timezone获取SimpleDateFormat对象，根据时区决定locale是什么
	 *
	 * @param pattern
	 * @param timezone
	 * @return
	 */
	public static SimpleDateFormat formatFor(final String pattern, TimeZone timezone) {
		Objects.requireNonNull(pattern);
		final SoftReference<Map<String, SimpleDateFormat>> ref = THREADLOCAL_FORMATS.get();
		Map<String, SimpleDateFormat> formats = ref == null ? null : ref.get();
		if (formats == null) {
			formats = new HashMap<String, SimpleDateFormat>();
			THREADLOCAL_FORMATS.set(new SoftReference<Map<String, SimpleDateFormat>>(formats));
		}
		
		SimpleDateFormat format = formats.get(pattern + timezone.getID());
		if (format == null) {
			Locale locale = TIME_ZONE_LOCALE_HASH_MAP.get(timezone.getID());
			if (locale == null) {
				format = new SimpleDateFormat(pattern);
			} else {
				format = new SimpleDateFormat(pattern, locale);
			}
			format.setTimeZone(timezone);
			formats.put(pattern + timezone.getID(), format);
		}
		
		return format;
	}
	
	/**
	 * 根据format,locale获取SimpleDateFormat对象，显示指定locale
	 *
	 * @param pattern
	 * @param locale
	 * @return
	 */
	public static SimpleDateFormat formatFor(final String pattern, Locale locale) {
		Objects.requireNonNull(pattern);
		final SoftReference<Map<String, SimpleDateFormat>> ref = THREADLOCAL_FORMATS.get();
		Map<String, SimpleDateFormat> formats = ref == null ? null : ref.get();
		if (formats == null) {
			formats = new HashMap<String, SimpleDateFormat>();
			THREADLOCAL_FORMATS.set(new SoftReference<Map<String, SimpleDateFormat>>(formats));
		}
		
		SimpleDateFormat format = formats.get(pattern + locale.getCountry());
		if (format == null) {
			format = new SimpleDateFormat(pattern, locale);
			formats.put(pattern + locale.getCountry(), format);
		}
		
		return format;
	}
	
	/**
	 * 根据format,timezone和locale获取SimpleDateFormat对象，显示指定timezone和locale
	 *
	 * @param pattern
	 * @param timezone
	 * @param locale
	 * @return
	 */
	public static SimpleDateFormat formatFor(final String pattern, TimeZone timezone, Locale locale) {
		Objects.requireNonNull(pattern);
		final SoftReference<Map<String, SimpleDateFormat>> ref = THREADLOCAL_FORMATS.get();
		Map<String, SimpleDateFormat> formats = ref == null ? null : ref.get();
		if (formats == null) {
			formats = new HashMap<String, SimpleDateFormat>();
			THREADLOCAL_FORMATS.set(new SoftReference<Map<String, SimpleDateFormat>>(formats));
		}
		
		SimpleDateFormat format = formats.get(pattern + timezone.getID() + locale.getCountry());
		if (format == null) {
			format = new SimpleDateFormat(pattern, locale);
			format.setTimeZone(timezone);
			formats.put(pattern + timezone.getID() + locale.getCountry(), format);
		}
		
		return format;
	}
	
	public static void clearThreadLocal() {
		THREADLOCAL_FORMATS.remove();
	}
	
}