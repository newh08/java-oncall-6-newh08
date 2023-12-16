package oncall.domain.schedule;

import oncall.domain.date.Day;
import oncall.domain.employee.Employee;

public class DaySchedule {
    private final Day day;
    private final Employee employee;

    public DaySchedule(Day day, Employee employee) {
        this.day = day;
        this.employee = employee;
    }
}
