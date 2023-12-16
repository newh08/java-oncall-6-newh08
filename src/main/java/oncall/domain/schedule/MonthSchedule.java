package oncall.domain.schedule;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.date.Month;

public class MonthSchedule {
    private final Month month;
    private final List<DaySchedule> daySchedules;

    public MonthSchedule(Month month, List<DaySchedule> daySchedules) {
        this.month = month;
        this.daySchedules = daySchedules;
    }

    private List<DaySchedule> findContinuousWork() {
        List<DaySchedule> continuousWorkDaySchedule = new ArrayList<>();
        for (int index = 0; index < daySchedules.size() - 1; index++) {
            int index_post = index + 1;
            DaySchedule daySchedule_pre = daySchedules.get(index);
            DaySchedule daySchedule_post = daySchedules.get(index_post);

            if (DaySchedule.isContinuousWork(daySchedule_pre, daySchedule_post)) {
                continuousWorkDaySchedule.add(daySchedule_post);
            }
        }
        return continuousWorkDaySchedule;
    }
}
