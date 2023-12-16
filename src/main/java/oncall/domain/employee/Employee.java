package oncall.domain.employee;

import java.util.Objects;
import oncall.util.exception.ErrorMessage;
import oncall.util.exception.MyIllegalArgumentException;

public class Employee {
    private final String name;

    public Employee(String name) {
        validateEmployeeName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateEmployeeName(String name) {
        if (name.length() > 5) {
            throw new MyIllegalArgumentException(ErrorMessage.TOO_LONG_EMPLOYEE_NAME);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee compare) {
            return Objects.equals(this.name, compare.name);
        }
        return false;
    }
}
