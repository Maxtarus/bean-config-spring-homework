package ru.sber_java_school.spring.task1.data;

public enum Mark {
    EXCELLENT(5),
    GOOD(4),
    SATISFACTORY(3),
    UNSATISFACTORY(2);

    private final int digitMark;

    Mark(int digitMark) {
        this.digitMark = digitMark;
    }

    public int getDigitMark() {
        return digitMark;
    }

    public Mark convertDigitMarkToString(int digitMark) {
        Mark mark = null;
        switch (digitMark) {
            case 5:
                mark = Mark.EXCELLENT;
                break;
            case 4:
                mark = Mark.GOOD;
                break;
            case 3:
                mark = Mark.SATISFACTORY;
                break;
            case 2:
                mark = Mark.UNSATISFACTORY;
                break;
        }
        return mark;
    }
}
