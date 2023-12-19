package oncall.service;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.date.Day;
import oncall.domain.employee.Employee;
import oncall.domain.employee.EmployeeProvider;
import oncall.domain.schedule.DaySchedule;
import oncall.domain.schedule.MonthSchedule;

public class ScheduleService {
    private static final int BUFFER = 20;
    private final EmployeeProvider employeeProvider;

    public ScheduleService(EmployeeProvider employeeProvider) {
        this.employeeProvider = employeeProvider;
    }

    public MonthSchedule makeMonthSchedule(Day firstDay) {
        int totalDate = firstDay.getTotalDate();
        List<DaySchedule> employeeSchedule = new ArrayList<>();
        Day day = firstDay;
        for (int i = 0; i < totalDate + BUFFER; i++) {
            Employee employee = employeeProvider.provideEmployee(day);
            DaySchedule daySchedule = new DaySchedule(day, employee);
            employeeSchedule.add(daySchedule);
            day = day.makeNextDay();
        }
        return new MonthSchedule(firstDay.getMonth(), employeeSchedule);
    }
}
