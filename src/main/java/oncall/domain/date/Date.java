package oncall.domain.date;

public class Date {
    private static final String DATE_MESSAGE = "일";
    private final int date;

    public Date(int date) {
        this.date = date;
    }

    public Date makeNextDate() {
        return new Date(date + 1);
    }

    @Override
    public String toString() {
        return date + DATE_MESSAGE;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Date conpareDate) {
            return this.date == conpareDate.date;
        }
        return false;
    }
}
