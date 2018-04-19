package com.chalat.utils.date

import android.annotation.SuppressLint
import android.text.format.DateUtils
import com.chalat.utils.device.LocaleUtils
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    private const val DISPLAY_DATE_AND_MONTH_PATTERN = "dd MMMM"
    private const val DISPLAY_DATE_MONTH_YEAR_PATTERN = "dd MMMM yyyy"

    //Time formatIso8601 2018-01-17T04:06:30.123Z
    internal const val ISO_8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

    private val UtcTimeZone = TimeZone.getTimeZone("UTC")

    @SuppressLint("SimpleDateFormat")
    fun convertToDateUtc(dateTime: String): Date {
        val format = SimpleDateFormat(ISO_8601_PATTERN)
        format.timeZone = UtcTimeZone
        return format.parse(dateTime)
    }

    @SuppressLint("SimpleDateFormat")
    fun convertToStringUtc(dateTime: Date): String {
        val format = SimpleDateFormat(ISO_8601_PATTERN)
        format.timeZone = UtcTimeZone
        return format.format(dateTime)
    }


    fun getTimeAgo(date: Date): String {
        return DateUtils.getRelativeTimeSpanString(date.time).toString()
    }

    fun getCurrentDayAndMonth(): String {
        val date = Calendar.getInstance().time
        val format = SimpleDateFormat(DISPLAY_DATE_AND_MONTH_PATTERN, LocaleUtils.getLocale())
        return format.format(date)
    }

    fun isCurrentTimeInRange(startTime: Date, endTime:Date): Boolean {
        val currentTime = Calendar.getInstance(LocaleUtils.getLocale()).time
        return isTimeInRange(currentTime, startTime, endTime)
    }

    fun isTimeInRange(time: Date, startTime: Date, endTime:Date): Boolean {
        return time.after(startTime) and time.before(endTime)
    }

    fun getCurrentDayMonthYear(): String {
        val date = Calendar.getInstance().time
        val format = SimpleDateFormat(DISPLAY_DATE_MONTH_YEAR_PATTERN, LocaleUtils.getLocale())
        return format.format(date)
    }

    fun convertDateToDayMonthYear(date: Date): String {
        val format = SimpleDateFormat(DISPLAY_DATE_MONTH_YEAR_PATTERN, LocaleUtils.getLocale())
        return format.format(date)
    }

    fun convertDateToDayMonth(date: Date): String {
        val format = SimpleDateFormat(DISPLAY_DATE_AND_MONTH_PATTERN, LocaleUtils.getLocale())
        return format.format(date)
    }

    fun getCurrentDate(): Date {
        return Calendar.getInstance().time
    }

}