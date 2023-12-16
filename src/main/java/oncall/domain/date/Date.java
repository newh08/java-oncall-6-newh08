package oncall.domain.date;

public class Date {
    private final int date;

    public Date(int date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Date conpareDate) {
            return this.date == conpareDate.date;
        }
        return false;
    }
}
