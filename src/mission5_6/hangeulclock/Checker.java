package mission5_6.hangeulclock;

class Checker {
    boolean[][] checker = new boolean[6][6];

    public Checker(Time t) {
        if (t.hour == 0 && t.minute == 0) { //자정일 때
            isTwelveOClock(t);
            return;
        }
        if (t.hour == 12 && t.minute == 0) { //정오일 때
            isTwelveOClock(t);
            return;
        }
        checkHour(t);
        if (t.minute != 0)
            checkMinute(t);
    }

    public void isTwelveOClock(Time t) {
        this.checker[4][0] = true; //'정'
        if (t.hour == 0 && t.minute == 0)
            this.checker[3][0] = true; //'자'
        if (t.hour == 12 && t.minute == 0) {
            this.checker[5][0] = true; //'오'
        }
    }

    public void checkHour(Time t) {
        this.checker[2][5] = true; //'시'
        switch (t.hour) {
            case 1:
            case 13:
                this.checker[0][0] = true; //'한'
                break;
            case 2:
            case 14:
                this.checker[0][1] = true; //'두'
                break;
            case 3:
            case 15:
                this.checker[0][2] = true; //'세'
                break;
            case 4:
            case 16:
                this.checker[0][3] = true; //'네'
                break;
            case 5:
            case 17:
                this.checker[0][4] = true; //'다'
                this.checker[0][5] = true; //'섯'
                break;
            case 6:
            case 18:
                this.checker[1][0] = true; //'여'
                this.checker[1][1] = true; //'섯'
                break;
            case 7:
            case 19:
                this.checker[1][2] = true; //'일'
                this.checker[1][3] = true; //'곱'
                break;
            case 8:
            case 20:
                this.checker[1][4] = true; //'여'
                this.checker[1][5] = true; //'덟'
                break;
            case 9:
            case 21:
                this.checker[2][0] = true; //'아'
                this.checker[2][1] = true; //'홉'
                break;
            case 10:
            case 22:
                this.checker[2][2] = true; //'열'
                break;
            case 11:
            case 23:
                this.checker[2][2] = true; //'열'
                this.checker[2][3] = true; //'한'
                break;
            case 12:
            case 0:
                this.checker[2][2] = true; //'열'
                this.checker[2][4] = true; //'두'
                break;
        }
    }

    public void checkMinute(Time t) {
        this.checker[5][5] = true; //'분'
        switch (t.minute % 10) { //한 자릿수
            case 1:
                this.checker[4][1] = true; //'일'
                break;
            case 2:
                this.checker[4][2] = true; //'이'
                break;
            case 3:
                this.checker[4][3] = true; //'삼'
                break;
            case 4:
                this.checker[4][4] = true; //'사'
                break;
            case 5:
                this.checker[5][1] = true; //'오'
                break;
            case 6:
                this.checker[4][5] = true; //'육'
                break;
            case 7:
                this.checker[5][2] = true; //'칠'
                break;
            case 8:
                this.checker[5][3] = true; //'팔'
                break;
            case 9:
                this.checker[5][4] = true; //'구'
                break;
        }
        if (t.minute > 9) { //두 자릿수
            this.checker[3][5] = true; //'십'
            switch (t.minute / 10) {
                case 2:
                    this.checker[3][1] = true; //'이'
                    break;
                case 3:
                    this.checker[3][2] = true; //'삼'
                    break;
                case 4:
                    this.checker[3][3] = true; //'사'
                    break;
                case 5:
                    this.checker[3][4] = true; //'오'
                    break;
            }
        }
    }
}