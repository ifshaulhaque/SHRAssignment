package com.ifsha.shrassignment.enums

enum class WeekDay(
    val fullName: String
) {
    SUNDAY(fullName = "Sunday"),
    MONDAY(fullName = "Monday"),
    TUESDAY(fullName = "Tuesday"),
    WEDNESDAY(fullName = "Wednesday"),
    THURSDAY(fullName = "Thursday"),
    FRIDAY(fullName = "Friday"),
    SATURDAY(fullName = "Saturday");

    companion object {
        fun getWeekDayFromString(day: String): WeekDay? {
            return try {
                WeekDay.valueOf(day.uppercase())
            } catch (e: IllegalArgumentException) {
                null
            }
        }
    }
}