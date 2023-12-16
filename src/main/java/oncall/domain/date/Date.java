package oncall.domain.date;

public class Date {
    private final int date;

    public Date(int date) {
        this.date = date;
    }

    public Date makeNextDate() {
        return new Date(date + 1);
    }

    @Override
    public String toString() {
        return date + "일";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Date conpareDate) {
            return this.date == conpareDate.date;
        }
        return false;
    }
}
