package mission5_6.hangeulclock;

import java.time.LocalTime;

public class Time {
    public int hour;
    public int minute;
    public Time(){
        LocalTime now = LocalTime.now();
        hour =now.getHour();
        minute =now.getMinute();
    }

}
