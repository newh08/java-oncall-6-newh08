package oncall.domain.schedule;

import java.util.List;
import oncall.domain.date.Month;

public class MonthSchedule {
    private final Month month;
    private final List<DaySchedule> daySchedules;

    public MonthSchedule(Month month, List<DaySchedule> daySchedules) {
        this.month = month;
        this.daySchedules = daySchedules;
    }
}
