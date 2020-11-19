package mission5_6.hangeulclock;

class HangeulClock {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m"; //콘솔 색상 Cyan
    String[] hangeul = {"한두세네다섯",
            "여섯일곱여덟",
            "아홉열한두시",
            "자이삼사오십",
            "정일이삼사육",
            "오오칠팔구분"};

    private void displayTime(Checker c) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                char ch = hangeul[i].charAt(j);
                if (c.checker[i][j]) {
                    System.out.print(ANSI_CYAN + ch + " " + ANSI_RESET);
                    continue;
                }
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Time t;
        Checker c;
        HangeulClock hc;
        while (true) {
            t = new Time();
            System.out.println("now: " + t.now);
            System.out.println("hour: " + t.hour);
            System.out.println("minute: " + t.minute);
            c = new Checker(t);
            hc = new HangeulClock();
            hc.displayTime(c);
            Thread.sleep(60 * 1000); //1분 마다
        }
    }
}