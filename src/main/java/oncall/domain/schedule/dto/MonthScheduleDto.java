package oncall.domain.schedule.dto;

public class MonthScheduleDto {
    private final String monthSchedule;

    public MonthScheduleDto(String monthSchedule) {
        this.monthSchedule = monthSchedule;
    }

    public String getMonthSchedule() {
        return monthSchedule;
    }
}
