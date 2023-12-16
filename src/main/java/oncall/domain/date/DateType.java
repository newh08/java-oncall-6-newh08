package oncall.domain.date;

public enum DateType {
    WEEK,
    WEEKEND,
    WEEK_HOLIDAY;

    public boolean isWeek() {
        return this == WEEK;
    }
}
