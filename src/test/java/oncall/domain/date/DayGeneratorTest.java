package oncall.domain.date;

import static oncall.domain.date.DateType.WEEK;
import static oncall.domain.date.DateType.WEEKEND;
import static oncall.domain.date.DateType.WEEK_HOLIDAY;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DayGeneratorTest {

    @DisplayName("1월 1일 금요일 생성 후 다음 날은 WEEKEND 이다.")
    @Test
    void datGenerateTest() {
        Day janFirst = DayGenerator.generateFirstDay(Month.JAN, DayOfWeek.FRI);
        Day nextDay = DayGenerator.generateDay(janFirst);
        assertThat(nextDay.checkDateType()).isEqualTo(WEEKEND);
    }

    @DisplayName("1월 1일 목요일 생성 후 다음 날은 WEEK 이다.")
    @Test
    void datGenerateTest2() {
        Day janFirst = DayGenerator.generateFirstDay(Month.JAN, DayOfWeek.THU);
        Day nextDay = DayGenerator.generateDay(janFirst);
        assertThat(nextDay.checkDateType()).isEqualTo(WEEK);
    }

    @DisplayName("10월 1일 월요일 생성 후 다다음 날(10월 3일 수요일)은 WEEK_HOLIDAY 이다.")
    @Test
    void datGenerateTest3() {
        Day octFirst = DayGenerator.generateFirstDay(Month.OCT, DayOfWeek.MON);
        Day nextDay = DayGenerator.generateDay(octFirst);
        Day nextNextDay = DayGenerator.generateDay(nextDay);
        assertThat(nextNextDay.checkDateType()).isEqualTo(WEEK_HOLIDAY);
    }
}