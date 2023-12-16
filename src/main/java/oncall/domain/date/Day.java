package oncall.domain.date;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day {
    private static final String WEEK_HOLIDAY_MESSAGE = "(휴일) ";

    private final Month month;
    private final Date date;
    private final DayOfWeek dayOfWeek;

    public Day(Month month, Date date, DayOfWeek dayOfWeek) {
        this.month = month;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }

    public Day makeNextDay() {
        return new Day(month, date.makeNextDate(), dayOfWeek.getNextDayOfWeek());
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

    private boolean isWeekHoliday() {
        return !isWeekend() && isHoliday();
    }

    public Month getMonth() {
        return month;
    }

    public int getTotalDate() {
        return month.getTotalDate();
    }

    @Override
    public String toString() {
        List<String> stringBuffer = new ArrayList<>();
        stringBuffer.add(month.toString());
        stringBuffer.add(date.toString());
        stringBuffer.add(dayOfWeek.toString());
        if (this.isWeekHoliday()) {
            stringBuffer.add(WEEK_HOLIDAY_MESSAGE);
        }
        return stringBuffer.stream().collect(Collectors.joining(" ",""," "));
    }
}
