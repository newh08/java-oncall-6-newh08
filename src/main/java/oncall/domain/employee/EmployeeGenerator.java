package oncall.domain.employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeGenerator {
    public static List<WeekWorkEmployee> generateWeekWorkEmployees(String input) {
        return Arrays.stream(input.split(","))
                .map(WeekWorkEmployee::new)
                .toList();
    }

    public static List<WeekendWorkEmployee> generateWeekendWorkEmployees(String input) {
        return Arrays.stream(input.split(","))
                .map(WeekendWorkEmployee::new)
                .toList();
    }
}
