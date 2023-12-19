package oncall.domain.schedule;

import java.util.List;
import oncall.domain.date.Day;
import oncall.domain.employee.Employee;

public class DaySchedule {
    private final Day day;
    private final Employee employee;

    public DaySchedule(Day day, Employee employee) {
        this.day = day;
        this.employee = employee;
    }

    public static boolean isContinuousWork(DaySchedule daySchedule_pre, DaySchedule daySchedule_post) {
        return daySchedule_pre.employee.equals(daySchedule_post.employee);
    }

    public boolean isWeek() {
        return day.checkDateType().isWeek();
    }

    public List<DaySchedule> changeEmployee(DaySchedule otherDaySchedule) {
        DaySchedule firstDaySchedule = new DaySchedule(this.day, otherDaySchedule.employee);
        DaySchedule secondDaySchedule = new DaySchedule(otherDaySchedule.day, this.employee);
        return List.of(firstDaySchedule, secondDaySchedule);
    }

    public String toString() {
        return day.toString() + employee.getName();
    }
}
