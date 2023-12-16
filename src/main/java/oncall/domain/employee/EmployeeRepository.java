package oncall.domain.employee;

import java.util.List;
import oncall.util.exception.ErrorMessage;
import oncall.util.exception.MyIllegalArgumentException;

public class EmployeeRepository {
    private static final int MIN_EMPLOYEES_NUMBER = 5;
    private static final int MAX_EMPLOYEES_NUMBER = 35;

    private final List<WeekWorkEmployee> weekWorkEmployees;
    private final List<WeekendWorkEmployee> weekendWorkEmployees;

    public EmployeeRepository(List<WeekWorkEmployee> weekWorkEmployees,
                              List<WeekendWorkEmployee> weekendWorkEmployees) {
        validateEmployees(weekWorkEmployees, weekendWorkEmployees);

        this.weekWorkEmployees = weekWorkEmployees;
        this.weekendWorkEmployees = weekendWorkEmployees;
    }

    private void validateEmployees(List<WeekWorkEmployee> weekWorkEmployees,
                                   List<WeekendWorkEmployee> weekendWorkEmployees) {
        if (weekWorkEmployees.size() < MIN_EMPLOYEES_NUMBER || weekWorkEmployees.size() > MAX_EMPLOYEES_NUMBER) {
            throw new MyIllegalArgumentException(ErrorMessage.WRONG_EMPLOYEE_NUMBER);
        }
        validateSameWeekWorkEmployee(weekWorkEmployees);
        validateSameWeekendWorkEmployee(weekendWorkEmployees);
    }

    private static void validateSameWeekendWorkEmployee(List<WeekendWorkEmployee> weekendWorkEmployees) {
        if (weekendWorkEmployees.stream().distinct().count() != weekendWorkEmployees.size()) {
            throw new MyIllegalArgumentException(ErrorMessage.NOT_SAME_EMPLOYEE_IN_ONE_WORK);
        }
    }

    private static void validateSameWeekWorkEmployee(List<WeekWorkEmployee> weekWorkEmployees) {
        if (weekWorkEmployees.stream().distinct().count() != weekWorkEmployees.size()) {
            throw new MyIllegalArgumentException(ErrorMessage.NOT_SAME_EMPLOYEE_IN_ONE_WORK);
        }
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
