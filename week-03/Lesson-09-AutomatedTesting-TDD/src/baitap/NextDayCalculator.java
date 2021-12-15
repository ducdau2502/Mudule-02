package baitap;

public class NextDayCalculator {
    public static String NextDay(int day, int month, int year) {
        int daysOfMonth = getDaysOfMonth(month, year);
        if (day == daysOfMonth) {
            day = 1;
            if (month == 12) {
                month = 1;
                year++;
            } else month++;
        } else day++;
        return "" + day + "-" + month + "-" + year;
    }

    public static boolean isLeapYear(int year) {
        boolean isDivisibleBy4 = year % 4 == 0;
        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = year % 100 == 0;
            if (isDivisibleBy100) {
                boolean isDivisibleBy400 = year % 400 == 0;
                if (isDivisibleBy400) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static int getDaysOfMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                boolean isLeapYear = isLeapYear(year);
                if (isLeapYear) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }
}

