package com.cheng.stream.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateUtil {

	public static String formatDatetime(LocalDateTime localDateTime) {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
	}

	public static String formatDatetime(LocalDateTime localDateTime, String dateTimeFormat) {
		return DateTimeFormatter.ofPattern(dateTimeFormat).format(localDateTime);
	}

	public static LocalDateTime getDateTime(String dateStr, String dateTimeFormat) {
		return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(dateTimeFormat));
	}

	public static LocalDateTime getDateTime(String dateStr) {
		return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public static LocalDateTime getDateTime(Long milliseconds) {
		try {
			return LocalDateTime.ofInstant(Instant.ofEpochMilli(milliseconds), ZoneId.of("Asia/Shanghai"));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 返回毫秒
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public static Long duration(LocalDateTime start, LocalDateTime end) {
		return Duration.between(start, end).toMillis();
	}

	/**
	 * 返回天数
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public static Long daysBetween(LocalDateTime start, LocalDateTime end) {
		return Duration.between(start, end).toDays();
	}

	/**
	 * @param localDateTime
	 * @return
	 */
	public static Date getDate(LocalDateTime localDateTime) {
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zdt = localDateTime.atZone(zoneId);
		return Date.from(zdt.toInstant());
	}

	/**
	 * 获取本月第一天
	 *
	 * @return
	 */
	public static LocalDate getMonthFirstDay() {
		LocalDate today = LocalDate.now();
		return LocalDate.of(today.getYear(), today.getMonth(), 1);
	}

	/**
	 * 获取上个月第一天
	 *
	 * @return
	 */
	public static LocalDate getLastMonthFirstDay() {
		LocalDate today = LocalDate.now();
		LocalDate date = LocalDate.of(today.getYear(), today.getMonth(), 1);
		return date.minusMonths(1);
	}

	/**
	 * 获取前某个月的第一天
	 *
	 * @param num
	 * @return
	 */
	public static LocalDate getCertainMonthFirstDay(Integer num) {
		LocalDate today = LocalDate.now();
		LocalDate date = LocalDate.of(today.getYear(), today.getMonth(), 1);
		return date.minusMonths(num);
	}

	/**
	 * 获取当天零点
	 *
	 * @return
	 */
	public static LocalDateTime getTodayStartTime() {
		//获取当前日期
		LocalDate nowDate = LocalDate.now();
		//设置零点
		return LocalDateTime.of(nowDate, LocalTime.MIN);
	}

	/**
	 * 获取当天结束时间 23:59:59
	 *
	 * @return
	 */
	public static LocalDateTime getTodayEndTime() {
		//获取当前日期
		LocalDate nowDate = LocalDate.now();
		//设置当天的结束时间
		return LocalDateTime.of(nowDate, LocalTime.MAX);
	}

	/**
	 * 获取当月第一天零点
	 * @return
	 */
	public static LocalDateTime getCurrentMonthFirstDay(){
		LocalDate today = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
		return LocalDateTime.of(today, LocalTime.MIN);
	}

	/**
	 * 获取本月最后一天最后一秒
	 * @return
	 */
	public static LocalDateTime getCurrentMonthLastDay(){
		LocalDate today = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
		return LocalDateTime.of(today, LocalTime.MAX);
	}
}
