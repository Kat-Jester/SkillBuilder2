import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * This class provides various static methods that calculate various quantities
 * related to dates, including the day of week a date fall on.
 * @author
 * @version
 */
public class Date {
    /**
     * Returns true if the year is a leap year; otherwise false
     *
     * @param year the year
     * @return true if the year is a leap year; otherwise false.
     */
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Returns the name of the day given by dayValue
     *
     * @param dayValue Numerical value of the day in the range 0 to 6, inclusively
     * @return the name of the day given by dayValue
     */
    public static String getNameOfDay(int dayValue) {
        if (dayValue == 0 || dayValue == -6) {
            return "Sunday";
        } else if (dayValue == 1 || dayValue == -5) {
            return "Monday";
        } else if (dayValue == 2 || dayValue == -4) {
            return "Tuesday";
        } else if (dayValue == 3 || dayValue == -3) {
            return "Wednesday";
        } else if (dayValue == 4 || dayValue == -2) {
            return "Thursday";
        } else if (dayValue == 5 || dayValue == -1) {
            return "Friday";
        } else if (dayValue == 6) {
            return "Saturday";
        } else
            return null;
    }

    /**
     * \
     * Returns the numeric value of the month.
     * 1 - January
     * 2 - February
     * ...
     * 12 - December
     *
     * @param name name of the month
     * @return the numeric value of the month.
     */
    public static int getMonthNumber(String name) {
        if (name.equalsIgnoreCase("January")) {
            return 1;
        } else if (name.equalsIgnoreCase("February")) {
            return 2;
        } else if (name.equalsIgnoreCase("March")) {
            return 3;
        } else if (name.equalsIgnoreCase("April")) {
            return 4;
        } else if (name.equalsIgnoreCase("May")) {
            return 5;
        } else if (name.equalsIgnoreCase("June")) {
            return 6;
        } else if (name.equalsIgnoreCase("July")) {
            return 7;
        } else if (name.equalsIgnoreCase("August")) {
            return 8;
        } else if (name.equalsIgnoreCase("September")) {
            return 9;
        } else if (name.equalsIgnoreCase("October")) {
            return 10;
        } else if (name.equalsIgnoreCase("November")) {
            return 11;
        } else if (name.equalsIgnoreCase("December")) {
            return 12;
        } else {
            return -1;
        }
    }

    /**
     * Returns the name of the month given the numeric value provided by month
     * 1 - January
     * 2 - February
     * ...
     * 12 - December
     *
     * @param month Numeric value of the month.  Should be 1 to 12, inclusively
     * @return the name of the month given the numeric value provided by month
     */
    public static String getMonthName(int month) {
        if (month == 1) {
            return "January";
        } else if (month == 2) {
            return "February";
        } else if (month == 3) {
            return "March";
        } else if (month == 4) {
            return "April";
        } else if (month == 5) {
            return "May";
        } else if (month == 6) {
            return "June";
        } else if (month == 7) {
            return "July";
        } else if (month == 8) {
            return "August";
        } else if (month == 9) {
            return "September";
        } else if (month == 10) {
            return "October";
        } else if (month == 11) {
            return "November";
        } else if (month == 12) {
            return "December";
        } else
            return null;
    }

