package mission5_6.calendar;

public class Calendar {
    private final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private int getMaxDaysofMonth(int year, int month) {
        if (isLeapYear(year))
            return LEAP_MAX_DAYS[month];
        else
            return MAX_DAYS[month];
    }

    private int getWeekday(int year, int month, int day) {
        int syear = 1970;
        final int STANDARD_WEEKDAY = 4; //1970-1-1 (목)
        int cnt = 0;
        for (int i = syear; i < year; i++) {
            int delta = isLeapYear(i) ? 366 : 365;
            cnt += delta;
        }
        for (int i = 0; i < month; i++) {
            int delta = getMaxDaysofMonth(year, i);
            cnt += delta;
        }
        cnt += day - 1;
        return (cnt + STANDARD_WEEKDAY) % 7;
    }

    public void printCalendar(int year, int month) {
        System.out.printf("    <<%4d년 %2d월>>\n", year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("----------------------");
        //get weekday automatically
        int weekday = getWeekday(year, month, 1);
        //print blank space
        for (int i = 0; i < weekday; i++)
            System.out.print("   ");
        int maxday = getMaxDaysofMonth(year, month);
        int cnt = 7 - weekday;
        int dlm = (cnt < 7) ? cnt : 0;
        //print first line
        for (int i = 1; i <= cnt; i++)
            System.out.printf("%3d", i);
        System.out.println();
        //print from second line to last
        cnt++;
        for (int i = cnt; i <= maxday; i++) {
            System.out.printf("%3d", i);
            if (i % 7 == dlm)
                System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
