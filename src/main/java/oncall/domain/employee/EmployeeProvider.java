package oncall.domain.employee;

import oncall.domain.date.DateType;
import oncall.domain.date.Day;

public class EmployeeProvider {
    private final EmployeeRepository employeeRepository;
    private int weekIndex;
    private int weekendIndex;

    private EmployeeProvider(EmployeeRepository employeeRepository, int weekIndex, int weekendIndex) {
        this.employeeRepository = employeeRepository;
        this.weekIndex = weekIndex;
        this.weekendIndex = weekendIndex;
    }

    public static EmployeeProvider initializeEmployeeProvider(EmployeeRepository employeeRepository) {
        return new EmployeeProvider(employeeRepository, 0, 0);
    }

    public Employee provideEmployee(Day day) {
        DateType dateType = day.checkDateType();
        if (dateType == DateType.WEEK) {
            int buffer = weekIndex;
            weekIndex = (weekIndex + 1) % employeeRepository.getNumberOfEmployee();
            return employeeRepository.getWeekWorkEmployee(buffer);
        }
        int buffer = weekendIndex;
        weekendIndex = (weekendIndex + 1) % employeeRepository.getNumberOfEmployee();
        return employeeRepository.getWeekendWorkEmployees(buffer);
    }
}