    /**
     * Returns the number of days in the month given by the parameter month
     *
     * @param month the numeric value of the month
     * @param year  year
     * @return the number of days in the month given by the parameter month
     */
    public static int getDaysInMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return -1;
        }
    }

    public static int getDaysInMonth(String month, int year) {

        month = month.toLowerCase().trim();

        if (month.equals("january")) {
            return 31;
        } else if (month.equals("february")) {
            // Leap year check
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month.equals("march")) {
            return 31;
        } else if (month.equals("april")) {
            return 30;
        } else if (month.equals("may")) {
            return 31;
        } else if (month.equals("june")) {
            return 30;
        } else if (month.equals("july")) {
            return 31;
        } else if (month.equals("august")) {
            return 31;
        } else if (month.equals("september")) {
            return 30;
        } else if (month.equals("october")) {
            return 31;
        } else if (month.equals("november")) {
            return 30;
        } else if (month.equals("december")) {
            return 31;
        } else {
            return -1;
        }
    }

    /**
     * Returns the offset in days for the month relative to January
     *
     * @param month numeric value of the month
     * @param year  year
     * @return the offset in days for the month relative to January
     */
    public static int getMonthOffset(int month, int year) {
        if (month < 1 || month > 12) {
            return -1;
        }

        // Leap Year Check
        boolean isLeapYear = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeapYear = true;
                } else {
                    isLeapYear = false;
                }
            } else {
                isLeapYear = true;
            }
        }


        if (month == 1) return 0;
        else if (month == 2) return 3;
        else if (month == 3) return isLeapYear ? 4 : 3;
        else if (month == 4) return isLeapYear ? 0 : 6;
        else if (month == 5) return isLeapYear ? 2 : 1;
        else if (month == 6) return isLeapYear ? 5 : 4;
        else if (month == 7) return isLeapYear ? 0 : 6;
        else if (month == 8) return isLeapYear ? 3 : 2;
        else if (month == 9) return isLeapYear ? 6 : 5;
        else if (month == 10) return isLeapYear ? 1 : 0;
        else if (month == 11) return isLeapYear ? 4 : 3;
        else return isLeapYear ? 6 : 5;

    }


    /**
     * Returns the day of the week that the date falls on
     *
     * @param month      numeric value of the month
     * @param dayOfMonth day of the month
     * @param year       year
     * @return the day of the week that the date falls on
     */
    public static int dayOfWeek(int month, int dayOfMonth, int year) {
        if (month < 1 || month > 12) {
            return -1;
        }

        int daysInMonth;
        if (month == 2) {

            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                daysInMonth = 29;
            } else {
                daysInMonth = 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            daysInMonth = 30;
        } else {
            daysInMonth = 31;
        }

        if (dayOfMonth < 1 || dayOfMonth > daysInMonth) {
            return -1;
        }


        int jan1Day = (year + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400) % 7;

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        int monthOffset;

        if (month == 1) monthOffset = 0;
        else if (month == 2) monthOffset = 3;
        else if (month == 3) monthOffset = isLeapYear ? 4 : 3;
        else if (month == 4) monthOffset = isLeapYear ? 0 : 6;
        else if (month == 5) monthOffset = isLeapYear ? 2 : 1;
        else if (month == 6) monthOffset = isLeapYear ? 5 : 4;
        else if (month == 7) monthOffset = isLeapYear ? 0 : 6;
        else if (month == 8) monthOffset = isLeapYear ? 3 : 2;
        else if (month == 9) monthOffset = isLeapYear ? 6 : 5;
        else if (month == 10) monthOffset = isLeapYear ? 1 : 0;
        else if (month == 11) monthOffset = isLeapYear ? 4 : 3;
        else monthOffset = isLeapYear ? 6 : 5;

        int dayOfWeek = (jan1Day + monthOffset + (dayOfMonth - 1)) % 7;

        return dayOfWeek;
    }

    /**
     * Returns the day of the week that the date falls on
     *
     * @param month      name of the month
     * @param dayOfMonth day of the month
     * @param year       year
     * @return the day of the week that the date falls on
     */
    public static int dayOfWeek(String month, int dayOfMonth, int year) {

        int monthNumber = -1;
        month = month.toLowerCase();
        if (month.equals("january")) monthNumber = 1;
        else if (month.equals("february")) monthNumber = 2;
        else if (month.equals("march")) monthNumber = 3;
        else if (month.equals("april")) monthNumber = 4;
        else if (month.equals("may")) monthNumber = 5;
        else if (month.equals("june")) monthNumber = 6;
        else if (month.equals("july")) monthNumber = 7;
        else if (month.equals("august")) monthNumber = 8;
        else if (month.equals("september")) monthNumber = 9;
        else if (month.equals("october")) monthNumber = 10;
        else if (month.equals("november")) monthNumber = 11;
        else if (month.equals("december")) monthNumber = 12;


        if (monthNumber == -1) return -1;


        int daysInMonth;
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        if (monthNumber == 2) {
            daysInMonth = isLeapYear ? 29 : 28;
        } else if (monthNumber == 4 || monthNumber == 6 || monthNumber == 9 || monthNumber == 11) {
            daysInMonth = 30;
        } else {
            daysInMonth = 31;
        }

        if (dayOfMonth < 1 || dayOfMonth > daysInMonth) {
            return -1;
        }


        int jan1Day = (year + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400) % 7;


        int monthOffset = 0;
        if (monthNumber == 1) monthOffset = 0;
        else if (monthNumber == 2) monthOffset = 3;
        else if (monthNumber == 3) monthOffset = isLeapYear ? 4 : 3;
        else if (monthNumber == 4) monthOffset = isLeapYear ? 0 : 6;
        else if (monthNumber == 5) monthOffset = isLeapYear ? 2 : 1;
        else if (monthNumber == 6) monthOffset = isLeapYear ? 5 : 4;
        else if (monthNumber == 7) monthOffset = isLeapYear ? 0 : 6;
        else if (monthNumber == 8) monthOffset = isLeapYear ? 3 : 2;
        else if (monthNumber == 9) monthOffset = isLeapYear ? 6 : 5;
        else if (monthNumber == 10) monthOffset = isLeapYear ? 1 : 0;
        else if (monthNumber == 11) monthOffset = isLeapYear ? 4 : 3;
        else if (monthNumber == 12) monthOffset = isLeapYear ? 6 : 5;

        int dayOfWeek = (jan1Day + monthOffset + (dayOfMonth - 1)) % 7;

        return dayOfWeek;
    }
}

