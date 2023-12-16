package oncall.domain.date;

public enum DayOfWeek {
    SUN(0), MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6);
    private final int code;

    DayOfWeek(int code) {
        this.code = code;
    }

    public static boolean checkWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek.equals(SUN) || dayOfWeek.equals(SAT);
    }
}
