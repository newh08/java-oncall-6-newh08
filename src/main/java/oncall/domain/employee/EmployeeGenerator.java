package oncall.domain.employee;

import java.util.List;

public class EmployeeGenerator {
    public static List<WeekWorkEmployee> generateWeekWorkEmployees(List<String> input) {
        return input.stream()
                .map(WeekWorkEmployee::new)
                .toList();
    }

    public static List<WeekendWorkEmployee> generateWeekendWorkEmployees(List<String> input) {
        return input.stream()
                .map(WeekendWorkEmployee::new)
                .toList();
    }
}
