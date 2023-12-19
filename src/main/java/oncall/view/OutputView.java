package oncall.view;

import oncall.domain.schedule.dto.MonthScheduleDto;

public class OutputView {
    public void printSchedule(MonthScheduleDto monthScheduleDto) {
        System.out.println(monthScheduleDto.getMonthSchedule());
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
