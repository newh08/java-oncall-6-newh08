package oncall.domain.employee;

import java.util.List;

public class EmployeeRepository {
    private final List<WeekWorkEmployee> weekWorkEmployees;
    private final List<WeekendWorkEmployee> weekendWorkEmployees;

    public EmployeeRepository(List<WeekWorkEmployee> weekWorkEmployees,
                              List<WeekendWorkEmployee> weekendWorkEmployees) {
        this.weekWorkEmployees = weekWorkEmployees;
        this.weekendWorkEmployees = weekendWorkEmployees;
    }

    public WeekWorkEmployee getWeekWorkEmployee(int index) {
        return weekWorkEmployees.get(index);
    }

    public WeekendWorkEmployee getWeekendWorkEmployees(int index) {
        return weekendWorkEmployees.get(index);
    }

    public int getNumberOfEmployee() {
        return weekWorkEmployees.size();
    }
}
