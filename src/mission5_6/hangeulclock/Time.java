package mission5_6.hangeulclock;

import java.time.LocalTime;

class Time {
    LocalTime now = LocalTime.now();
    int hour = now.getHour();
    int minute = now.getMinute();
}
