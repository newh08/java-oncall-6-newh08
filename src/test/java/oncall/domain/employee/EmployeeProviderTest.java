package oncall.domain.employee;

import static org.assertj.core.api.Assertions.assertThat;

import oncall.domain.date.Day;
import oncall.domain.date.DayGenerator;
import oncall.domain.date.DayOfWeek;
import oncall.domain.date.Month;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeProviderTest {

    @DisplayName("EmployeeProvider 는 Week, Weekend 에 알맞게 Employee 를 반환한다.")
    @Test
    void employeeProviderTest() {
        String employeeName = "1,2,3,4,5,6";

        EmployeeRepository employeeRepository = new EmployeeRepository(
                EmployeeGenerator.generateWeekWorkEmployees(employeeName),
                EmployeeGenerator.generateWeekendWorkEmployees(employeeName));
        EmployeeProvider employeeProvider = EmployeeProvider.initializeEmployeeProvider(employeeRepository);
        Day weekDay = DayGenerator.generateFirstDay(Month.APR, DayOfWeek.MON);
        Day weekendDay = DayGenerator.generateFirstDay(Month.APR, DayOfWeek.SUN);

        Employee employee1_Week = employeeProvider.provideEmployee(weekDay);
        Employee employee2_Week = employeeProvider.provideEmployee(weekDay);
        Employee employee1_Weekend = employeeProvider.provideEmployee(weekendDay);
        Employee employee2_Weekend = employeeProvider.provideEmployee(weekendDay);
        Employee employee3_Week = employeeProvider.provideEmployee(weekDay);
        Employee employee4_Week = employeeProvider.provideEmployee(weekDay);
        Employee employee5_Week = employeeProvider.provideEmployee(weekDay);
        Employee employee6_Week = employeeProvider.provideEmployee(weekDay);
        Employee employee7_Week = employeeProvider.provideEmployee(weekDay);

        assertThat(employee1_Week.getName()).isEqualTo("1");
        assertThat(employee2_Week.getName()).isEqualTo("2");
        assertThat(employee1_Weekend.getName()).isEqualTo("1");
        assertThat(employee2_Weekend.getName()).isEqualTo("2");
        assertThat(employee3_Week.getName()).isEqualTo("3");
        assertThat(employee4_Week.getName()).isEqualTo("4");
        assertThat(employee5_Week.getName()).isEqualTo("5");
        assertThat(employee6_Week.getName()).isEqualTo("6");
        assertThat(employee7_Week.getName()).isEqualTo("1");
    }
}