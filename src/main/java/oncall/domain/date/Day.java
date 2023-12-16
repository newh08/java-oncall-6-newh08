package oncall.domain.date;

public class Day {
    private final Month month;
    private final Date date;
    private final DayOfWeek dayOfWeek;

    public Day(Month month, Date date, DayOfWeek dayOfWeek) {
        this.month = month;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }

    public DateType checkDateType() {
        if (isWeekend()) {
            return DateType.WEEKEND;
        }
        if (isHoliday()) {
            return DateType.WEEK_HOLIDAY;
        }
        return DateType.WEEK;
    }

    private boolean isWeekend() {
        return DayOfWeek.checkWeekend(dayOfWeek);
    }

    private boolean isHoliday() {
        return Holidays.checkHoliday(month, date);
    }
}
