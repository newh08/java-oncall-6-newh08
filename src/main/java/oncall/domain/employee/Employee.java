package oncall.domain.employee;

public class Employee {
    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }
}
