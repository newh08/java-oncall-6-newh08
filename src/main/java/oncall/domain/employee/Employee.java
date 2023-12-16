package oncall.domain.employee;

import java.util.Objects;

public class Employee {
    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee compare) {
            return Objects.equals(this.name, compare.name);
        }
        return false;
    }
}
