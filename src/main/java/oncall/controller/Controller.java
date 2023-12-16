package oncall.controller;

import java.util.List;
import java.util.function.Supplier;
import oncall.domain.date.Day;
import oncall.domain.date.DayGenerator;
import oncall.domain.date.DayOfWeek;
import oncall.domain.date.Month;
import oncall.domain.employee.EmployeeGenerator;
import oncall.domain.employee.EmployeeProvider;
import oncall.domain.employee.EmployeeRepository;
import oncall.domain.employee.WeekWorkEmployee;
import oncall.domain.employee.WeekendWorkEmployee;
import oncall.domain.schedule.MonthSchedule;
import oncall.domain.schedule.dto.MonthScheduleDto;
import oncall.service.ScheduleService;
import oncall.util.converter.DomainConverter;
import oncall.view.InputView;
import oncall.view.OutputView;
import oncall.view.dto.InputMonthAndDayDto;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final DomainConverter domainConverter;

    public Controller(InputView inputView, OutputView outputView, DomainConverter domainConverter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.domainConverter = domainConverter;
    }

    public void run() {
        Day firstDay = repeat(this::makeFirstDay);
        EmployeeRepository employeeRepository = repeat(this::makeEmployeeRepository);
        MonthSchedule monthSchedule = makeMonthSchedule(firstDay, employeeRepository);
        MonthScheduleDto monthScheduleDto = domainConverter.makeMonthScheduleDto(monthSchedule);
        outputView.printSchedule(monthScheduleDto);
    }

    private Day makeFirstDay() {
        InputMonthAndDayDto inputMonthAndDayDto = inputView.readMonthAndDay();
        Month month = Month.getMonth(inputMonthAndDayDto.month());
        DayOfWeek dayOfWeek = DayOfWeek.getDayOfWeek(inputMonthAndDayDto.dayOfWeek());
        return DayGenerator.generateFirstDay(month, dayOfWeek);
    }

    private EmployeeRepository makeEmployeeRepository() {
        List<WeekWorkEmployee> weekWorkEmployees = EmployeeGenerator.generateWeekWorkEmployees(
                inputView.readWeekWorkEmployee());
        List<WeekendWorkEmployee> weekendWorkEmployees = EmployeeGenerator.generateWeekendWorkEmployees(
                inputView.readWeekendWorkEmployee());
        return new EmployeeRepository(weekWorkEmployees, weekendWorkEmployees);
    }

    private MonthSchedule makeMonthSchedule(Day firstDay, EmployeeRepository employeeRepository) {
        EmployeeProvider employeeProvider = EmployeeProvider.initializeEmployeeProvider(employeeRepository);
        ScheduleService scheduleService = new ScheduleService(employeeProvider);
        MonthSchedule monthSchedule = scheduleService.makeMonthSchedule(firstDay);
        return monthSchedule.adjustSchedule();
    }

    private <T> T repeat(Supplier<T> something) {
        while (true) {
            try {
                return something.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }
}
