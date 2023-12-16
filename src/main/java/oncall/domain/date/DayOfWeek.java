package oncall.domain.date;

import java.util.Arrays;
import java.util.Objects;
import oncall.util.exception.ErrorMessage;
import oncall.util.exception.MyIllegalArgumentException;

public enum DayOfWeek {
    SUN(0, "일"), MON(1, "월"), TUE(2, "화"), WED(3, "수"),
    THU(4, "목"), FRI(5, "금"), SAT(6, "토");
    private static final int NUMBER_OF_DAY_OF_WEEK = 7;

    private final int code;
    private final String dayOfWeek;

    DayOfWeek(int code, String dayOfWeek ) {
        this.code = code;
        this.dayOfWeek = dayOfWeek;
    }

    public static boolean checkWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek.equals(SUN) || dayOfWeek.equals(SAT);
    }

    public DayOfWeek getNextDayOfWeek() {
        int nextDayOfWeekCode = (this.code + 1) % NUMBER_OF_DAY_OF_WEEK;
        return Arrays.stream(values()).filter(dayOfWeek -> dayOfWeek.code == nextDayOfWeekCode)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static DayOfWeek getDayOfWeek(String dayOfWeek) {
        return Arrays.stream(values())
                .filter(day -> Objects.equals(day.dayOfWeek, dayOfWeek))
                .findAny()
                .orElseThrow(() -> new MyIllegalArgumentException(ErrorMessage.NOT_DAY_OF_WEEK));
    }

    @Override
    public String toString() {
        return dayOfWeek;
    }
}
