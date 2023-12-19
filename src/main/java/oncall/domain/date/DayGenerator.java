package oncall.domain.date;

public class DayGenerator {
    public static Day generateFirstDay(Month month, DayOfWeek firstDayOfWeek) {
        return new Day(month, new Date(1), firstDayOfWeek);
    }

    public static Day generateDay(Day day) {
        return day.makeNextDay();
    }
}
