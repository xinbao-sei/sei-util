package com.changhong.sei.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * <strong>实现功能:</strong>.
 * <p>日期时间工具类</p>
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.1 2017/03/06 21:33
 */
public class DateUtils {

    public final static String DEFAULT_TIMEZONE = "GMT+8";

    public final static String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    public final static String ISO_SHORT_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    public final static String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public final static String DEFAULT_ONLY_TIME_FORMAT = "HH:mm:ss";

    public final static String SHORT_TIME_FORMAT = "yyyy-MM-dd HH:mm";

    public final static String FULL_SEQ_FORMAT = "yyyyMMddHHmmssSSS";

    public final static String[] MULTI_FORMAT = {DEFAULT_DATE_FORMAT, DEFAULT_TIME_FORMAT, ISO_DATE_TIME_FORMAT, ISO_SHORT_DATE_TIME_FORMAT,
            SHORT_TIME_FORMAT, "yyyy-MM"};

    public final static String FORMAT_YYYY = "yyyy";

    public final static String FORMAT_YYYYMM = "yyyyMM";

    public final static String FORMAT_YYYYMMDD = "yyyyMMdd";

    public final static String FORMAT_YYYYMMDDHH = "yyyyMMddHH";

    public final static String FORMAT_CORN = "ss mm HH dd MM ? yyyy";


    /**
     * 日期转字符串
     * 默认格式: {@linkplain DateUtils#DEFAULT_DATE_FORMAT}
     *
     * @param date 日期对象
     * @return 返回格式化字符串
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
    }

    /**
     * 将日期时间对象转化为日期数字
     *
     * @param date   日期字符串 {@linkplain DateUtils#SHORT_TIME_FORMAT}
     * @param format 格式字符串
     * @return 返回日期数字
     */
    public static String formatDate(Date date, String format) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 将日期时间对象转化为corn表达式
     *
     * @param date 时间点
     * @return convert Date to cron ,eg.  "0 06 10 15 10 ? 2018"
     */
    public static String formatDateToCorn(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(FORMAT_CORN).format(date);
    }

    /**
     * 将日期时间对象转化为日期数字
     *
     * @param date   日期字符串 {@linkplain DateUtils#SHORT_TIME_FORMAT}
     * @param format 格式字符串
     * @return 返回日期数字
     */
    public static Integer formatDateToInt(Date date, String format) {
        if (date == null) {
            return null;
        }
        return Integer.valueOf(new SimpleDateFormat(format).format(date));
    }

    /**
     * 将日期时间对象转化为日期数字
     *
     * @param date   日期字符串 {@linkplain DateUtils#SHORT_TIME_FORMAT}
     * @param format 格式字符串
     * @return 返回日期数字
     */
    public static Long formatDateToLong(Date date, String format) {
        if (date == null) {
            return null;
        }
        return Long.valueOf(new SimpleDateFormat(format).format(date));
    }

    /**
     * 将日期时间对象转化为日期字符串
     *
     * @param date 日期字符串 {@linkplain DateUtils#DEFAULT_TIME_FORMAT}
     * @return 返回日期字符串
     */
    public static String formatTime(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(DEFAULT_TIME_FORMAT).format(date);
    }

    /**
     * 将日期时间对象转化为日期字符串
     *
     * @param date 日期字符串 {@linkplain DateUtils#SHORT_TIME_FORMAT}
     * @return 返回日期字符串
     */
    public static String formatShortTime(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(SHORT_TIME_FORMAT).format(date);
    }

