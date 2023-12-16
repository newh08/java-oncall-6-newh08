package oncall.domain.date;

import java.util.Arrays;

public enum DayOfWeek {
    SUN(0), MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6);
    private static final int NUMBER_OF_DAY_OF_WEEK = 7;
    private final int code;

    DayOfWeek(int code) {
        this.code = code;
    }

    public static boolean checkWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek.equals(SUN) || dayOfWeek.equals(SAT);
    }

    public DayOfWeek getNextDayOfWeek() {
        int nextDayOfWeekCode = this.code + 1 % NUMBER_OF_DAY_OF_WEEK;
        return Arrays.stream(values()).filter(dayOfWeek -> dayOfWeek.code == nextDayOfWeekCode)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
