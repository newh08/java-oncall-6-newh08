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

    public MonthSchedule adjustSchedule() {
        List<DaySchedule> continuousWork = findContinuousWork();
        if (continuousWork.isEmpty()) {
            return this;
        }

        List<DaySchedule> newDaySchedule = new ArrayList<>(daySchedules);
        for (DaySchedule daySchedule : continuousWork) {
            DaySchedule nextSameDateType = findNextSameDateType(daySchedule);
            int indexOne = daySchedules.indexOf(daySchedule);
            int indexTwo = daySchedules.indexOf(nextSameDateType);
            List<DaySchedule> newDaySchedules = daySchedule.changeEmployee(nextSameDateType);
            newDaySchedule.set(indexOne, newDaySchedules.get(0));
            newDaySchedules.set(indexTwo, newDaySchedules.get(1));
        }
        return new MonthSchedule(month, newDaySchedule);
    }

    private DaySchedule findNextSameDateType(DaySchedule daySchedule) {
        int index = daySchedules.indexOf(daySchedule);
        DaySchedule nextDaySchedule;
        if (daySchedule.isWeek()) {
            do {
                index += 1;
                nextDaySchedule = daySchedules.get(index);
            } while (nextDaySchedule.isWeek());
            return daySchedules.get(index);
        }
        do {
            index += 1;
            nextDaySchedule = daySchedules.get(index);
        } while (!nextDaySchedule.isWeek());
        return daySchedules.get(index);
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
