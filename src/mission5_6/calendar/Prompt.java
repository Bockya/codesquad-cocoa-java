package mission5_6.calendar;

import mission5_6.hangeulclock.Checker;
import mission5_6.hangeulclock.HangeulClock;
import mission5_6.hangeulclock.Time;

import java.util.Scanner;

public class Prompt {
    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("명령 (clock: 시계 출력, cal: 달력 출력, q: 종료)");
            String cmd = scanner.next();
            if (cmd.equals("clock"))
                cmdClock();
            if (cmd.equals("cal"))
                cmdCal();
            if (cmd.equals("q")) {
                System.out.println("Thank you. Bye~");
                scanner.close();
                break;
            }
        }
    }

    private void cmdCal() {
    }

    private void cmdClock() {
        Time t;
        Checker c;
        HangeulClock hc;
        while (true) {
            t = new Time();
            System.out.println("hour: " + t.hour);
            System.out.println("minute: " + t.minute);
            c = new Checker(t);
            hc = new HangeulClock();
            hc.displayTime(c);
            try {
                Thread.sleep(60 * 1000); //1분 마다
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
