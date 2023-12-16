package oncall.domain.date;

import static oncall.domain.date.DateType.WEEK;
import static oncall.domain.date.DateType.WEEKEND;
import static oncall.domain.date.DateType.WEEK_HOLIDAY;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DayTest {

    @DisplayName("평일이면서 공휴일인 경우 WEEK_HOLIDAY 를 반환한다.")
    @Test
    void dateTest1() {
        Day day = new Day(Month.DEC, new Date(25), DayOfWeek.MON);
        assertThat(day.checkDateType()).isEqualTo(WEEK_HOLIDAY);
    }

    @DisplayName("주말이면서 공휴일인 경우 WEEKEND 를 반환한다.")
    @Test
    void dateTest2() {
        Day day = new Day(Month.DEC, new Date(25), DayOfWeek.SUN);
        assertThat(day.checkDateType()).isEqualTo(WEEKEND);
    }

    @DisplayName("평일이면서 공휴일이 아닌경우 WEEK 를 반환한다.")
    @Test
    void dateTest3() {
        Day day = new Day(Month.DEC, new Date(26), DayOfWeek.MON);
        assertThat(day.checkDateType()).isEqualTo(WEEK);
    }
}