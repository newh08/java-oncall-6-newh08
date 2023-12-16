package oncall.util.converter;

import oncall.domain.schedule.MonthSchedule;
import oncall.domain.schedule.dto.MonthScheduleDto;

public class DomainConverter {
    private static DomainConverter instance;

    private DomainConverter() {
    }

    public static DomainConverter getInstance() {
        if (instance == null) {
            instance = new DomainConverter();
        }
        return instance;
    }

    public MonthScheduleDto makeMonthScheduleDto(MonthSchedule monthSchedule) {
        return new MonthScheduleDto(monthSchedule.toString());
    }
}