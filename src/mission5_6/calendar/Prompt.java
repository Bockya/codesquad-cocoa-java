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
                cmdCal(scanner);
            if (cmd.equals("q")) {
                System.out.println("Thank you. Bye~");
                scanner.close();
                break;
            }
        }
    }

    private void cmdCal(Scanner scanner) {
        Calendar cal = new Calendar();
        //2020년 11월 달력 출력
        int year = 2020;
        int month = 11;
        cal.printCalendar(year, month);
        System.out.println("선택 (1: 특정 월의 달력, 2: 특정 년의 전체 달력)");
        int choice = scanner.nextInt();
        //년도와 월 입력받아 출력
        if (choice == 1) {
            System.out.println("년도를 입력하세요");
            System.out.print("YEAR> ");
            year = scanner.nextInt();
            System.out.println("달을 입력하세요");
            System.out.print("MONTH> ");
            month = scanner.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("잘못된 입력입니다");
                return;
            }
            cal.printCalendar(year, month);
        }
        //특정년도 전체 달력 출력
        if (choice == 2) {
            System.out.println("년도를 입력하세요");
            year = scanner.nextInt();
            System.out.println(year + "년 전체 달력입니다");
            cal.printCalendar(year);
        }
    }

    private void cmdClock() {
        Time t;
        Checker c;
        HangeulClock hc;
        while (true) {
            t = new Time();
            System.out.println("현재 시각 " + t.hour + ":" + t.minute);
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