    /**
     * 将日期时间字符串转化为日期对象
     *
     * @param date   日期字符串
     * @param format 格式串
     * @return 返回日期对象
     */
    public static Date parseDate(String date, String format) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将日期时间字符串转化为日期对象
     *
     * @param date   日期字符串
     * @param format 格式串
     * @return 返回日期对象
     */
    public static Date parseTime(String date, String format) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将日期字符串转化为日期对象
     * @param date
     * @param format
     * @return
     */
    public static LocalDate parseLocalDate(String date, String format) {
        if (date == null) {
            return null;
        }
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 将日期字符串转化为日期对象，格式为yyyy-MM-dd
     * @param date
     * @return
     */
    public static LocalDate parseLocalDate(String date) {
        return parseLocalDate(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将日期字符串转化为日期时间对象
     * @param date
     * @param format
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String date, String format) {
        if (date == null) {
            return null;
        }
        try {
            return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

/**
     * 将日期字符串转化为日期对象，格式为yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String date) {
        return parseLocalDateTime(date, DEFAULT_TIME_FORMAT);
    }

    /**
     * 将日期对象转化为日期字符串
     * @param localDate
     * @param format
     * @return
     */
    public static String localDateToString(LocalDate localDate, String format) {
        if (localDate == null) {
            return null;
        }
        try {
            return localDate.format(DateTimeFormatter.ofPattern(format));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将日期对象转化为日期字符串，格式为yyyy-MM-dd
     * @param localDate
     * @return
     */
    public static String localDateToString(LocalDate localDate) {
        return localDateToString(localDate, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将日期时间对象转化为日期字符串
     * @param localDateTime
     * @param format
     * @return
     */
    public static String localDateTimeToString(LocalDateTime localDateTime, String format) {
        if (localDateTime == null) {
            return null;
        }
        try {
            return localDateTime.format(DateTimeFormatter.ofPattern(format));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将日期时间对象转化为日期字符串，格式为yyyy-MM-dd HH:mm:ss
     * @param localDateTime
     * @return
     */
    public static String localDateTimeToString(LocalDateTime localDateTime) {
        return localDateTimeToString(localDateTime, DEFAULT_TIME_FORMAT);
    }


    /**
     * 将日期对象Date转化为日期LocalDate对象
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 将日期Date对象转化为日期时间LocalDate对象
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 将日期时间字符串转化为日期对象
     *
     * @param date 日期字符串 {@linkplain DateUtils#DEFAULT_TIME_FORMAT}
     * @return 返回日期对象
     */
    public static Date parseDate(String date) {
        return parseDate(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将日期时间字符串转化为日期对象
     *
     * @param date 日期字符串 {@linkplain DateUtils#DEFAULT_TIME_FORMAT}
     * @return 返回日期对象
     */
    public static Date parseTime(String date) {
        return parseTime(date, DEFAULT_TIME_FORMAT);
    }

    /**
     * 计算两个日期之间的天数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 返回两个日期之间的天数
     */
    public static long getDaysBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }


    /**
     * 对差异时间的格式化显示，方便人工查看
     *
     * @param diffMillis 差异时间(毫秒)
     * @return 人能看懂的字符串
     */
    public static String getHumanDisplayForTimediff(Long diffMillis) {
        if (diffMillis == null) {
            return "";
        }
        long day = diffMillis / (24 * 60 * 60 * 1000);
        long hour = (diffMillis / (60 * 60 * 1000) - day * 24);
        long min = ((diffMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long se = (diffMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        StringBuilder sb = new StringBuilder();
        if (day > 0) {
            sb.append(day).append("D");
        }
        DecimalFormat df = new DecimalFormat("00");
        sb.append(df.format(hour)).append(":");
        sb.append(df.format(min)).append(":");
        sb.append(df.format(se));
        return sb.toString();
    }

    /**
     * 获取日期相差天数
     *
     * @param beginDate 字符串类型开始日期
     * @param endDate   字符串类型结束日期
     * @return Long 日期相差天数
     */
    public static Long getDiffDay(String beginDate, String endDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        Long checkday = 0L;
        //开始结束相差天数
        try {
            checkday = (formatter.parse(endDate).getTime() - formatter.parse(beginDate).getTime()) / (1000 * 24 * 60 * 60);
        } catch (ParseException e) {

            e.printStackTrace();
            checkday = null;
        }
        return checkday;
    }

    /**
     * 获取日期相差天数
     *
     * @param beginDate Date类型开始日期
     * @param endDate   Date类型结束日期
     * @return Long 相差天数
     */
    public static Long getDiffDay(Date beginDate, Date endDate) {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        String strBeginDate = format.format(beginDate);

        String strEndDate = format.format(endDate);
        return getDiffDay(strBeginDate, strEndDate);
    }

    /**
     * N天之后
     *
     * @param n    天数
     * @param date 日期
     * @return n天之后
     */
    public static Date nDaysAfter(Integer n, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + n);
        return cal.getTime();
    }

    /**
     * N年之后
     *
     * @param n    年数
     * @param date 日期
     * @return n年之后
     */
    public static Date nYearsAfter(Integer n, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + n);
        return cal.getTime();
    }

    /**
     * N天之前
     *
     * @param n    天数
     * @param date 日期
     * @return N天之后
     */
    public static Date nDaysAgo(Integer n, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - n);
        return cal.getTime();
    }

    /**
     * N年之前
     *
     * @param n    年数
     * @param date 日期
     * @return n年之前
     */
    public static Date nYearsAgo(Integer n, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - n);
        return cal.getTime();
    }

    /**
     * 指定日期在全年中的第几周
     *
     * @param date 日期
     * @return 返回日期在这一年中的周数
     */
    public static Integer getWeekOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return Integer.valueOf(formatDate(date, FORMAT_YYYY) + c.get(Calendar.WEEK_OF_YEAR));
    }

    /**
     * 获取当前日期时间
     *
     * @return 返回当前日期时间
     */
    public static Date getCurrentDateTime() {
        return new Date();
    }

    /**
     * 获取当前日期
     *
     * @return 返回当前日期
     */
    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        //获取年份
        int year = calendar.get(Calendar.YEAR);
        //获取月份
        int month = calendar.get(Calendar.MONTH);
        //获取日
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 日期格式化为年月日的日期
     *
     * @param date 日期
     * @return 年月日的日期
     */
    public static Date formatDate2Date(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        //获取年份
        int year = calendar.get(Calendar.YEAR);
        //获取月份
        int month = calendar.get(Calendar.MONTH);
        //获取日
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static LocalDate date2LocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date localDate2Date(LocalDate localDate) {
        if (null == localDate) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    public static LocalDateTime date2LocalDateTime(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(DateUtils.formatDate(c.getTime(), DateUtils.FORMAT_YYYYMMDD));
        System.out.println(DateUtils.formatDate(c.getTime(), DateUtils.FULL_SEQ_FORMAT));

        System.out.println(formatDate2Date(c.getTime()));

        Date date = getCurrentDate();
        System.out.println(date);
        System.out.println(formatDate(date, ISO_DATE_TIME_FORMAT));
        date = getCurrentDateTime();
        System.out.println(date);
        System.out.println(formatDate(date, ISO_DATE_TIME_FORMAT));
    }

}
