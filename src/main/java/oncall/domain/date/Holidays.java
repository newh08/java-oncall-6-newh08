package oncall.domain.date;

import static oncall.domain.date.Month.AUG;
import static oncall.domain.date.Month.DEC;
import static oncall.domain.date.Month.JAN;
import static oncall.domain.date.Month.JUN;
import static oncall.domain.date.Month.MAR;
import static oncall.domain.date.Month.MAY;
import static oncall.domain.date.Month.OCT;

import java.util.Arrays;

public enum Holidays {
    NEW_YEAR_DAY(JAN, new Date(1)),
    INDEPENDENCE_MOVEMENT_DAY(MAR,new Date(1)),
    CHILDREN_DAY(MAY, new Date(5)),
    LAW_DAY(JUN, new Date(6)),
    LIBERATION_DAY(AUG, new Date(15)),
    OPEN_SKY_DAY(OCT, new Date(3)),
    HANGUL_DAY(OCT,new Date(9)),
    CHRISTMAS_DAY(DEC,new Date(25));

    private final Month monthOfHoliday;
    private final Date dateOfHoliday;

    Holidays(Month monthOfHoliday, Date dateOfHoliday) {
        this.monthOfHoliday = monthOfHoliday;
        this.dateOfHoliday = dateOfHoliday;
    }

    public static boolean checkHoliday(Month month, Date date) {
        return Arrays.stream(Holidays.values())
                .anyMatch(holidays -> holidays.checkMonthAndDate(month, date));
    }

    private boolean checkMonthAndDate(Month month, Date date) {
        return checkMonth(month) && checkDate(date);
    }

    private boolean checkDate(Date date) {
        return this.dateOfHoliday.equals(date);
    }

    private boolean checkMonth(Month month) {
        return this.monthOfHoliday.equals(month);
    }
}
